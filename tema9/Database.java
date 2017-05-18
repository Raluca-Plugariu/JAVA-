package tema9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alex on 03-May-17.
 */
public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "student";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection = null;
    private Database() { }
    public static Connection getConnection() {

        if (connection == null) {
           createConnection();
        }
        return connection;
    }

    private static Connection createConnection() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (ClassNotFoundException e){
            System.out.println("OracleDriver nu a fost gasit.");
            e.printStackTrace();
            return null;
        }
        try{
            connection= DriverManager.getConnection( URL,USER,PASSWORD);

        }catch(SQLException e){
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
        if(connection!=null){
            System.out.println("Conexiunea a avut succes");
            return connection;
        }else {
            System.out.println("Conexiunea NU a avut succes");
            return null;
        }
    }

    public static void closeConnection() throws SQLException {
        if (connection != null)  connection.close();
    }

    public static void commit() throws SQLException {
        if (connection != null)  connection.commit();
    }
    public static void rollback() throws SQLException {
        if (connection != null)  connection.rollback();
    }
    //Implement the method createConnection()
            //Implement the method closeConnection()
            //Implement the method commit()
            //Implement the method rollback()
}