package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyShape{
    private double x, y;
    MyColor color;
    // Default constructor
    MyShape(){
        x = 0;
        y = 0;
        color = MyColor.BLACK;
    }
    //Overloaded constructor
    MyShape(double x, double y){
        this.x = x;
        this.y = y;
    }
    // setters
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setColor(MyColor color){
        this.color = color;
    }
    //getter
    public double getX() {return x;}
    public double getY() {return y;}
    public MyColor getColor() {return color;}

    //Overridden methods
    public String toString(){
        return "X is " + getX() + " Y is " + getY();
    }
    public void draw (GraphicsContext g){};
}
