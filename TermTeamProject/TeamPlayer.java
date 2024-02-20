public class TeamPlayer {

    private int studentID;
    private String firstName;
    private String lastName;
    private String position;
    private int number;
    private int classYear;
    private int height;
    private int weight;

    public TeamPlayer() {
        this.studentID = 0;
        this.firstName = "";
        this.lastName = "";
        this.position = "";
        this.number = 0;
        this.classYear = 0;
        this.height = 0;
        this.weight = 0;
    }

    public TeamPlayer(int studentID, String firstName, String lastName, String position, int number, 
    int classYear, int height, int weight) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.number = number;
        this.classYear = classYear;
        this.height = height;
        this.weight = weight;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public int getClassYear() {
        return classYear;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

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

