 /*
 * TableThreePointers.java
 * This class is used to create the ThreePointers table in the MoravianWomenBasketball database.
 * The ThreePointers table will have the following columns:
 * - studentID
 * - firstName
 * - lastName
 * - number
 * - threePointersMade
 * - threePointersAttempted
 * - threePointersPercentage
 */

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.UUID;

public class TableThreePointers extends ThreePointers{

    /**
     * Default constructor for TableThreePointers class.
     * Initializes all fields to default values.
     */
    public TableThreePointers() {
        super();
    }

    /**
     * This method is used to create the ThreePointers table in the MoravianWomenBasketball database.
     * The ThreePointers table will have the following columns:
     * - studentID
     * - firstName
     * - lastName
     * - number
     * - threePointersMade
     * - threePointersAttempted
     * - threePointersPercentage
     */
    public void createTableThreePointers() {
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
            String sql = "CREATE TABLE ThreePointers (" +
                "studentID INT NOT NULL, " + 
                "firstName VARCHAR(100) NOT NULL, " +
                "lastName VARCHAR(100) NOT NULL, " +
                "number INT NOT NULL, " +
                "threePointersMade INT, " +
                "threePointersAttempted INT, " +
                "threePointersPercentage DOUBLE," +
                "PRIMARY KEY (studentID, number))";
            stmt.executeUpdate(sql);
            System.out.println("Table ThreePointers created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to insert a new row into the ThreePointers table in the MoravianWomenBasketball database.
     * The new row will contain the following values:
     * - studentID
     * - firstName
     * - lastName
     * - number
     * - threePointersMade
     * - threePointersAttempted
     * @param studentID
     * @param firstName
     * @param lastName
     * @param number
     * @param threePointersMade
     * @param threePointersAttempted
     * @param threePointersPercentage
     */
    public void insertThreePointers(int number, int threePointersMade, int threePointersAttempted, double threePointersPercentage) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO ThreePointers (number) SELECT number FROM Roster;";
            String sql2 = "UPDATE ThreePointers SET threePointersMade = " + threePointersMade + ", threePointersAttempted = " + threePointersAttempted + ", threePointersPercentage = " + threePointersPercentage + " WHERE number = " + number + ";";
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            System.out.println("Data transferred successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
