package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyCircle extends MyShape {
    private double radius;
    private Color color;

    MyShape point1 = new MyShape();
    // Constructor
    MyCircle(){
        super();
    }


    MyCircle(double inX, double inY, double inRadius, Color color){
        point1.setX(inX);
        point1.setY(inY);
        this.radius = inRadius;
        this.color = color;
    }

    //Radius of the circle
    public double getRadius(){
        return radius;
    }
    //Area of the circle
    public double getArea(){
        return  (Math.PI * radius*radius);
    }

    //Perimeter of the circle
    public double getPerimter (){
        return  (2 * Math.PI * radius);
    }

    public String toString(){
        return "Center is " + point1.getX() + " " + point1.getY()+
                " and the radius is " + radius;
    }

    public void draw(GraphicsContext g){
        g.setFill(color);
        g.fillOval(point1.getX(),point1.getY(), radius, radius);
    }
}
