/**
 * This class is used to create a database for the team project.
 * The database will be used to store the information of the players and the games.
 * The database will be created in the local machine.
 * The database will be created using MySQL.
 * The database will be created using the JDBC driver.
 * The database will be created using the following information:
 * - URL: jdbc:mysql://localhost:3306/
 * - Username: project
 * - Password: project
 * The database will be created using the following tables:
 * - Players
 * - Games
 * The Players table will have the following columns:
 * - ID
 * - Name
 * - Position
 * - Height
 * - Weight
 * - Age
 * - College
 */

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.UUID;

public class TeamDatabase {
    final String URL_DB = "jdbc:mysql://localhost:3306/";
    final String USERNAME = "project";
    final String PASSWORD = "project";
    public TeamDatabase() {
    }

    /**
     * This method is used to create the database for the team project.
     * The database will be created in the local machine.
     * The database will be created using MySQL.
     * The database will be created using the JDBC driver.
     * The database will be created using the following information:
     */
    public void loadDatabase() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(URL_DB, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE DATABASE MoravianWomenBasketball;";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
