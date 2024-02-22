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
 * - ID
 * - Name
 * - Position
 * - Height
 * - Weight
 * - Age
 * - College
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

public class TeamDatabase {
    final String URL_DB = "jdbc:mysql://localhost:3306/MoravianWomenBasketball";
    final String USERNAME = "project";
    final String PASSWORD = "project";

    public TeamDatabase() {
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

    public void addToDatabase(String firstName, String lastName, String position,
                              int number, int classYear, String height, int weight) {
        String sql = "INSERT INTO roster (firstName, lastName, position, number, classYear, height, weight) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL_DB, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, position);
            preparedStatement.setInt(4, number);
            preparedStatement.setInt(5, classYear);
            preparedStatement.setString(6, height);
            preparedStatement.setInt(7, weight);

            // Execute the update
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchDataFromDatabase(DefaultTableModel tableModel) throws SQLException {
        String sql = "SELECT firstName, lastName, position, number, classYear, height, weight FROM roster";

        try (Connection connection = DriverManager.getConnection(URL_DB, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate through the result set and populate the table model
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String position = resultSet.getString("position");
                int number = resultSet.getInt("number");
                int classYear = resultSet.getInt("classYear");
                String height = resultSet.getString("height");
                int weight = resultSet.getInt("weight");

                // Add a new row to the table model
                tableModel.addRow(new Object[]{firstName, lastName, position, number, classYear, height, weight});
            }
        }
    }
}
