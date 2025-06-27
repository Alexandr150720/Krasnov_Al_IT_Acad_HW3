package by.it_academy.jd2.mk_jd2_111_25_7.service;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.UserVoteDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.VotePageDataDTO;

import java.sql.SQLException;

public interface IVoteService {

    void addVote(UserVoteDTO userVoteDTO) throws SQLException;
    VotePageDataDTO getVotePageData();
}
