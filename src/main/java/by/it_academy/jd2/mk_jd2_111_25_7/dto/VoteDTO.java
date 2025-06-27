package by.it_academy.jd2.mk_jd2_111_25_7.dto;

import java.time.LocalDateTime;

public class VoteDTO {

    private LocalDateTime createdAt;
    private String about;

    public VoteDTO(LocalDateTime createdAt, String about) {
        this.createdAt = createdAt;
        this.about = about;
    }

    public LocalDateTime getCreated_at() {
        return createdAt;
    }

    public String getAbout() {
        return about;
    }
}
