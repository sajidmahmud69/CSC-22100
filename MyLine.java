package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import static java.lang.StrictMath.atan;
import static java.lang.StrictMath.pow;

public class MyLine extends MyShape{
    // Constructrors
    MyLine(){super();}
    MyLine(double x1, double y1, double x2, double y2, Color color){super (x1,y1,x2,y2,color);}

    public double getLength(){
        double length = Math.sqrt(pow(getX2()-getX1(), 2) + pow (getY2()-getY1(), 2));
        return length;
    }
    public double get_xAngle (){
        double slope = (getY2() - getY1())/(getX2() - getX1());
        return atan(slope);
    }
    public String toString(){
        return "Length of the line is " + getLength() +
                " and the angle with respect to x-axis is " +
                get_xAngle();
    }
   public void draw(GraphicsContext g) {
        g.setStroke(getColor());
        g.setLineWidth(3);
        g.strokeLine(getX1(),getY1(),getX2(),getY2());
    }
}
