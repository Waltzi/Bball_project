/*
 * TableRoster.java
 * This class is used to create the Roster table in the MoravianWomenBasketball database.
 * The Roster table will have the following columns:
 * - studentID
 * - firstName
 * - lastName
 * - classYear
 * The class contains a default constructor, a method to create the table, and a method to insert records into the table.
 * The class extends the TeamPlayer class.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.UUID;


public class TableRoster extends TeamPlayer {

    /**
     * Default constructor for TableRoster class.
     * Initializes all fields to default values.
     */
    public TableRoster() {
        super();
    }

    /**
     * This method is used to create the Roster table in the MoravianWomenBasketball database.
     * The Roster table will have the following columns:
     * - ID
     * - firstName
     * - lastName
     * - classYear
     * - position
     * - number
     * - height
     * - weight
     */

    public void createTableRoster() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not found!!");
        }


        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE Roster (" +
                "ID INT NOT NULL AUTO_INCREMENT, " +
                "firstName VARCHAR(100) NOT NULL, " +
                "lastName VARCHAR(100) NOT NULL, " +
                "position VARCHAR(100) NOT NULL," +
                "number INT NOT NULL, " +
                "classYear INT NOT NULL, " +
                "height VARCHAR(100) NOT NULL, " +
                "INDEX (number)," +
                "PRIMARY KEY (ID, number))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is used to insert records into the Roster table.
     * The records will be inserted into the table using the following information:
     * - firstName
     * - lastName
     * - classYear
     * - position
     * - number
     * - height
     */
    public void insertIntoRoster(String firstName, String lastName, String position, int number, int classYear, String height) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO Roster (firstName, lastName, position, number, classYear, height) VALUES ('" + firstName + "', '" + lastName + "', '" + position + "', " + number + ", " + classYear + ", '" + height + "')";
            String sql2 = "INSERT INTO FreeThrows (number) SELECT number FROM Roster;";
            String sql3 = "INSERT INTO ThreePointers (number) SELECT number FROM Roster;";
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            System.out.println("Record inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
