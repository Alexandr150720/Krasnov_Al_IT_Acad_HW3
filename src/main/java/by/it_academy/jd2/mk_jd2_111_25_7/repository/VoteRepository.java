package by.it_academy.jd2.mk_jd2_111_25_7.repository;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.ResultDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.VoteDTO;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class VoteRepository implements IVoteRepository{
    private static final VoteRepository instance = new VoteRepository();
    private final Map<String, Integer> performers = new ConcurrentHashMap<>();
    private final Map<String, Integer> genres = new ConcurrentHashMap<>();
    private final List<String> aboutTexts = Collections.synchronizedList(new ArrayList<>());

    private VoteRepository() {
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

    public static VoteRepository getInstance() {
        return instance;
    }

    public synchronized void addVote(VoteDTO voteDTO) {
        performers.put(voteDTO.getSinger(), performers.get(voteDTO.getSinger()) + 1);
        for (String genre : voteDTO.getSelectedGenres()) {
            genres.put(genre, genres.get(genre) + 1);
        }
        aboutTexts.add(new Date() + ": " + voteDTO.getAbout());
    }

    public Set<String> getPerformers() {
        return performers.keySet();
    }

    public Set<String> getGenres() {
        return genres.keySet();
    }

    public List<String> getAboutTexts() {
        return new ArrayList<>(aboutTexts);
    }

    @Override
    public ResultDTO getResult() {
        LinkedHashMap<String, Integer> performersCopy = new LinkedHashMap<>(performers);
        LinkedHashMap<String, Integer> genresCopy = new LinkedHashMap<>(genres);
        List<String> aboutTextsCopy = new ArrayList<>(aboutTexts);

        return new ResultDTO(performersCopy, genresCopy, aboutTextsCopy);
    }


}
