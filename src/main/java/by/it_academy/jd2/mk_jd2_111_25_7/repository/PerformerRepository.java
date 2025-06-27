package by.it_academy.jd2.mk_jd2_111_25_7.repository;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.PerformerDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.PerformerResultDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

public class PerformerRepository implements IPerformerRepository{

    private String url;
    private String driver;
    private Properties props;

    public PerformerRepository(String url, String driver, Properties props) {
        this.url = url;
        this.driver = driver;
        this.props = props;
    }

    @Override
    public List<PerformerDTO> readALL() throws ClassNotFoundException {
        List<PerformerDTO> performers = new ArrayList<>();
        Class.forName(driver);
        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement stmt = conn.prepareStatement("SELECT name FROM vote_app.performer");
             ResultSet resultSet = stmt.executeQuery()){

            while (resultSet.next()){
                String perf_name = resultSet.getString("name");
                performers.add(new PerformerDTO(perf_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return performers;
    }

    @Override
    public boolean addVote(PerformerDTO performerDTO) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement stmt = conn.prepareStatement("UPDATE vote_app.performer SET votes_count = votes_count + 1 WHERE name = ?")) {
            stmt.setString(1, performerDTO.getName());
            stmt.executeUpdate();
        }catch (Exception e) {
            return false;
        }

        return  true;
    }

    @Override
    public PerformerResultDTO getResult() throws ClassNotFoundException {

        LinkedHashMap<String, Integer> performerMap = new LinkedHashMap<>();

        Class.forName(driver);
        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement stmt = conn.prepareStatement("SELECT name, votes_count FROM vote_app.performer");
             ResultSet resultSet = stmt.executeQuery()){

            while (resultSet.next()){
                String performer_name = resultSet.getString("name");
                Integer votes_count = resultSet.getInt("votes_count");

                performerMap.put(performer_name, votes_count);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new PerformerResultDTO(performerMap);
    }
}
