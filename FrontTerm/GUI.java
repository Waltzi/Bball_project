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
    private JTextField freeThrowsMadeField;
    private JTextField freeThrowsAttemptedField;
    private JTextField freeThrowPercentageField;
    private JTextField threePointersMadeField;
    private JTextField threePointersAttemptedField;
    private JTextField threePointPercentageField;
    private TeamDatabase teamDatabase;
    private TableFreeThrows tableFreeThrows;
    private TableThreePointers tableThreePointers;
    private TableRoster tableRoster;

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

        // Create the Roster table
        tableRoster = new TableRoster();

        // Load the database and create the roster table
        tableRoster.createTableRoster();

        // Create the FreeThrows table
        tableFreeThrows = new TableFreeThrows();

        // Load the database and create the free throws table
        tableFreeThrows.createTableFreeThrows();

        // Create the ThreePointers table
        tableThreePointers = new TableThreePointers();

        // Load the database and create the three pointers table
        tableThreePointers.createTableThreePointers();


        // Create a tabbed pane
        tabbedPane = new JTabbedPane();

        // Create tabs with panels
        JPanel rosterPanel = createRosterPanel();
        tabbedPane.addTab("Roster", rosterPanel);

        JPanel freeThrowPanel = createFreeThrowPanel();
        tabbedPane.addTab("Free Throws", freeThrowPanel);

        JPanel threePointerPanel = createThreePointPanel();
        tabbedPane.addTab("Three Pointers", threePointerPanel);

        // Add components to the main frame
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);

        // Add a window resize listener
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                adjustTableSize(rosterPanel);
            }
        });

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                adjustTableSize(freeThrowPanel);
            }
        });

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                adjustTableSize(threePointerPanel);
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

        // Fetch and populate data from the database
        fetchDataFromDatabase(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(rosterTable);
        rosterPanel.add(scrollPane, BorderLayout.CENTER);

        // Add input fields and button for adding new data
        JPanel inputPanel = createInputPanelRoster();
        rosterPanel.add(inputPanel, BorderLayout.SOUTH);

        return rosterPanel;
    }

    private JPanel createInputPanelRoster() {
        JPanel inputPanel = new JPanel();
        firstNameField = new JTextField(8);
        lastNameField = new JTextField(10);
        positionField = new JTextField(7);
        numberField = new JTextField(3);
        classYearField = new JTextField(5);
        heightField = new JTextField(5);
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
        inputPanel.add(addButton);

        return inputPanel;
    }

    private JPanel createFreeThrowPanel() {
        JPanel freeThrowPanel = new JPanel(new BorderLayout());

        // Create a table model to hold the free throw data
        tableModel = new DefaultTableModel();
        JTable freeThrowTable = new JTable(tableModel);

        // Add columns to the table model
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Number");
        tableModel.addColumn("Free Throws Made");
        tableModel.addColumn("Free Throws Attempted");
        tableModel.addColumn("Free Throw Percentage");
        

        // Fetch and populate data from the database
        fetchDataFromDatabase(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(freeThrowTable);
        freeThrowPanel.add(scrollPane, BorderLayout.CENTER);

        // Add input fields and button for adding new data
        JPanel inputPanel = createInputPanelFreeThrows();
        freeThrowPanel.add(inputPanel, BorderLayout.SOUTH);

        return freeThrowPanel;
    }

    private JPanel createInputPanelFreeThrows() {
        
        JPanel inputPanel = new JPanel();
        numberField = new JTextField(3);
        freeThrowsMadeField = new JTextField(3);
        freeThrowsAttemptedField = new JTextField(3);
        JButton addButton = new JButton("Add Info To Table");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToFreeThrowsTableAndDatabase();
            }
        });

        inputPanel.add(new JLabel("Number:"));
        inputPanel.add(numberField);
        inputPanel.add(new JLabel("Free Throws Made:"));
        inputPanel.add(freeThrowsMadeField);
        inputPanel.add(new JLabel("Free Throws Attempted:"));
        inputPanel.add(freeThrowsAttemptedField);
        inputPanel.add(addButton);

        return inputPanel;
    }

    private JPanel createThreePointPanel() {
        JPanel threePointPanel = new JPanel(new BorderLayout());

        // Create a table model to hold the three point data
        tableModel = new DefaultTableModel();
        JTable threePointTable = new JTable(tableModel);

        // Add columns to the table model
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Number");
        tableModel.addColumn("Three Pointers Made");
        tableModel.addColumn("Three Pointers Attempted");
        tableModel.addColumn("Three Point Percentage");

        // Fetch and populate data from the database
        fetchDataFromDatabase(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(threePointTable);
        threePointPanel.add(scrollPane, BorderLayout.CENTER);

        // Add input fields and button for adding new data
        JPanel inputPanel = createInputPanelThreePointers();
        threePointPanel.add(inputPanel, BorderLayout.SOUTH);

        return threePointPanel;
    }

    private JPanel createInputPanelThreePointers() {
        JPanel inputPanel = new JPanel();
        numberField = new JTextField(3);
        threePointersMadeField = new JTextField(3);
        threePointersAttemptedField = new JTextField(3);
        JButton addButton = new JButton("Add Info To Table");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToThreePointersTableAndDatabase();
            }
        });

        inputPanel.add(new JLabel("Number:"));
        inputPanel.add(numberField);
        inputPanel.add(new JLabel("Three Pointers Made:"));
        inputPanel.add(threePointersMadeField);
        inputPanel.add(new JLabel("Three Pointers Attempted:"));
        inputPanel.add(threePointersAttemptedField);
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

            // Add to the table
            tableModel.addRow(new Object[]{firstName, lastName, position, number, classYear, height});

            // Add to the database
            tableRoster.insertIntoRoster(firstName, lastName, position, number, classYear, height);

            // Clear the input fields
            firstNameField.setText("");
            lastNameField.setText("");
            positionField.setText("");
            numberField.setText("");
            classYearField.setText("");
            heightField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input format. Please enter valid values.");
        }
    }

    private void addToFreeThrowsTableAndDatabase() {
        try {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String position = positionField.getText();
            int number = Integer.parseInt(numberField.getText());
            int classYear = Integer.parseInt(classYearField.getText());
            String height = heightField.getText();
            int freeThrowsMade = Integer.parseInt(freeThrowsMadeField.getText());
            int freeThrowsAttempted = Integer.parseInt(freeThrowsAttemptedField.getText());
            double freeThrowPercentage = Double.parseDouble(freeThrowPercentageField.getText());

            // Add to the table
            tableModel.addRow(new Object[]{firstName, lastName, number, freeThrowsMade, freeThrowsAttempted, freeThrowPercentage});

            // Add to the database
            tableFreeThrows.insertIntoTableFreeThrowsFromTableRosters();

            tableFreeThrows.updateIntoTableFreeThrowsFromTableRosters(number, freeThrowsMade, freeThrowsMade);


            // Clear the input fields
            firstNameField.setText("");
            lastNameField.setText("");
            numberField.setText("");
            freeThrowsMadeField.setText("");
            freeThrowsAttemptedField.setText("");
            freeThrowPercentageField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input format. Please enter valid values.");
        }
    }

    private void addToThreePointersTableAndDatabase() {
        try {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            int number = Integer.parseInt(numberField.getText());
            int threePointersMade = Integer.parseInt(threePointersMadeField.getText());
            int threePointersAttempted = Integer.parseInt(threePointersAttemptedField.getText());
            double threePointPercentage = Double.parseDouble(threePointPercentageField.getText());

            // Add to the table
            tableModel.addRow(new Object[]{firstName, lastName, number, threePointersMade, threePointersAttempted, threePointPercentage});

            // Add to the database
            tableThreePointers.insertThreePointers();

            tableThreePointers.updateIntoTableThreePointersFromTableRosters(number, threePointersMade, threePointersAttempted);

            // Clear the input fields
            firstNameField.setText("");
            lastNameField.setText("");
            numberField.setText("");
            threePointersMadeField.setText("");
            threePointersAttemptedField.setText("");
            threePointPercentageField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input format. Please enter valid values.");
        }
    }



    
        

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}
