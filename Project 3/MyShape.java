package sample;

import javafx.scene.canvas.GraphicsContext;

abstract public class MyShape {
    private double x, y;
    private MyColor color;
    // Default constructor
    MyShape(){
        x = 0;
        y = 0;
        color = MyColor.BLACK;
    }
    //Overloaded constructor
    MyShape(double x, double y, MyColor color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // setters
    public void setX(double x){ this.x = x; }
    public void setY(double y){ this.y = y; }
    public void setColor(MyColor color){ this.color = color; }

    //getters
    public double getX() {return x;}
    public double getY() {return y;}
    public MyColor getColor() {return color;}

    //String representation
    public String toString(){
        return "X is " + getX() + " Y is " + getY();
    }

    public void draw (GraphicsContext g){};

}