package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoinTables {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public void printJoinTables(){
        List <ResultSet> rs = new ArrayList<>();
        try{
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT Students.Student_ID, Students.First_Name, Students.Last_Name, Courses.Course_ID, Courses.Course_Title," +
                    "Classes.Semester, Classes.Year, Classes.GPA FROM Students , Courses , Classes " +
                    " WHERE Students.Student_ID = Classes.Student_ID AND Courses.Course_ID = Classes.Course_ID");

            resultSet = preparedStatement.executeQuery();


            System.out.println("+------------+------------+-----------+------------+----------------------------+----------+------+-----+\n" +
                    "| Student_ID | First_Name | Last_Name | Course_ID  | Course_Title               | Semester | Year | GPA |\n" +
                    "+------------+------------+-----------+------------+----------------------------+----------+------+-----+");

            while (resultSet.next()){
                int studentID = resultSet.getInt("Student_ID");
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String courseID = resultSet.getString("Course_ID");
                String courseTitle = resultSet.getString("Course_Title");
                String semester = resultSet.getString("Semester");
                int year = resultSet.getInt("Year");
                String gpa = resultSet.getString("GPA");

                System.out.println("| " + String.format("%-9s  |",studentID) + String.format(" %-11s|",firstName) +
                                    String.format(" %-10s|",lastName) + String.format(" %-11s|",courseID) + String.format(" %-27s|",courseTitle)
                                    + String.format(" %-9s|",semester) + String.format(" %-5s|",year) +  String.format(" %-4s|",gpa));
            }

            System.out.println("+------------+------------+-----------+------------+----------------------------+----------+------+-----+");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
