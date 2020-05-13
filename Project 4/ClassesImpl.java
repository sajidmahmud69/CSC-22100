package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ClassesImpl {
    public void createClassesTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Classes (Course_ID varchar (9) NOT NULL," +
                    "Student_ID varchar (9) NOT NULL, Section varchar (3) NOT NULL, Year smallint," +
                    " Semester varchar (6), GPA varchar (1), PRIMARY KEY (Course_ID, Student_ID, Section))");
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void insert(Classes classes) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Classes (Course_ID, Student_ID, Section," +
                    "Year, Semester, GPA) VALUES (?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, classes.getCourseID());
            preparedStatement.setInt(2, classes.getStudentID());
            preparedStatement.setString(3, classes.getSection());
            preparedStatement.setInt(4, classes.getYear());
            preparedStatement.setString (5, classes.getSemester());
            preparedStatement.setString(6, classes.getGPA());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void delete(String course_id, int student_id, String section_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM Classes WHERE Course_ID = ? && Student_ID = ? && Section = ? ");
            preparedStatement.setString(1, course_id);
            preparedStatement.setInt (2, student_id);
            preparedStatement.setString(3, section_id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void update(Classes classes, int student_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE Classes SET " +
                    "Course_ID = ?, Section = ?, Year = ?, Semester = ?, GPA = ? WHERE Student_ID = ?");
            preparedStatement.setString(1, classes.getCourseID());
            preparedStatement.setString(2, classes.getSection());
            preparedStatement.setInt(3, classes.getYear());
            preparedStatement.setString(4, classes.getSemester());
            preparedStatement.setString(5, classes.getGPA());
            preparedStatement.setInt(6, student_id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public List<Classes> read() {
        List<Classes> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Classes");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Classes classes = new Classes();
                classes.setCourseID(resultSet.getString("Course_ID"));
                classes.setStudentID(resultSet.getInt("Student_ID"));
                classes.setSection(resultSet.getString("Section"));
                classes.setYear(resultSet.getInt("Year"));
                classes.setSemester(resultSet.getString("Semester"));
                classes.setGPA(resultSet.getString("GPA"));

                results.add(classes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
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

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return results;
    }


    public void printTable(){
        List <Classes> allClasses = read();
        System.out.println("+-----------+------------+---------+------+----------+------+\n" +
                "| Course_ID | Student_ID | Section | Year | Semester | GPA  |\n" +
                "+-----------+------------+---------+------+----------+------+");

        for (Classes classes: allClasses){
            System.out.println(String.format("| %-8s  |",classes.getCourseID())+  String.format(" %-9s  |",classes.getStudentID())+
                String.format( " %-3s     |" ,classes.getSection()) + String.format(" %-5s|",classes.getYear())  +
                String.format(" %-6s   |",classes.getSemester())+  String.format(" %-1s    |",classes.getGPA()));
        }
        System.out.println("+-----------+------------+---------+------+----------+------+");
    }

}
