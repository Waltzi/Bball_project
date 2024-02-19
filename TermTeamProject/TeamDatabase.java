import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.UUID;

public class TeamDatabase {
    public TeamDatabase() {
    }

    public void loadDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE DATABASE MoravianWomenBasketball";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
