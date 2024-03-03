/*
 * TableFreeThrows.java
 * This class is used to create the FreeThrows table in the MoravianWomenBasketball database.
 * The FreeThrows table will have the following columns:
 * - studentID
 * - firstName
 * - lastName
 * - number
 * - freeThrowsMade
 * - freeThrowsAttempted
 */

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.UUID;

public class TableFreeThrows extends FreeThrows{

    /**
     * Default constructor for TableFreeThrows class.
     * Initializes all fields to default values.
     */
    public TableFreeThrows() {
        super();
    }

    /**
     * This method is used to create the FreeThrows table in the MoravianWomenBasketball database.
     * The FreeThrows table will have the following columns:
     * - studentID
     * - firstName
     * - lastName
     * - number
     * - freeThrowsMade
     * - freeThrowsAttempted
     */
    public void createTableFreeThrows() {
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
            String sql = "CREATE TABLE FreeThrows (" +
                "studentID INT NOT NULL, " + 
                "firstName VARCHAR(100) NOT NULL, " +
                "lastName VARCHAR(100) NOT NULL, " +
                "number INT NOT NULL, " +
                "freeThrowsMade INT, " +
                "freeThrowsAttempted INT, " +
                "threePointersPercentage DOUBLE," +
                "PRIMARY KEY (number))";
            stmt.executeUpdate(sql);
            System.out.println("Table FreeThrows created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to insert data into the FreeThrows table in the MoravianWomenBasketball database.
     * The method takes the following parameters:
     * @param firstName
     * @param lastName
     * @param number
     * @param freeThrowsMade
     * @param freeThrowAttempted
     * @param freeThrowPercentage
     */
    public void insertIntoTableFreeThrowsFromTableRosters() {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO FreeThrows (studentID, firstName, lastName, number) SELECT studentID, firstName, lastName, number FROM Rosters;";
            stmt.executeUpdate(sql);
            System.out.println("Data transferred successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    

    public void updateIntoTableFreeThrowsFromTableRosters(int number, int freeThrowsMade, int freeThrowAttempted) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            String sql2 = "UPDATE FreeThrows SET freeThrowsMade = " + freeThrowsMade + ", freeThrowsAttempted = " + freeThrowAttempted + ", freeThrowPercentage = " + super.getShootingPercentage() + " WHERE number = " + number + ";";
            stmt.executeUpdate(sql2);
            System.out.println("Data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
