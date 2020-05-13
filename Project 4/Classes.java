package sample;

public class Classes {

    private String courseID;
    private int studentID;
    private String section;
    private int year;
    private String semester;
    private String GPA;

    public Classes(){}
    public Classes(String courseID, int studentID, String section, int year, String semester, String GPA){
        this.courseID = courseID;
        this.studentID = studentID;
        this.section = section;
        this.year = year;
        this.semester = semester;
        this.GPA = GPA;
    }


    //Setters

    public void setCourseID(String courseID){
        this.courseID = courseID;
    }
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    public void setSection(String section){
        this.section = section;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setSemester(String semester){
        this.semester = semester;
    }
    public void setGPA(String GPA){
        this.GPA = GPA;
    }


    //Getters

    public String getCourseID() { return courseID; }
    public int getStudentID() { return studentID; }
    public String getSection() { return section; }
    public int getYear() { return year; }
    public String getSemester() { return semester; }
    public String getGPA() { return GPA; }
}
