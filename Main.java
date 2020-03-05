package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas canvas = new Canvas(600,600);
        GraphicsContext p = canvas.getGraphicsContext2D();
        StackPane layout = new StackPane(canvas);

        // scenes
        Scene scene = new Scene(layout);
        primaryStage.setTitle("Different Shapes Using JavaFx");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Shapes
        MyPolygon poly = new MyPolygon(6, 120, 300, 275, Color.MAGENTA);
        poly.draw(p);
        MyCircle circle = new MyCircle (200, 175, 200, Color.YELLOW);
        circle.draw(p);
        MyPolygon poly2 = new MyPolygon(6, 95, 300, 275, Color.BLUE);
        poly2.draw(p);
        MyCircle circle2 = new MyCircle (227, 202, 149, Color.RED);
        circle2.draw(p);
        MyPolygon poly3 = new MyPolygon (6, 70, 300, 275, Color.GREEN);
        poly3.draw(p);

        //Lines
        MyLine line = new  MyLine(100, 150, 500, 150, Color.BLACK);
        line.draw(p);
        MyLine line2 = new MyLine(100, 400, 500, 400, Color.BLACK);
        line2.draw(p);
        MyLine line3 = new MyLine(100, 400, 100, 150, Color.BLACK );
        line3.draw(p);
        MyLine line4 = new MyLine(500, 400, 500, 150, Color.BLACK );
        line4.draw(p);
        MyLine diagonal1 = new MyLine(100, 150, 500, 400, Color.BLACK);
        diagonal1.draw(p);
        MyLine diagonal2 = new MyLine(100, 400, 500, 150, Color.BLACK);
        diagonal2.draw(p);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
