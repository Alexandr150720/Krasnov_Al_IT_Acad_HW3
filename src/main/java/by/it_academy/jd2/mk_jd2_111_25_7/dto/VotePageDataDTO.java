package by.it_academy.jd2.mk_jd2_111_25_7.dto;

import java.util.List;

public class VotePageDataDTO {

    private List<PerformerDTO> performers;
    private List<GenreDTO> genres;

    public VotePageDataDTO(List<PerformerDTO> performers, List<GenreDTO> genres) {
        this.performers = performers;
        this.genres = genres;
    }

    public List<PerformerDTO> getPerformers() {
        return performers;
    }

    public List<GenreDTO> getGenres() {
        return genres;
    }
}
