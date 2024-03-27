 /*
 * TableThreePointers.java
 * This class is used to create the ThreePointers table in the MoravianWomenBasketball database.
 * The ThreePointers table will have the following columns:
 * - number
 * - threePointersMade
 * - threePointersAttempted
 * - threePointersPercentage
 */

import java.sql.*;
import java.text.SimpleDateFormat;

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
                "number INT PRIMARY KEY," +
                "threePointersMade INT," +
                "threePointersAttempted INT," +
                "threePointersPercentage DECIMAL(5,2)," +
                "date DATE," +
                "FOREIGN KEY (number) REFERENCES Roster(number));";
            stmt.executeUpdate(sql);
            System.out.println("Table ThreePointers created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to insert data into the ThreePointers table.
     * The data will be inserted into the ThreePointers table in the MoravianWomenBasketball database.
     * The data will be inserted using MySQL.
     * The data will be inserted using the JDBC driver.
     * The data will be inserted using the following information:
     * number
     * threePointersMade
     * threePointersAttempted
     * threePointersPercentage
     * @param number
     * @param threePointersMade
     * @param threePointersAttempted
     * @param threePointersPercentage
     */
    public void insertThreePointers(int number, int threePointersMade, int threePointersAttempted, double threePointersPercentage, String date) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            SimpleDateFormat oldDateFormat = new SimpleDateFormat("MM-dd-yyyy");
            String date2 = oldDateFormat.format(date);

            SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String newDateString = newDateFormat.format(date2);
            String sql = "UPDATE ThreePointers SET threePointersMade = " + threePointersMade + ", threePointersAttempted = " + threePointersAttempted + ", threePointersPercentage = " + threePointersPercentage + ", date = '" + newDateString + "' WHERE number = " + number + ";";
            stmt.executeUpdate(sql);
            System.out.println("Data transferred successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
