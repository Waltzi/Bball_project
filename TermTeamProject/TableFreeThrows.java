/**
 * This class is used to create the FreeThrows table in the MoravianWomenBasketball database.
 * The FreeThrows table will be used to store the free throws made, free throws attempted, and 
 * free throw percentage for each player.
 */


import java.sql.*;

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
     * free throw percentage for each player, including the date.
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
                "number INT," +
                "freeThrowsMade INT," +
                "freeThrowsAttempted INT," +
                "freeThrowPercentage DECIMAL(5,2)," +
                "date VARCHAR(10)," +
                "curDate Date NOT NULL);";
            stmt.executeUpdate(sql);
            System.out.println("Table FreeThrows created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method is used to create the ArchivedFreeThrows table in the MoravianWomenBasketball database.
     * The ArchivedFreeThrows table will be used to store the free throws made, free throws attempted, and 
     * free throw percentage for each player.
     */
    public void createTableArchivedFreeThrows() {
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
            String sql = "CREATE TABLE ArchivedFreeThrows (" +
                "number INT PRIMARY KEY," +
                "freeThrowsMade INT," +
                "freeThrowsAttempted INT," +
                "freeThrowPercentage DECIMAL(5,2)," +
                "date VARCHAR(10)," +
                "curDate Date NOT NULL);";
                
            stmt.executeUpdate(sql);
            System.out.println("Table ArchivedFreeThrows created successfully");
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
     * date
     * @param number
     * @param freeThrowsMade
     * @param freeThrowAttempted
     * @param freeThrowPercentage
     * @param date
     */
    public void insertIntoTableFreeThrowsFromTableRosters(int number, int freeThrowsMade, int freeThrowAttempted, double freeThrowPercentage, String date) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            String sql2 = "INSERT INTO FreeThrows (number, freeThrowsMade, freeThrowsAttempted, freeThrowPercentage, date, curDate) VALUES (" + number + ", " + freeThrowsMade + ", " + freeThrowAttempted + ", " + freeThrowPercentage + ", '" + date + "', CURDATE());";
            stmt.executeUpdate(sql2);
            System.out.println("Data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
