package by.it_academy.jd2.mk_jd2_111_25_7.repository;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.VoteDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.VoteResultDTO;

import java.util.*;

public interface IVoteRepository {

    boolean add(VoteDTO voteDTO);
    List<VoteDTO> readAll() throws ClassNotFoundException;
    VoteResultDTO getResult() throws ClassNotFoundException;

}
