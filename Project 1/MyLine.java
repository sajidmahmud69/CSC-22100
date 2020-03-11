package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class MyLine extends MyShape {
    // Objctect of classes

    MyShape point1 = new MyShape();
    MyShape point2 = new MyShape();

    //Attributes
    Color color;

    // Constructrors

    MyLine(){super();}
    MyLine (double x, double y, double x2, double y2, Color color){
        point1.setX(x);
        point1.setY(y);
        point2.setX(x2);
        point2.setY(y2);
        this.color = color;
    }

    public String toString(){
        return "Length of the line is " +
                " and the angle with respect to x-axis is ";
    }
    public void draw(GraphicsContext g) {
        g.setStroke(color);
        g.setLineWidth(3);
        g.strokeLine (point1.getX(), point1.getY(), point2.getX(), point2.getY());
    }
}
