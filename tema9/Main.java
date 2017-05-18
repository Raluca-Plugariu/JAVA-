package tema9;


import java.sql.SQLException;

public class Main{
    public static void main(String[] args) throws SQLException {
        try {
            TeamController teams = new TeamController();
            PlayerController players = new PlayerController();

            teams.create("FC Barcelona");
            teams.create("Real Madrid");
            Database.commit();

            int fcbId = teams.findByName("FC Barcelona");
            players.create("Lionel Messi", fcbId);
            players.create("Neymar", fcbId);
            players.create("Luis Suarez", fcbId);
            players.list(fcbId); //displays all the players from the specified team
            Database.commit();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        } finally {
            Database.closeConnection();
        }
    }
}
