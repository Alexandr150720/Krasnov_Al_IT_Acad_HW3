package by.it_academy.jd2.mk_jd2_111_25_7.service;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.VoteDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.VotePageDataDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface IVoteService {

    void addVote(VoteDTO voteDTO);
    VotePageDataDTO getVotePageData();
}
