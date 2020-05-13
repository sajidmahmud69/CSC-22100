package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class PieChart {

    private double probability = 0;
    private double remainingProbability = 1;

    public HashMap<String, Integer> hmap = new HashMap<>();
    public void fillHashMap (){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String getGPA = "";

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Classes");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                getGPA = resultSet.getString("GPA");
                if (hmap.containsKey(getGPA)) hmap.put(getGPA,hmap.get(getGPA) + 1);
                else hmap.put(getGPA,1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
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
    }

    public int getTotalFrequency() {     // returns the total number of grades
        int count = 0;
        for (Map.Entry mapElement: hmap.entrySet()){
            count += (int)mapElement.getValue();
        }

        return count;
    }


    public void draw (GraphicsContext gc, int x_axis, int y_axis) {
        int i = 0;                                                                 // used to create the space between each letter grade
        fillHashMap();
        Iterator<Map.Entry<String, Integer>> it = hmap.entrySet().iterator();     // acts as a cursor

        double startingAngle = 0;
        while (it.hasNext()) {
            Map.Entry<String, Integer> m = it.next();
            int frequency = m.getValue();

            probability = (double) frequency/getTotalFrequency();
            remainingProbability -= probability;

            Random rand = new Random();
            sample.MyColor randomColor = sample.MyColor.values()[rand.nextInt(sample.MyColor.values().length)];

            gc.setFill(randomColor.getMyColor());
            gc.strokeArc(x_axis/3, y_axis/3, x_axis/3, y_axis/3, startingAngle, probability * 360, ArcType.ROUND);
            gc.fillArc (x_axis/3, y_axis/3, x_axis/3, y_axis/3, startingAngle, probability * 360, ArcType.ROUND);

            startingAngle += probability * 360;


            gc.fillText(m.getKey() + " : " +  m.getValue(),
                        x_axis/1.4, (i*25)+ y_axis/2.9, 900);

            gc.strokeText("Total Students: " + getTotalFrequency(), x_axis/2.5, y_axis/1.4);

            i++;
        }
    }
}