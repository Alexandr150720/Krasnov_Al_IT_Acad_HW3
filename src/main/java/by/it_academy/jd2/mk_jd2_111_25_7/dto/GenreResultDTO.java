package by.it_academy.jd2.mk_jd2_111_25_7.dto;

import java.util.LinkedHashMap;

public class GenreResultDTO {

    LinkedHashMap<String, Integer> genres;

    public GenreResultDTO(LinkedHashMap<String, Integer> genres) {
        this.genres = genres;
    }

    public LinkedHashMap<String, Integer> getGenres() {
        return genres;
    }
}
