package sample;

public class Students {

    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;

    public Students(){}
    public Students (int studentId, String firstName, String lastName, String email, String sex){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
    }


    //Setters

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }


    //Getters

    public int getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getSex() { return sex; }
}
