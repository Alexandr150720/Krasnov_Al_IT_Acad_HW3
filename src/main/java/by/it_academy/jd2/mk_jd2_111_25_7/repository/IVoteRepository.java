package by.it_academy.jd2.mk_jd2_111_25_7.repository;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.ResultDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.VoteDTO;

import java.util.*;

public interface IVoteRepository {

    void addVote(VoteDTO voteDTO);
    Set<String> getPerformers();
    Set<String> getGenres();
    List<String> getAboutTexts();
    ResultDTO getResult();

}
