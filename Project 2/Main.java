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
        Canvas canvas = new Canvas(600,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        StackPane layout = new StackPane(canvas);

        Scene scene = new Scene(layout);
        primaryStage.setTitle("Different rectangles and ovals using JavaFx");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Rectangles
        MyRectangle r1 = new MyRectangle(300, 240, 400, 250, MyColor.WHITE);
        MyRectangle r2 = new MyRectangle(300, 240, 300, 150, MyColor.CYAN);

        // Ovals
        MyOval oval1 = new MyOval(300, 240, 300, 150, MyColor.GREEN);
        MyOval oval2 = new MyOval(300, 240, 240, 90, MyColor.YELLOW);
        MyOval oval3 = new MyOval(300, 240, 140, 70, MyColor.RED);

        // Line
        MyLine diagonal = new MyLine(102, 117, 500, 365, MyColor.BLACK);

        // Draw  methods
        r1.draw(gc);
        r2.draw(gc);
        oval1.draw(gc);
        oval2.getMyBoundingBox().draw(gc);
        oval2.draw(gc);
        MyRectangle oval3Box = oval3.getMyBoundingBox();
        oval3Box.setColor(MyColor.NAVY);
        oval3Box.draw(gc);
        oval3.draw(gc);
        diagonal.draw(gc);

    }
    public static void main(String[] args) {
        launch(args);
    }
}
