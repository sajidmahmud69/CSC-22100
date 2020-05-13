package sample;

public class Courses {
    private String courseID;
    private String courseTitle;
    private String department;

    public Courses(){}
    public Courses (String courseID, String courseTitle, String department){
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.department = department;
    }

    //Setters

    public void setCourseID(String courseID){
        this.courseID = courseID;
    }
    public void setCourseTitle(String courseTitle){
        this.courseTitle = courseTitle;
    }
    public void setDepartment(String department){
        this.department = department;
    }


    //Getters

    public String getCourseID(){ return courseID; }
    public String getCourseTitle () { return courseTitle; }
    public String getDepartment () { return department; }
}
