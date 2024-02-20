/**
 * GUI.java
 * This class is used to create the graphical user interface for the Roster.
 * The class extends JFrame and contains a JTabbedPane with two tabs: Roster and Stats.
 * The Roster tab contains a table with the roster data.
 * The Stats tab contains a label with the text "What are you looking at?".
 * The class contains a constructor to create the main frame and a method to create the Roster tab.
 */

 import javax.swing.*;
 import javax.swing.table.DefaultTableModel;
 import java.awt.*;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 
 public class GUI extends JFrame {
     private JTabbedPane tabbedPane;
 
     public GUI() {
         // Set up the main frame
         setTitle("Moravian Women's Basketball");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(2000, 1000);
         setLocationRelativeTo(null);
 
         // Create a tabbed pane
         tabbedPane = new JTabbedPane();
 
         // Create tabs with panels
         JPanel rosterPanel = createRosterPanel();
         tabbedPane.addTab("Roster", rosterPanel);
 
         JPanel panel2 = new JPanel();
         panel2.add(new JLabel("What are you looking at?"));
         tabbedPane.addTab("Stats", panel2);
 
         // Add components to the main frame
         setLayout(new BorderLayout());
         add(tabbedPane, BorderLayout.NORTH);

         // Add a window resize listener
         addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                adjustTableSize(rosterPanel);
            }
        });
     }
     
     private JPanel createRosterPanel() {
         JPanel rosterPanel = new JPanel(new BorderLayout());
 
         // Create a table model to hold the roster data
         DefaultTableModel tableModel = new DefaultTableModel();
         JTable rosterTable = new JTable(tableModel);
 
         // Add columns to the table model
         tableModel.addColumn("First Name");
         tableModel.addColumn("Last Name");
         tableModel.addColumn("Position");
         tableModel.addColumn("Number");
         tableModel.addColumn("Class Year");
         tableModel.addColumn("Height");
         tableModel.addColumn("Weight");
 
         // Fetch and populate data from the database
         fetchDataFromDatabase(tableModel);
 
         // Add the table to a scroll pane
         JScrollPane scrollPane = new JScrollPane(rosterTable);
         rosterPanel.add(scrollPane, BorderLayout.CENTER);
 
         return rosterPanel;
     }
 
     private void fetchDataFromDatabase(DefaultTableModel tableModel) {
         // Database connection details
         String url = "jdbc:mysql://localhost:3306/MoravianWomenBasketball"; // Replace with your database URL
         String sql = "SELECT firstName, lastName, position, number, classYear, height, weight FROM roster";
 
         try (Connection connection = DriverManager.getConnection(url, "project", "project");
              PreparedStatement preparedStatement = connection.prepareStatement(sql);
              ResultSet resultSet = preparedStatement.executeQuery()) {
 
             // Iterate through the result set and populate the table model
             while (resultSet.next()) {
                 String firstName = resultSet.getString("First Name");
                 String lastName = resultSet.getString("Last Name");
                 String position = resultSet.getString("Position");
                 int number = resultSet.getInt("Number");
                 int classYear = resultSet.getInt("Class Year");
                 int height = resultSet.getInt("Height");
                 int weight = resultSet.getInt("Weight");
 
                 // Add a new row to the table model
                 tableModel.addRow(new Object[]{firstName, lastName, position, number, classYear, height, weight});
             }
 
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     private void adjustTableSize(JPanel rosterPanel) {
        JTable rosterTable = ((JTable) ((JScrollPane) rosterPanel.getComponent(0)).getViewport().getView());
        int width = rosterPanel.getWidth();
        int height = rosterPanel.getHeight();

        // Set the preferred size of the table based on the window size
        rosterTable.setPreferredScrollableViewportSize(new Dimension(width, height));
        rosterTable.setSize(new Dimension(width, height));
        rosterTable.revalidate();
    }
 }
 