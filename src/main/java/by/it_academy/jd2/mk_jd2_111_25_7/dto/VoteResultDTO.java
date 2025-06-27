package by.it_academy.jd2.mk_jd2_111_25_7.dto;

import java.util.List;

public class VoteResultDTO {

    List<String> aboutTexts;

    public VoteResultDTO(List<String> aboutTexts) {
        this.aboutTexts = aboutTexts;
    }

    public List<String> getAboutTexts() {
        return aboutTexts;
    }

}
