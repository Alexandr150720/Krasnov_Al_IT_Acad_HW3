package by.it_academy.jd2.mk_jd2_111_25_7.dto;

public class VoteDTO {

    private String singer;
    private String[] selectedGenres;
    private String about;

    public VoteDTO(String[] selectedGenres, String singer, String about) {
        this.selectedGenres = selectedGenres;
        this.singer = singer;
        this.about = about;
    }

    public String getSinger() {
        return singer;
    }

    public String[] getSelectedGenres() {
        return selectedGenres;
    }

    public String getAbout() {
        return about;
    }
}
