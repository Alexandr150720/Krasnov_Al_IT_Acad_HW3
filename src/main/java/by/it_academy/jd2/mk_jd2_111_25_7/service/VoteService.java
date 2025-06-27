package by.it_academy.jd2.mk_jd2_111_25_7.service;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.*;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IGenreRepository;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IPerformerRepository;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IVoteRepository;

import java.time.LocalDateTime;
import java.util.List;

public class VoteService implements IVoteService{

    IVoteRepository voteRepository;
    IPerformerRepository performerRepository;
    IGenreRepository genreRepository;

    public VoteService(IVoteRepository voteRepository, IPerformerRepository performerRepository, IGenreRepository genreRepository) {
        this.voteRepository = voteRepository;
        this.performerRepository = performerRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void addVote(UserVoteDTO userVoteDTO) {
        userVoteDTO.checkGenres();
        PerformerDTO performerDTO = new PerformerDTO(userVoteDTO.getPerformer());
        try {
            performerRepository.addVote(performerDTO);
            for (String genre : userVoteDTO.getGenres()) {
                GenreDTO genreDTO = new GenreDTO(genre);
                genreRepository.addVote(genreDTO);
            }
            LocalDateTime createdAt = LocalDateTime.now();
            VoteDTO voteDTO = new VoteDTO(createdAt, userVoteDTO.getTextAbout());
            voteRepository.add(voteDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public VotePageDataDTO getVotePageData() {
        try {
            List<PerformerDTO> performers = performerRepository.readALL();
            List<GenreDTO> genres = genreRepository.readALL();

            return new VotePageDataDTO(performers, genres);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
