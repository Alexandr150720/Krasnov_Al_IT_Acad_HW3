package by.it_academy.jd2.mk_jd2_111_25_7.service;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.VoteDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.VotePageDataDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.exception.InvalidGenreNumber;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IVoteRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class VoteService implements IVoteService{

    IVoteRepository voteRepository;

    public VoteService(IVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public void addVote(VoteDTO voteDTO) {
        String[] selectedGenres = voteDTO.getSelectedGenres();

        if (selectedGenres == null || selectedGenres.length < 3 || selectedGenres.length > 5) {
            throw new InvalidGenreNumber();
        }

        voteRepository.addVote(voteDTO);
    }

    @Override
    public VotePageDataDTO getVotePageData() {
        Set<String> performers = voteRepository.getPerformers();
        Set<String> genres = voteRepository.getGenres();

        return new VotePageDataDTO(performers, genres);
    }


}
