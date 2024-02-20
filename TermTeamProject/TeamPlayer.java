/**
 * TeamPlayer class is used to create TeamPlayer objects.
 * Each TeamPlayer object has a studentID, firstName, lastName, position, number, classYear, height, and weight.
 * The class contains a default constructor, a constructor with parameters, and getter and setter methods for each field.
 * The class also contains a toString method to return the fields of the object as a string.
 */

public class TeamPlayer {

    private int studentID;
    private String firstName;
    private String lastName;
    private String position;
    private int number;
    private int classYear;
    private String height;
    private int weight;

    /**
     * Default constructor for TeamPlayer class.
     * Initializes all fields to default values.
     */
    public TeamPlayer() {
        this.studentID = 0;
        this.firstName = "";
        this.lastName = "";
        this.position = "";
        this.number = 0;
        this.classYear = 0;
        this.height = "";
        this.weight = 0;
    }

    /**
     * Constructor for TeamPlayer class.
     * Initializes all fields to the values passed as parameters.
     * @param studentID
     * @param firstName
     * @param lastName
     * @param position
     * @param number
     * @param classYear
     * @param height
     * @param weight
     */
    public TeamPlayer(int studentID, String firstName, String lastName, String position, int number, 
    int classYear, String height, int weight) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.number = number;
        this.classYear = classYear;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Getter method for studentID field.
     * @return studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Getter method for firstName field.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method for lastName field.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Getter method for position field.
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Getter method for number field.
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Getter method for classYear field.
     * @return classYear
     */
    public int getClassYear() {
        return classYear;
    }

    /**
     * Getter method for height field.
     * @return height
     */
    public String getHeight() {
        return height;
    }

    /**
     * Getter method for weight field.
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Setter method for studentID field.
     * @param studentID
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Setter method for firstName and lastName fields.
     * @param firstName
     * @param lastName
     */
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Setter method for position field.
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Setter method for number field.
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Setter method for classYear field.
     * @param classYear
     */
    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    /**
     * Setter method for height field.
     * @param height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Setter method for weight field.
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * toString method to return the fields of the object as a string.
     * @return studentID, firstName, lastName, position, number, classYear, height, weight
     */
    @Override
    public String toString() {
        return  studentID +
                ", " + firstName +
                ", " + lastName +
                ", " + position + 
                ", " + number +
                ", " + classYear +
                ", " + height +
                ", " + weight +
                "\n";
    }
    
}

