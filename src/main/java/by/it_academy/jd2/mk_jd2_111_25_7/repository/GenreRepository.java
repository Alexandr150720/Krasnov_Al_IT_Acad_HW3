package by.it_academy.jd2.mk_jd2_111_25_7.repository;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.GenreDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.GenreResultDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

public class GenreRepository implements IGenreRepository{

    private String url;
    private String driver;
    private Properties props;

    public GenreRepository(String url, String driver, Properties props) {
        this.url = url;
        this.driver = driver;
        this.props = props;
    }

    @Override
    public List<GenreDTO> readALL() throws ClassNotFoundException {
        List<GenreDTO> genres = new ArrayList<>();
        Class.forName(driver);
        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement stmt = conn.prepareStatement("SELECT name FROM vote_app.genre");
             ResultSet resultSet = stmt.executeQuery()){

            while (resultSet.next()){
                String genre_name = resultSet.getString("name");
                genres.add(new GenreDTO(genre_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return genres;
    }

    @Override
    public boolean addVote(GenreDTO genreDTO) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement stmt = conn.prepareStatement("UPDATE vote_app.genre SET votes_count = votes_count + 1 WHERE name = ?")) {
            stmt.setString(1, genreDTO.getName());
            stmt.executeUpdate();
        }catch (SQLException e) {
            return false;
        }

        return true;
    }

    @Override
    public GenreResultDTO getResult() throws ClassNotFoundException {

        LinkedHashMap<String, Integer> genreMap = new LinkedHashMap<>();

        Class.forName(driver);
        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement stmt = conn.prepareStatement("SELECT name, votes_count FROM vote_app.genre");
             ResultSet resultSet = stmt.executeQuery()){

            while (resultSet.next()){
                String genre_name = resultSet.getString("name");
                Integer votes_count = resultSet.getInt("votes_count");

                genreMap.put(genre_name, votes_count);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new GenreResultDTO(genreMap);
    }
}