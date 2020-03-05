package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyShape{
    private double x1, y1, x2, y2;
    private Color color;
    // Default constructor
    MyShape(){
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        color = Color.BLACK;
    }
    //Overloaded constructor
    MyShape(double x1, double y1, double x2, double y2, Color color){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
    }
    // setters
    public void setX1(int x1){
        this.x1 = x1;
    }
    public void setX2(int x2){
        this.x2 = x2;
    }
    public void setY1(int y1){
        this.y1 = y1;
    }
    public void setY2(int y2){
        this.y2 = y2;
    }
    public void setColor(Color color){
        this.color = color;
    }
    //getter
    public double getX1() {return x1;}
    public double getX2() {return x2;}
    public double getY1() {return y1;}
    public double getY2() {return y2;}
    public Color getColor() {return color;}

    //Overridden methods
    public String toString(){
        return "X1 is " + getX1() +
                " X2 is " + getX2() +
                " Y1 is " + getY1() +
                " Y2 is " + getY2();
    }
    public void draw (GraphicsContext g){};
}
