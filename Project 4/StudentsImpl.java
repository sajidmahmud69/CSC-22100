package sample;

import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsImpl {

    public void createStudentsTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Students(Student_ID varchar (9) NOT NULL," +
                    "First_Name varchar(55), Last_Name varchar(55), Email varchar(69), Sex varchar(1), PRIMARY KEY (Student_ID))");
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


    public void insert(Students student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Students (Student_ID, First_Name, Last_Name, Email, Sex)" +
                    "VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getSex());
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

    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM Students WHERE Student_ID = ? ");
            preparedStatement.setInt(1, id);
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


    public void update(Students student, int student_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE Students SET " +
                    "First_Name = ?, Last_Name = ?, Email = ?, Sex = ? WHERE Student_ID = ?");
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getSex());
            preparedStatement.setInt(5, student_id);
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


    public List<Students> read() {
        List<Students> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Students");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Students student = new Students();
                student.setStudentId(resultSet.getInt("Student_ID"));
                student.setFirstName(resultSet.getString("First_Name"));
                student.setLastName(resultSet.getString("Last_Name"));
                student.setEmail(resultSet.getString("Email"));
                student.setSex(resultSet.getString("Sex"));

                results.add(student);
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
        List <Students> allStudents = read();
        System.out.println("+------------+------------+-----------+------------------------------------+------+");
        System.out.println("| Student_ID | First_Name | Last_Name | Email                              | Sex  |");
        System.out.println("+------------+------------+-----------+------------------------------------+------+");

        for (Students student: allStudents){
            System.out.println(String.format("|%-9s   |", student.getStudentId()) +  String.format("%-10s  |",student.getFirstName()) +
                    " " + String.format("%-10s|",student.getLastName()) + " " +
                    String.format("%-35s|",student.getEmail()) + " " + String.format("%-1s",student.getSex()) +
                    "    |");
        }
        System.out.println("+------------+------------+-----------+------------------------------------+------+");

    }


}
