package by.it_academy.jd2.mk_jd2_111_25_7.repository;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.PerformerDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.PerformerResultDTO;

import java.sql.SQLException;
import java.util.List;

public interface IPerformerRepository {

    List<PerformerDTO> readALL() throws ClassNotFoundException;
    boolean addVote(PerformerDTO performerDTO) throws SQLException;
    PerformerResultDTO getResult() throws ClassNotFoundException;

}
