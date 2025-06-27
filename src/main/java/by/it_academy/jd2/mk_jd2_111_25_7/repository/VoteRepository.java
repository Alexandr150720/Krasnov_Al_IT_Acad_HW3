package by.it_academy.jd2.mk_jd2_111_25_7.repository;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.VoteDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.VoteResultDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class VoteRepository implements IVoteRepository{

    private String url;
    private String driver;
    private Properties props;

    public VoteRepository(String url, String driver, Properties props) {
        this.url = url;
        this.driver = driver;
        this.props = props;
    }

    @Override
    public List<VoteDTO> readAll() throws ClassNotFoundException {

        List<VoteDTO> voteDTOList = new ArrayList<>();
        Class.forName(driver);
        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement stmt = conn.prepareStatement("SELECT created_at, about FROM vote_app.vote");
             ResultSet resultSet = stmt.executeQuery()){

            while (resultSet.next()){
                LocalDateTime createdAt = resultSet.getObject("created_at", LocalDateTime.class);
                String about = resultSet.getString("about");
                voteDTOList.add(new VoteDTO(createdAt, about));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return voteDTOList;
    }

    @Override
    public boolean add(VoteDTO voteDTO) {

        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO vote_app.vote (created_at, about) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            Timestamp tsCreatedAt = Timestamp.valueOf(voteDTO.getCreated_at());
            stmt.setTimestamp(1, tsCreatedAt);
            stmt.setString(2, voteDTO.getAbout());
            stmt.execute();
        }catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public VoteResultDTO getResult() throws ClassNotFoundException {

        List<String> aboutText = new ArrayList<>();
        Class.forName(driver);
        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement stmt = conn.prepareStatement("SELECT created_at, about FROM vote_app.vote");
             ResultSet resultSet = stmt.executeQuery()){

            while (resultSet.next()){
                LocalDateTime createdAt = resultSet.getObject("created_at", LocalDateTime.class);
                String about = resultSet.getString("about");
                aboutText.add(createdAt + " : " + about);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new VoteResultDTO(aboutText);
    }
}
