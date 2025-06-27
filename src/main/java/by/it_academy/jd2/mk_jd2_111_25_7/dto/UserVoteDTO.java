package by.it_academy.jd2.mk_jd2_111_25_7.dto;

import by.it_academy.jd2.mk_jd2_111_25_7.exception.InvalidGenreNumber;

public class UserVoteDTO {

    private String performer;
    private String[] genres;
    private String textAbout;

    public UserVoteDTO(String performer, String[] genres, String textAbout) {
        this.performer = performer;
        this.genres = genres;
        this.textAbout = textAbout;
    }

    public String getPerformer() {
        return performer;
    }

    public String getTextAbout() {
        return textAbout;
    }

    public String[] getGenres() {
        return genres;
    }

    public void checkGenres(){
        if (genres == null || genres.length < 3 || genres.length > 5) {
            throw new InvalidGenreNumber();
        }
    }
}
