/**
 * This class is used to create the Roster table in the MoravianWomenBasketball database.
 * The Roster table will be used to store the roster for the Moravian Women Basketball team.
 * The Roster table will be used to store the following information:
 * - ID
 * - firstName
 * - lastName
 * - classYear
 * - position
 * - number
 */


import java.sql.*;

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
     * It creates all necessary fields for the Roster table.
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
                "INDEX (number)," +
                "PRIMARY KEY (ID, number))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is used to insert a new record into every table in the database.
     * The record will contain the following information in the roster table:
     * - firstName
     * - lastName
     * - position
     * - number
     * - classYear
     * - 
     * @param firstName The first name of the player
     * @param lastName The last name of the player
     * @param position The position of the player
     * @param number The number of the player
     * @param classYear The class year of the player
     */
    public void insertIntoRoster(String firstName, String lastName, String position, int number, int classYear) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO Roster (firstName, lastName, position, number, classYear) VALUES ('" + firstName + "', '" + lastName + "', '" + position + "', " + number + ", " + classYear + ");";
            //String sql2 = "INSERT INTO FreeThrows (number) SELECT number FROM Roster WHERE Roster.number = " + number + ";";
            //String sql3 = "INSERT INTO ThreePointers (number) SELECT number FROM Roster WHERE Roster.number = " + number + ";";
            stmt.executeUpdate(sql);
            //stmt.executeUpdate(sql2);
            //stmt.executeUpdate(sql3);
            System.out.println("Record inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to delete a record from every table in the database.
     * The record will be deleted based on the number of the player.
     * @param number
     */
    public void deleteFromTableRoster(int number) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoravianWomenBasketball", 
        "project", "project");
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM Roster WHERE number = " + number + ";";
            String sql2 = "DELETE FROM FreeThrows WHERE number = " + number + ";";
            String sql3 = "DELETE FROM ThreePointers WHERE number = " + number + ";";
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql);
            
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
