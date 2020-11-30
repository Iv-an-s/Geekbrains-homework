package part3.lesson3.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private DataSource(){}

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
                    "root",
                    "");
        } catch (SQLException e) {
            throw new RuntimeException("SWW during connection", e);
        }
    }

    public static void close (Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("SWW during closing the connection", e);
        }
    }

    public static void rollback (Connection connection){
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
