package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;


public class MyPieChart{
    private double probability;
    private double remainingProbability;
    private int numberOfOccurrences;
    private HistogramAlphaBet obj;

    // Default Constructor
    public MyPieChart(){
        probability = 0;
        remainingProbability = 1;
        numberOfOccurrences = 0;
        obj = new HistogramAlphaBet();
    }

    // Overloaded Constructor
    public MyPieChart(int numberOfOccurrences){
        probability = 0;
        remainingProbability = 1;
        obj = new HistogramAlphaBet();
        this.numberOfOccurrences = numberOfOccurrences;
    }

    public void draw (GraphicsContext gc){
        Iterator <Map.Entry<Character, Integer>> it = obj.sortedMap.entrySet().iterator();   // acts as a cursor
        DecimalFormat roundFormat = new DecimalFormat("#.####");   // this is to make 4 digit decimals

        double startingAngle = 0;
        for (int i = 0; i < numberOfOccurrences; i++){
            Map.Entry<Character, Integer> m = it.next();
            int frequency = m.getValue();

            probability = (double) frequency/obj.getTotalCharCount();
            remainingProbability -= probability;

            Random rand = new Random();
            MyColor randomColor = MyColor.values()[rand.nextInt(MyColor.values().length)];

            gc.setFill(randomColor.getMyColor());
            gc.strokeArc(150, 150, 200, 200, startingAngle, probability * 360, ArcType.ROUND);
            gc.fillArc (150, 150, 200, 200, startingAngle, probability * 360, ArcType.ROUND);
            startingAngle += probability * 360;


            gc.fillText(m.getKey() + " : " + roundFormat.format((double) m.getValue()/obj.getTotalCharCount()),
                    400, (i*20)+ 50);
        }
        if (numberOfOccurrences != 26){
            gc.setFill(MyColor.DARK_GRAY.getMyColor());
            gc.strokeArc(150, 150, 200, 200, startingAngle, remainingProbability * 360, ArcType.ROUND);
            gc.fillArc (150, 150, 200, 200, startingAngle, remainingProbability * 360, ArcType.ROUND);
            gc.fillText("All other probabilities:  " + roundFormat.format(remainingProbability), 200, 400);
        }

    }
}