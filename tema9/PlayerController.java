package tema9;

import java.sql.*;

public class PlayerController {
    public void create(String playerName,int teamID) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into players (name,team_id) values (?,?)")) {
            pstmt.setString(1, playerName);
            pstmt.setInt(2, teamID);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String playerName) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id from players where name='" + playerName + "'");
            Integer id = rs.next() ? rs.getInt(1) : null;
            rs.close();
            return id;
        }
    }

    public void list(int fcbId) throws SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
        ResultSet rezultate = st.executeQuery("Select * from players where team_id="+fcbId+"");
        String name="";
        while (rezultate.next()) {
            name = rezultate.getString("name");
            System.out.println(name);
        }

    }
}