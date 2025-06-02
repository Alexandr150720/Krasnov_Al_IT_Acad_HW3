package by.it_academy.jd2.mk_jd2_111_25_7;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DataStorage {
    private static final DataStorage instance = new DataStorage();
    private final Map<String, Integer> performers = new ConcurrentHashMap<>();
    private final Map<String, Integer> genres = new ConcurrentHashMap<>();
    private final List<String> aboutTexts = Collections.synchronizedList(new ArrayList<>());

    private DataStorage() {
        performers.put("T-Fest", 0);
        performers.put("V$XVP PRINCE", 0);
        performers.put("Scriptonit", 0);
        performers.put("Kizaru", 0);

        genres.put("Джаз", 0);
        genres.put("Рок", 0);
        genres.put("Хип-хоп", 0);
        genres.put("Шансон", 0);
        genres.put("Блюз", 0);
        genres.put("Кантри", 0);
        genres.put("Регги", 0);
        genres.put("Фонк", 0);
        genres.put("Классика", 0);
        genres.put("Рэп", 0);
    }

    public static DataStorage getInstance() {
        return instance;
    }

    public synchronized void addVote(String singer, String[] selectedGenres, String about) {
        performers.put(singer, performers.get(singer) + 1);
        for (String genre : selectedGenres) {
            genres.put(genre, genres.get(genre) + 1);
        }
        aboutTexts.add(new Date() + ": " + about);
    }

    public Map<String, Integer> getPerformers() {
        return new HashMap<>(performers);
    }

    public Map<String, Integer> getGenres() {
        return new HashMap<>(genres);
    }

    public List<String> getAboutTexts() {
        return new ArrayList<>(aboutTexts);
    }
}
