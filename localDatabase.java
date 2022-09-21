import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class localDatabase {
    public static void main(String[] args) throws SQLException {
        String url = "C:\\dev.c\\";
        try (Connection conn = DriverManager.getConnection(url, "guest", "guest123");
                Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String SQL = "CREATE DATABASE Students";
                stmt.execute(SQL);
                System.out.println("Created");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "");
        }
    }
}
