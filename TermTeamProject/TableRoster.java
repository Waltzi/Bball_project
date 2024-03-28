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
                "curDate Date NOT NULL, " +
                "INDEX (number)," +
                "PRIMARY KEY (ID, number))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    /*
     * This method is used to create the ArchivedPlayers table in the MoravianWomenBasketball database.
     * The ArchivedPlayers table will be used to store the archived players from the Roster table.
     * The ArchivedPlayers table will have the following columns:
     * - ID
     * - firstName
     * - lastName
     * - classYear
     * - position
     * - number
     * - date
     * - curDate
     * The ID field is the primary key for the table.
     * The number field is an index for the table.
     * The curDate field is the current date.
     * The date field is the date the player was archived.
     * The table will be used to store the archived players from the Roster table. 
     */
    public void createTableArchivedPlayers() {
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
            String sql = "CREATE TABLE ArchivedPlayers (" +
                "ID INT NOT NULL AUTO_INCREMENT, " +
                "firstName VARCHAR(100) NOT NULL, " +
                "lastName VARCHAR(100) NOT NULL, " +
                "position VARCHAR(100) NOT NULL," +
                "number INT NOT NULL, " +
                "classYear INT NOT NULL, " +
                "curDate Date NOT NULL, " +
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
            String sql = "INSERT INTO Roster (firstName, lastName, position, number, classYear, curDate) VALUES ('" + firstName + "', '" + lastName + "', '" + position + "', " + number + ", " + classYear + ", CURDATE());";
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
    
}
