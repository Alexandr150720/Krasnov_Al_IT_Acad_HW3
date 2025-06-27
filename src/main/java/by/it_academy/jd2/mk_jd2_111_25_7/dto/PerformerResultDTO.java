package by.it_academy.jd2.mk_jd2_111_25_7.dto;

import java.util.LinkedHashMap;

public class PerformerResultDTO {

    LinkedHashMap<String, Integer> performers;

    public PerformerResultDTO(LinkedHashMap<String, Integer> performers) {
        this.performers = performers;
    }

    public LinkedHashMap<String, Integer> getPerformers() {
        return performers;
    }
}
