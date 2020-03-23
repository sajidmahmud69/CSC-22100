
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

        // rectangle
        MyRectangle rect = new MyRectangle(200, 200, 300, 100, MyColor.BLUE);
        //rect.draw(gc);

        //Oval
        MyOval oval = new MyOval(200, 200, 300, 100, MyColor.GREEN);
        //oval.draw(gc);

        //Circle
        MyCircle c1 = new MyCircle(200,200, 140, MyColor.NIGGA);

        //c1.getMyBoundingBox().draw(gc);
        //c1.draw(gc);

        // Line
        MyLine l1 = new MyLine(175, 270, 30, 240, MyColor.NAVY);
        l1.getMyBoundingBox().draw(gc);
        l1.draw(gc);




    }
    public static void main(String[] args) {
        launch(args);
    }
}
