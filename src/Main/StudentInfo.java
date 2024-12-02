package Main;

interface PersonInfo {
    void setLastName(String lastName);
    void setFirstName(String firstName);
    void setMiddleName(String middleName);
    String getLastName();
    String getFirstName();
    String getMiddleName();
}

public class StudentInfo implements PersonInfo {
    private String lastName;
    private String firstName;
    private String middleName;
    private int age;

    StudentInfo(String lastName, String firstName, String middleName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }
}


class InnerStudentInfo implements PersonInfo {
    private String lastName;
    private String firstName;
    private String middleName;

    InnerStudentInfo(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
