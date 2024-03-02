import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;

public class GUI extends JFrame {
    private JTabbedPane tabbedPane;
    private DefaultTableModel rosterTableModel;
    private DefaultTableModel freeThrowsTableModel;
    private DefaultTableModel threePointersTableModel;
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
    private FetchCreateTeamDatabase teamDatabase;
    private TableRoster tableRoster;
    private TableFreeThrows tableFreeThrows;
    private TableThreePointers tableThreePointers;

    public GUI() {
        // Set up the main frame
        setTitle("Moravian Women's Basketball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Initialize database and tables
        teamDatabase = new FetchCreateTeamDatabase();
        teamDatabase.loadDatabase();

        tableRoster = new TableRoster();
        tableRoster.createTableRoster();

        tableFreeThrows = new TableFreeThrows();
        tableFreeThrows.createTableFreeThrows();

        tableThreePointers = new TableThreePointers();
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
        add(tabbedPane);

        // Add a window resize listener
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                adjustTableSize(rosterPanel);
                adjustTableSize(freeThrowPanel);
                adjustTableSize(threePointerPanel);
            }
        });
    }

    private JPanel createRosterPanel() {
        JPanel rosterPanel = new JPanel(new BorderLayout());

        // Create a table model to hold the roster data
        rosterTableModel = new DefaultTableModel();
        JTable rosterTable = new JTable(rosterTableModel);
        JScrollPane scrollPane = new JScrollPane(rosterTable);
        rosterPanel.add(scrollPane, BorderLayout.CENTER);

        // Create input panel for roster
        JPanel inputPanel = new JPanel();
        firstNameField = new JTextField(8);
        lastNameField = new JTextField(10);
        positionField = new JTextField(7);
        numberField = new JTextField(3);
        classYearField = new JTextField(5);
        heightField = new JTextField(5);
        JButton addButton = new JButton("Add Player");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToRosterAndDatabase();
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

        rosterPanel.add(inputPanel, BorderLayout.SOUTH);

        return rosterPanel;
    }

    private JPanel createFreeThrowPanel() {
        JPanel freeThrowPanel = new JPanel(new BorderLayout());

        // Create a table model to hold the free throw data
        freeThrowsTableModel = new DefaultTableModel();
        JTable freeThrowTable = new JTable(freeThrowsTableModel);
        JScrollPane scrollPane = new JScrollPane(freeThrowTable);
        freeThrowPanel.add(scrollPane, BorderLayout.CENTER);

        // Create input panel for free throws
        JPanel inputPanel = new JPanel();
        numberField = new JTextField(3);
        freeThrowsMadeField = new JTextField(3);
        freeThrowsAttemptedField = new JTextField(3);
        JButton addButton = new JButton("Add Free Throw");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToFreeThrowsAndDatabase();
            }
        });

        inputPanel.add(new JLabel("Number:"));
        inputPanel.add(numberField);
        inputPanel.add(new JLabel("Free Throws Made:"));
        inputPanel.add(freeThrowsMadeField);
        inputPanel.add(new JLabel("Free Throws Attempted:"));
        inputPanel.add(freeThrowsAttemptedField);
        inputPanel.add(addButton);

        freeThrowPanel.add(inputPanel, BorderLayout.SOUTH);

        return freeThrowPanel;
    }

    private JPanel createThreePointPanel() {
        JPanel threePointPanel = new JPanel(new BorderLayout());

        // Create a table model to hold the three point data
        threePointersTableModel = new DefaultTableModel();
        JTable threePointTable = new JTable(threePointersTableModel);
        JScrollPane scrollPane = new JScrollPane(threePointTable);
        threePointPanel.add(scrollPane, BorderLayout.CENTER);

        // Create input panel for three pointers
        JPanel inputPanel = new JPanel();
        numberField = new JTextField(3);
        threePointersMadeField = new JTextField(3);
        threePointersAttemptedField = new JTextField(3);
        JButton addButton = new JButton("Add Three Pointer");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToThreePointersAndDatabase();
            }
        });

        inputPanel.add(new JLabel("Number:"));
        inputPanel.add(numberField);
        inputPanel.add(new JLabel("Three Pointers Made:"));
        inputPanel.add(threePointersMadeField);
        inputPanel.add(new JLabel("Three Pointers Attempted:"));
        inputPanel.add(threePointersAttemptedField);
        inputPanel.add(addButton);

        threePointPanel.add(inputPanel, BorderLayout.SOUTH);

        return threePointPanel;
    }

    private void addToRosterAndDatabase() {
        try {
            // Get data from input fields
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String position = positionField.getText();
            int number = Integer.parseInt(numberField.getText());
            int classYear = Integer.parseInt(classYearField.getText());
            String height = heightField.getText();

            // Add data to the table model
            rosterTableModel.addRow(new Object[]{firstName, lastName, position, number, classYear, height});

            // Add data to the database
            tableRoster.insertIntoRoster(firstName, lastName, position, number, classYear, height);

            // Clear input fields
            clearRosterInputFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input format. Please enter valid values.");
        }
    }

    private void addToFreeThrowsAndDatabase() {
        try {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            int number = Integer.parseInt(numberField.getText());
            int classYear = Integer.parseInt(classYearField.getText());
            String height = heightField.getText();
            int freeThrowsMade = Integer.parseInt(freeThrowsMadeField.getText());
            int freeThrowsAttempted = Integer.parseInt(freeThrowsAttemptedField.getText());

            // Add data to the table model
            freeThrowsTableModel.addRow(new Object[]{number, freeThrowsMade, freeThrowsAttempted});

            // Add data to the database
            tableFreeThrows.insertIntoTableFreeThrowsFromTableRosters();
            tableFreeThrows.updateIntoTableFreeThrowsFromTableRosters(number, freeThrowsMade, freeThrowsMade);

            // Clear input fields
            clearFreeThrowsInputFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input format. Please enter valid values.");
        }
    }

    private void addToThreePointersAndDatabase() {
        try {
            // Get data from input fields
            int number = Integer.parseInt(numberField.getText());
            int threePointersMade = Integer.parseInt(threePointersMadeField.getText());
            int threePointersAttempted = Integer.parseInt(threePointersAttemptedField.getText());

            // Add data to the table model
            threePointersTableModel.addRow(new Object[]{number, threePointersMade, threePointersAttempted});

            // Add data to the database
            tableThreePointers.insertThreePointers();
            tableThreePointers.updateIntoTableThreePointersFromTableRosters(number, threePointersMade, threePointersAttempted);

            // Clear input fields
            clearThreePointersInputFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input format. Please enter valid values.");
        }
    }

    private void fetchDataForAllPanels() {
        fetchRosterData();
        fetchFreeThrowsData();
        fetchThreePointersData();
    }

    private void fetchRosterData() {
            // Fetch data from the database and populate the table model
            teamDatabase.fetchRosterData(rosterTableModel);
        
    }

    private void fetchFreeThrowsData() {
        // Fetch data from the database and populate the table model
        teamDatabase.fetchFreeThrowsData(freeThrowsTableModel);
        
    }

    private void fetchThreePointersData() {
        teamDatabase.fetchThreePointersData(threePointersTableModel);
        
    }

    private void clearRosterInputFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        positionField.setText("");
        numberField.setText("");
        classYearField.setText("");
        heightField.setText("");
    }

    private void clearFreeThrowsInputFields() {
        numberField.setText("");
        freeThrowsMadeField.setText("");
        freeThrowsAttemptedField.setText("");
    }

    private void clearThreePointersInputFields() {
        numberField.setText("");
        threePointersMadeField.setText("");
        threePointersAttemptedField.setText("");
    }

    
        

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}
