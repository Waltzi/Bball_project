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
 * - playerID
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
     * This method is used to create the database for the team project.
     * The database will be created in the local machine.
     * The database will be created using MySQL.
     * The database will be created using the JDBC driver.
     * The database will be created using the following information:
     */

public class FetchCreateTeamDatabase {
    final String URL_DB = "jdbc:mysql://localhost:3306/";
    final String USERNAME = "project";
    final String PASSWORD = "project";
    final String DB_NAME = "jdbc:mysql://localhost:3306/MoravianWomenBasketball";

    public FetchCreateTeamDatabase() {
        // Load the JDBC driver during the construction of the TeamDatabase instance
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not found!!");
        }
    }

    public void loadDatabase() {
        try (Connection conn = DriverManager.getConnection(URL_DB, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS MoravianWomenBasketball;")) {
            stmt.executeUpdate();
            System.out.println("Database created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
