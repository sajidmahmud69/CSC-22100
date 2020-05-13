package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesImpl {
    public void createCoursesTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Courses(Course_ID varchar (9) NOT NULL," +
                    "Course_Title varchar (60), Department varchar (26), PRIMARY KEY (Course_ID))");
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


    public void insert(Courses course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Courses (Course_ID, Course_Title, Department)" +
                    "VALUES (?, ?, ?)");

            preparedStatement.setString(1, course.getCourseID());
            preparedStatement.setString(2, course.getCourseTitle());
            preparedStatement.setString(3, course.getDepartment());
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


    public void delete(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM Courses WHERE Course_ID = ? ");
            preparedStatement.setString(1, id);
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

    public void update(Courses course, String course_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE Courses SET " +
                    "Course_Title = ?, Department = ? WHERE Course_ID = ?");
            preparedStatement.setString(1, course.getCourseTitle());
            preparedStatement.setString(2, course.getDepartment());
            preparedStatement.setString(3, course_id);
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

    public List<Courses> read() {
        List<Courses> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Courses");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Courses course = new Courses();
                course.setCourseID(resultSet.getString("Course_ID"));
                course.setCourseTitle(resultSet.getString("Course_Title"));
                course.setDepartment(resultSet.getString("Department"));

                results.add(course);
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
        List <Courses> allCourses = read();
        System.out.println("+-----------+----------------------------+------------------------+\n" +
                "| Course_ID | Course_Title               | Department             |\n" +
                "+-----------+----------------------------+------------------------+");
        for (Courses course: allCourses){
            System.out.println(String.format("| %-10s|",course.getCourseID())+
                    String.format(" %-27s|",course.getCourseTitle()) +
                    String.format(" %-23s|",course.getDepartment()));
        }
        System.out.println("+-----------+----------------------------+------------------------+");
    }
}
