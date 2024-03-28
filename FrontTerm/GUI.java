/**
 * BasketballGUI class creates the GUI for the Moravian Women's Basketball team.
 * The GUI is used to display the roster, free throws, and three-pointers.
 * Users can add and delete players from the roster and input free throws and three-pointers data.
 * The GUI also displays information in each table in the database.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The main class representing the Moravian Women's Basketball GUI.
 */
public class GUI extends JFrame {
    private static final int DEFAULT_FONT_SIZE = 12;
    private int fontSize;

    // Fields for various input components
    private JTextField firstNameField, lastNameField, positionField, numberField, numberField2, numberField3,
            classYearField, freeThrowsMadeField, freeThrowsAttemptedField,
            threePointersMadeField, threePointersAttemptedField, dateField, dateField2;

    // Table models for roster, free throws, and three-pointers
    private DefaultTableModel rosterTableModel, freeThrowsTableModel, threePointersTableModel;

    // Database-related instances
    private FetchCreateTeamDatabase teamDatabase;
    private TableFreeThrows tableFreeThrows;
    private TableThreePointers tableThreePointers;
    private TableRoster tableRoster;

    /**
     * Constructs a GUI instance with the specified font size.
     * @param fontSize The font size for the GUI components.
     */
    public GUI(int fontSize) {
        this.fontSize = fontSize > 0 ? fontSize : DEFAULT_FONT_SIZE;
        initializeFrame();
        initializeDatabaseAndTables();
        createTabs();
        addResizeListener();
    }

    /**
     * Initializes the main frame of the GUI.
     */
    private void initializeFrame() {
        setTitle("Moravian Women's Basketball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1900, 1500);
        setLocationRelativeTo(null);
    }

    /**
     * Creates a JButton with the specified text and action listener.
     * @param text           The text to be displayed on the button.
     * @param actionListener The action listener for the button.
     * @return The created JButton.
     */
    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
        return button;
    }

