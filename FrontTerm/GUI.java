import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUI extends JFrame {
    private JTabbedPane tabbedPane;
    private DefaultTableModel tableModel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField positionField;
    private JTextField numberField;
    private JTextField classYearField;
    private JTextField heightField;
    private JTextField weightField;
    private TeamDatabase teamDatabase;
    private DatabaseTables databaseTables;

    public GUI() {
        // Set up the main frame
        setTitle("Moravian Women's Basketball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 1500);
        setLocationRelativeTo(null);

        // Create a TeamDatabase instance
        teamDatabase = new TeamDatabase();

        // Load the database and create the Roster table
        teamDatabase.loadDatabase();

        // Create a DatabaseTables instance
        databaseTables = new DatabaseTables();

        // Create a tabbed pane
        tabbedPane = new JTabbedPane();

        // Create tabs with panels
        JPanel rosterPanel = createRosterPanel();
        tabbedPane.addTab("Roster", rosterPanel);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("What do you want?"));
        tabbedPane.addTab("Tab 2", panel2);

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Ah Hello"));
        tabbedPane.addTab("Tab 3", panel3);

        // Add components to the main frame
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);

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
        tableModel = new DefaultTableModel();
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

        // Add input fields and button for adding new data
        JPanel inputPanel = createInputPanel();
        rosterPanel.add(inputPanel, BorderLayout.SOUTH);

        return rosterPanel;
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        firstNameField = new JTextField(8);
        lastNameField = new JTextField(10);
        positionField = new JTextField(7);
        numberField = new JTextField(3);
        classYearField = new JTextField(5);
        heightField = new JTextField(5);
        weightField = new JTextField(5);
        JButton addButton = new JButton("Add Info To Table");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToTableAndDatabase();
            }
        });

        inputPanel.add(new JLabel("First Name:"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("Position:"));
        inputPanel.add(positionField);
        inputPanel.add(new JLabel("Number:"));
        inputPanel.add(numberField);
        inputPanel.add(new JLabel("Class Year:"));
        inputPanel.add(classYearField);
        inputPanel.add(new JLabel("Height:"));
        inputPanel.add(heightField);
        inputPanel.add(new JLabel("Weight:"));
        inputPanel.add(weightField);
        inputPanel.add(addButton);

        return inputPanel;
    }

    private void fetchDataFromDatabase(DefaultTableModel tableModel) {
        try {
            // Fetch and populate data from the database
            teamDatabase.fetchDataFromDatabase(tableModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error accessing the database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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

    private void addToTableAndDatabase() {
        try {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String position = positionField.getText();
            int number = Integer.parseInt(numberField.getText());
            int classYear = Integer.parseInt(classYearField.getText());
            String height = heightField.getText();
            int weight = Integer.parseInt(weightField.getText());

            // Add to the table
            tableModel.addRow(new Object[]{firstName, lastName, position, number, classYear, height, weight});

            // Add to the database
            teamDatabase.addToDatabase(firstName, lastName, position, number, classYear, height, weight);

            // Clear the input fields
            firstNameField.setText("");
            lastNameField.setText("");
            positionField.setText("");
            numberField.setText("");
            classYearField.setText("");
            heightField.setText("");
            weightField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input format. Please enter valid values.");
        }
    }
}
