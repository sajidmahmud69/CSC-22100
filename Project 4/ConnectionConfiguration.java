package sample;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {
    public static Connection getConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234");
        }catch (Exception e){
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return connection;
    }
}