    /**
     * Creates a JLabel with the specified text.
     * @param text The text to be displayed on the label.
     * @return The created JLabel.
     */
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
        return label;
    }

    /**
     * Creates a JTextField with the specified properties.
     * @param textField The JTextField to be configured.
     * @return The configured JTextField.
     */
    private JTextField createTextField(JTextField textField) {
        textField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
        return textField;
    }

    /**
     * Creates a button and adds it to the specified input panel.
     * @param inputPanel     The panel to which the button will be added.
     * @param text           The text to be displayed on the button.
     * @param actionListener The action listener for the button.
     */
    private void createAndAddButton(JPanel inputPanel, String text, ActionListener actionListener) {
        JButton button = createButton(text, actionListener);
        inputPanel.add(button);
    }

    /**
     * Initializes the database-related instances and tables.
     */
    private void initializeDatabaseAndTables() {
        teamDatabase = new FetchCreateTeamDatabase();
        teamDatabase.loadDatabase();

        tableRoster = new TableRoster();
        tableRoster.createTableRoster();

        tableFreeThrows = new TableFreeThrows();
        tableFreeThrows.createTableFreeThrows();

        tableThreePointers = new TableThreePointers();
        tableThreePointers.createTableThreePointers();
    }

    /**
     * Creates tabs for roster, free throws, and three-pointers and adds them to the main frame.
     */
    private void createTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel rosterPanel = createRosterPanel();
        tabbedPane.addTab("Roster", rosterPanel);

        JPanel freeThrowPanel = createFreeThrowPanel();
        tabbedPane.addTab("Free Throws", freeThrowPanel);

        JPanel threePointerPanel = createThreePointPanel();
        tabbedPane.addTab("Three Pointers", threePointerPanel);

        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * Creates a panel for displaying and interacting with the roster.
     * @return The roster panel.
     */
    private JPanel createRosterPanel() {
        JPanel rosterPanel = new JPanel(new BorderLayout());
        rosterTableModel = new DefaultTableModel();
        JTable rosterTable = new JTable(rosterTableModel);
        configureTableModel(rosterTableModel, "First Name", "Last Name", "Position", "Number", "Class Year");
        teamDatabase.fetchRosterData(rosterTableModel);

        JScrollPane scrollPane = new JScrollPane(rosterTable);
        rosterPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = createInputPanelRoster();
        rosterPanel.add(inputPanel, BorderLayout.SOUTH);

        return rosterPanel;
    }

    /**
     * Configures the table model with the specified column names.
     * @param model       The table model to be configured.
     * @param columnNames The column names for the table.
     */
    private void configureTableModel(DefaultTableModel model, String... columnNames) {
        for (String columnName : columnNames) {
            model.addColumn(columnName);
        }
    }

    /**
     * Creates an input panel for interacting with the roster.
     * @return The input panel for the roster.
     */
    private JPanel createInputPanelRoster() {
        JPanel inputPanel = new JPanel();
        createTextFieldsForRosterInput();

        JButton addButton = createButton("Add Player", e -> addToTableAndDatabase());

        addComponentsToRosterInputPanel(inputPanel);

        return inputPanel;
    }

    /**
     * Creates text fields for roster input.
     */
    private void createTextFieldsForRosterInput() {
        firstNameField = createTextField(new JTextField(8));
        lastNameField = createTextField(new JTextField(10));
        positionField = createTextField(new JTextField(7));
        numberField = createTextField(new JTextField(3));
        classYearField = createTextField(new JTextField(5));
    }

    /**
     * Adds components to the roster input panel.
     * @param inputPanel The roster input panel.
     */
    private void addComponentsToRosterInputPanel(JPanel inputPanel) {
        inputPanel.add(createLabel("First Name:"));
        inputPanel.add(createTextField(firstNameField));
        inputPanel.add(createLabel("Last Name:"));
        inputPanel.add(createTextField(lastNameField));
        inputPanel.add(createLabel("Position:"));
        inputPanel.add(createTextField(positionField));
        inputPanel.add(createLabel("Number:"));
        inputPanel.add(createTextField(numberField));
        inputPanel.add(createLabel("Class Year:"));
        inputPanel.add(createTextField(classYearField));
        createAndAddButton(inputPanel, "Add Player", e -> addToTableAndDatabase());
    }

    /**
     * Creates a panel for displaying and interacting with free throws data.
     * @return The free throw panel.
     */
    private JPanel createFreeThrowPanel() {
        JPanel freeThrowPanel = new JPanel(new BorderLayout());
        freeThrowsTableModel = new DefaultTableModel();
        JTable freeThrowTable = new JTable(freeThrowsTableModel);
        configureTableModel(freeThrowsTableModel, "Number", "Free Throws Made", "Free Throws Attempted", "Free Throw Percentage", "Date");
        teamDatabase.fetchFreeThrowsData(freeThrowsTableModel);

        JScrollPane scrollPane = new JScrollPane(freeThrowTable);
        freeThrowPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = createInputPanelFreeThrows();
        freeThrowPanel.add(inputPanel, BorderLayout.SOUTH);

        return freeThrowPanel;
    }

    /**
     * Creates an input panel for interacting with free throws data.
     * @return The input panel for free throws data.
     */
    private JPanel createInputPanelFreeThrows() {
        JPanel inputPanel = new JPanel();
        numberField2 = createTextField(new JTextField(3));
        freeThrowsMadeField = createTextField(new JTextField(3));
        freeThrowsAttemptedField = createTextField(new JTextField(3));
        dateField = createTextField(new JTextField(10));

        createAndAddButton(inputPanel, "Add Info To Table", e -> addToFreeThrowsTableAndDatabase());
        inputPanel.add(createLabel("Number:"));
        inputPanel.add(createTextField(numberField2));
        inputPanel.add(createLabel("Free Throws Made:"));
        inputPanel.add(createTextField(freeThrowsMadeField));
        inputPanel.add(createLabel("Free Throws Attempted:"));
        inputPanel.add(createTextField(freeThrowsAttemptedField));
        inputPanel.add(createLabel("Date(MM-DD-YYYY):"));
        inputPanel.add(createTextField(dateField));

        return inputPanel;
    }

    /**
     * Creates a panel for displaying and interacting with three-pointers data.
     * @return The three-pointers panel.
     */
    private JPanel createThreePointPanel() {
        JPanel threePointPanel = new JPanel(new BorderLayout());
        threePointersTableModel = new DefaultTableModel();
        JTable threePointTable = new JTable(threePointersTableModel);
        configureTableModel(threePointersTableModel, "Number", "Three Pointers Made", "Three Pointers Attempted", "Three Point Percentage", "Date");
        teamDatabase.fetchThreePointersData(threePointersTableModel);

        JScrollPane scrollPane = new JScrollPane(threePointTable);
        threePointPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = createInputPanelThreePointers();
        threePointPanel.add(inputPanel, BorderLayout.SOUTH);

        return threePointPanel;
    }

    /**
     * Creates an input panel for interacting with three-pointers data.
     * @return The input panel for three-pointers data.
     */
    private JPanel createInputPanelThreePointers() {
        JPanel inputPanel = new JPanel();
        numberField3 = createTextField(new JTextField(3));
        threePointersMadeField = createTextField(new JTextField(3));
        threePointersAttemptedField = createTextField(new JTextField(3));
        dateField2 = createTextField(new JTextField(10));

        createAndAddButton(inputPanel, "Add Info To Table", e -> addToThreePointersTableAndDatabase());
        inputPanel.add(createLabel("Number:"));
        inputPanel.add(createTextField(numberField3));
        inputPanel.add(createLabel("Three Pointers Made:"));
        inputPanel.add(createTextField(threePointersMadeField));
        inputPanel.add(createLabel("Three Pointers Attempted:"));
        inputPanel.add(createTextField(threePointersAttemptedField));
        inputPanel.add(createLabel("Date(MM-DD-YYYY):"));
        inputPanel.add(createTextField(dateField2));

        return inputPanel;
    }

    /**
     * Adds a resize listener to the main frame.
     */
    private void addResizeListener() {
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                adjustTableSize(evt.getComponent());
            }
        });
    }

    /**
     * Adjusts the size of the table based on the size of the specified component.
     * @param component The component triggering the resize event.
     */
    private void adjustTableSize(Component component) {
        if (component instanceof JPanel) {
            JTable table = ((JTable) ((JScrollPane) ((JPanel) component).getComponent(0)).getViewport().getView());
            int width = component.getWidth();
            int height = component.getHeight();
            table.setPreferredScrollableViewportSize(new Dimension(width, height));
            table.setSize(new Dimension(width, height));
            table.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
            table.revalidate();
        }
    }

    /**
     * Adds a new player to the roster table and the database.
     */
    private void addToTableAndDatabase() {
        try {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String position = positionField.getText();
            int number = Integer.parseInt(numberField.getText());
            int classYear = Integer.parseInt(classYearField.getText());

            rosterTableModel.addRow(new Object[]{firstName, lastName, position, number, classYear});
            tableRoster.insertIntoRoster(firstName, lastName, position, number, classYear);

            clearRosterInputFields();
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input format. Please enter valid values.");
        }
    }

    /**
     * Clears the input fields for adding a new player to the roster.
     */
    private void clearRosterInputFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        positionField.setText("");
        numberField.setText("");
        classYearField.setText("");
    }


    /**
     * Adds free throws data to the table and the database.
     */
    private void addToFreeThrowsTableAndDatabase() {
        try {
            int number = Integer.parseInt(numberField2.getText());
            int freeThrowsMade = Integer.parseInt(freeThrowsMadeField.getText());
            int freeThrowsAttempted = Integer.parseInt(freeThrowsAttemptedField.getText());
            double freeThrowPercentage = ((double) freeThrowsMade / (double) freeThrowsAttempted) * 100;
            if (freeThrowsAttempted == 0) {
                
                throw new ArithmeticException();
            }
            String date = dateField.getText();
            
            // Check the date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(date);

            freeThrowsTableModel.addRow(new Object[]{number, freeThrowsMade, freeThrowsAttempted, freeThrowPercentage, date});
            tableFreeThrows.insertIntoTableFreeThrowsFromTableRosters(number, freeThrowsMade, freeThrowsAttempted, freeThrowPercentage, date);

            clearFreeThrowsInputFields();
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input format. Please enter valid values.");
        } catch (ArithmeticException e) {
            showErrorMessage("Cannot divide by zero. Please enter valid values.");
        } catch (ParseException e) {
            showErrorMessage("Invalid date format. Please enter a valid date.");
        }
    }

    /**
     * Clears the input fields for adding free throws data.
     */
    private void clearFreeThrowsInputFields() {
        numberField2.setText("");
        freeThrowsMadeField.setText("");
        freeThrowsAttemptedField.setText("");
        dateField.setText("");
    }

    /**
     * Adds three-pointers data to the table and the database.
     */
    private void addToThreePointersTableAndDatabase() {
        try {
            int number = Integer.parseInt(numberField3.getText());
            int threePointersMade = Integer.parseInt(threePointersMadeField.getText());
            int threePointersAttempted = Integer.parseInt(threePointersAttemptedField.getText());
            double threePointPercentage = ((double) threePointersMade / (double) threePointersAttempted) * 100;
            if (threePointersAttempted == 0) {
                throw new ArithmeticException();
            }
            String date2 = dateField2.getText();

            // Check the date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(date2);

            threePointersTableModel.addRow(new Object[]{number, threePointersMade, threePointersAttempted, threePointPercentage, date2});
            tableThreePointers.insertThreePointers(number, threePointersMade, threePointersAttempted, threePointPercentage, date2);

            clearThreePointersInputFields();
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input format. Please enter valid values.");
        } catch (ArithmeticException e) {
            showErrorMessage("Cannot divide by zero. Please enter valid values.");
        } catch (ParseException e) {
            showErrorMessage("Invalid date format. Please enter a valid date.");
        }
    }

    /**
     * Clears the input fields for adding three-pointers data.
     */
    private void clearThreePointersInputFields() {
        numberField3.setText("");
        threePointersMadeField.setText("");
        threePointersAttemptedField.setText("");
        dateField2.setText("");
    }

    /**
     * Displays an error message dialog with the specified message.
     * @param message The error message to be displayed.
     */
    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
