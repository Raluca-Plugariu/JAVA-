package tema9;

import java.sql.*;

public class TeamController {
    public void create(String teamName) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into teams (name) values (?)")) {
            pstmt.setString(1, teamName);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String teamName) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id from teams where name='" + teamName + "'");
            Integer id = rs.next() ? rs.getInt(1) : null;
            rs.close();
            return id;
        }
    }
}
