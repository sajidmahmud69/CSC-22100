package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas canvas = new Canvas (600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        StackPane layout = new StackPane(canvas);

        Scene scene = new Scene( layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pie Chart of Different Alphabetical Characters");
        primaryStage.show();

        MyPieChart chart = new MyPieChart(5);
        chart.draw(gc);
    }
    public static void main(String[] args) { launch(args); }
}
