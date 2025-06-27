package by.it_academy.jd2.mk_jd2_111_25_7.repository;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.GenreDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.GenreResultDTO;

import java.sql.SQLException;
import java.util.List;

public interface IGenreRepository {

    List<GenreDTO> readALL() throws ClassNotFoundException;
    boolean addVote(GenreDTO genreDTO) throws SQLException;
    GenreResultDTO getResult() throws ClassNotFoundException;
}
