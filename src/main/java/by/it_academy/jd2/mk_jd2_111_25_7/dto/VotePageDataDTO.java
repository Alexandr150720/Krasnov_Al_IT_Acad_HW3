package by.it_academy.jd2.mk_jd2_111_25_7.dto;

import java.util.Set;

public class VotePageDataDTO {

    private Set<String> performers;
    private Set<String> genres;

    public VotePageDataDTO(Set<String> performers, Set<String> genres) {
        this.performers = performers;
        this.genres = genres;
    }

    public Set<String> getPerformers() {
        return performers;
    }

    public Set<String> getGenres() {
        return genres;
    }
}
