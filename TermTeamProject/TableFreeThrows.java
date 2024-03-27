/**
 * This class is used to create the FreeThrows table in the MoravianWomenBasketball database.
 * The FreeThrows table will be used to store the free throws made, free throws attempted, and 
 * free throw percentage for each player.
 */


import java.sql.*;
import java.text.SimpleDateFormat;

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
     * The FreeThrows table will be used to store the free throws made, free throws attempted, and 
     * free throw percentage for each player.
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
                "number INT PRIMARY KEY," +
                "freeThrowsMade INT," +
                "freeThrowsAttempted INT," +
                "freeThrowPercentage DECIMAL(5,2)," +
                "date DATE," +
                "FOREIGN KEY (number) REFERENCES Roster(number));";
            stmt.executeUpdate(sql);
            System.out.println("Table FreeThrows created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to insert data into the FreeThrows table.
     * The data will be inserted into the FreeThrows table in the MoravianWomenBasketball database.
     * The data will be inserted using MySQL.
     * The data will be inserted using the JDBC driver.
     * The data will be inserted using the following information:
     * number
     * freeThrowsMade
     * freeThrowsAttempted
     * freeThrowPercentage
     * @param number
     * @param freeThrowsMade
     * @param freeThrowAttempted
     * @param freeThrowPercentage
     */
    public void insertIntoTableFreeThrowsFromTableRosters(int number, int freeThrowsMade, int freeThrowAttempted, double freeThrowPercentage, String date) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            SimpleDateFormat oldDateFormat = new SimpleDateFormat("MM-dd-yyyy");
            String date2 = oldDateFormat.format(date);

            SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String newDateString = newDateFormat.format(date2);
            String sql = "UPDATE FreeThrows SET freeThrowsMade = " + freeThrowsMade + ", freeThrowsAttempted = " + freeThrowAttempted + ", freeThrowPercentage = " + freeThrowPercentage + ", date = '" + newDateString + "' WHERE number = " + number + ";";
            stmt.executeUpdate(sql);
            System.out.println("Data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
