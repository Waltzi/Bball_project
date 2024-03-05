/**
 * This class is used to create the database for the team project.
 * The database will be created in the local machine.
 * The database will be created using MySQL.
 * The database will be created using the JDBC driver.
 * The database will be created using the following information:
 * URL_DB = "jdbc:mysql://localhost:330
 * USERNAME = "project"
 * PASSWORD = "project"
 * DB_NAME = "jdbc:mysql://localhost:3306/MoravianWomenBasketball"
 * The class will also be used to fetch the data from the database and populate the table model.
 * The class will be used to fetch the roster data, free throws data, and three pointers data.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
* This class is used to create the database for the team project.
* The database will be created in the local machine.
* The database will be created using MySQL.
*/

public class FetchCreateTeamDatabase {
    final String URL_DB = "jdbc:mysql://localhost:3306/";
    final String USERNAME = "project";
    final String PASSWORD = "project";
    final String DB_NAME = "jdbc:mysql://localhost:3306/MoravianWomenBasketball";

    /**
     * This constructor is used to load the JDBC driver.
     * The JDBC driver is used to connect to the MySQL database.
     * The JDBC driver is used to create the database.
     * The JDBC driver is used to fetch the data from the database.
     * The JDBC driver is used to populate the table model.
     */
    public FetchCreateTeamDatabase() {
        // Load the JDBC driver during the construction of the TeamDatabase instance
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not found!!");
        }
    }

    /**
     * This method is used to create the database.
     * The database will be created in the local machine.
     * The database will be created using MySQL.
     * The database will be created using the JDBC driver.
     * The database will be created using the following information:
     * URL_DB = "jdbc:mysql://localhost:330
     * USERNAME = "project"
     * PASSWORD = "project"
     * DB_NAME = "jdbc:mysql://localhost:3306/MoravianWomenBasketball"
     */
    public void loadDatabase() {
        try (Connection conn = DriverManager.getConnection(URL_DB, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS MoravianWomenBasketball;")) {
            stmt.executeUpdate();
            System.out.println("Database created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to create the Roster table in the database.
     * The Roster table will be created in the local machine.
     * The Roster table will be created using MySQL.
     * The Roster table will be created using the JDBC driver.
     * The Roster table will be created using the following information:
     * URL_DB = "jdbc:mysql://localhost:330
     * USERNAME = "project"
     * PASSWORD = "project"
     * DB_NAME = "jdbc:mysql://localhost:3306/MoravianWomenBasketball"
     */
    public void fetchRosterData(DefaultTableModel rosterTableModel) {
        String sql = "SELECT firstName, lastName, classYear, position, number, height FROM Roster;";

        try (Connection connection = DriverManager.getConnection(DB_NAME, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate through the result set and populate the table model
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int classYear = resultSet.getInt("classYear");
                String position = resultSet.getString("position");
                int number = resultSet.getInt("number");
                String height = resultSet.getString("height");
            

                // Add a new row to the table model
                rosterTableModel.addRow(new Object[]{firstName, lastName, classYear, position, number, height});
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to create the FreeThrows table in the database.
     * The FreeThrows table will be created in the local machine.
     * The FreeThrows table will be created using MySQL.
     * The FreeThrows table will be created using the JDBC driver.
     * The FreeThrows table will be created using the following information:
     * URL_DB = "jdbc:mysql://localhost:330
     * USERNAME = "project"
     * PASSWORD = "project"
     * DB_NAME = "jdbc:mysql://localhost:3306/MoravianWomenBasketball"
     */
    public void fetchFreeThrowsData(DefaultTableModel freeThrowsTableModel) {
        String sql = "SELECT number, freeThrowsMade, freeThrowsAttempted, freeThrowPercentage FROM FreeThrows;";

        try (Connection connection = DriverManager.getConnection(DB_NAME, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate through the result set and populate the table model
            while (resultSet.next()) {
                int number = resultSet.getInt("number");
                int freeThrowsMade = resultSet.getInt("freeThrowsMade");
                int freeThrowsAttempted = resultSet.getInt("freeThrowsAttempted");
                double freeThrowPercentage = resultSet.getDouble("freeThrowPercentage");

                // Add a new row to the table model
                freeThrowsTableModel.addRow(new Object[]{number, freeThrowsMade, freeThrowsAttempted, freeThrowPercentage});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to create the ThreePointers table in the database.
     * The ThreePointers table will be created in the local machine.
     * The ThreePointers table will be created using MySQL.
     * The ThreePointers table will be created using the JDBC driver.
     * The ThreePointers table will be created using the following information:
     * URL_DB = "jdbc:mysql://localhost:330
     * USERNAME = "project"
     * PASSWORD = "project"
     * DB_NAME = "jdbc:mysql://localhost:3306/MoravianWomenBasketball"
     */
    public void fetchThreePointersData(DefaultTableModel threePointersTableModel) {
        String sql = "SELECT number, threePointersMade, threePointersAttempted, threePointersPercentage FROM ThreePointers";

        try (Connection connection = DriverManager.getConnection(DB_NAME, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate through the result set and populate the table model
            while (resultSet.next()) {
                int number = resultSet.getInt("number");
                int threePointersMade = resultSet.getInt("threePointersMade");
                int threePointersAttempted = resultSet.getInt("threePointersAttempted");
                double threePointersPercentage = resultSet.getDouble("threePointersPercentage");

                // Add a new row to the table model
                threePointersTableModel.addRow(new Object[]{number, threePointersMade, threePointersAttempted, threePointersPercentage});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
