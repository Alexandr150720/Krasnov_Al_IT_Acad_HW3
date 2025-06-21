package by.it_academy.jd2.mk_jd2_111_25_7.dto;

import java.util.LinkedHashMap;
import java.util.List;

public class ResultDTO {

    LinkedHashMap<String, Integer> performers;
    LinkedHashMap<String, Integer> genres;
    List<String> aboutTexts;

    public ResultDTO(LinkedHashMap<String, Integer> performers, LinkedHashMap<String, Integer> genres, List<String> aboutTexts) {
        this.performers = performers;
        this.genres = genres;
        this.aboutTexts = aboutTexts;
    }

    public LinkedHashMap<String, Integer> getPerformers() {
        return performers;
    }

    public LinkedHashMap<String, Integer> getGenres() {
        return genres;
    }

    public List<String> getAboutTexts() {
        return aboutTexts;
    }
}
