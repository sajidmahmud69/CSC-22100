package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyPolygon extends MyShape{

    //Private attributes
    MyShape center = new MyShape();
    private int sides;
    private float radius;
    private Color color;

    //Public methods
    public double getArea (){return (double)(1/2) * radius * getPerimter();}
    public double getPerimter() { return (double) sides * getSide();}
    public double getAngle (){ return 360/sides; }
    public double getSide (){ return (double) 2 * radius * Math.tan(180/sides); }

    //Overloaded constructor
    public MyPolygon(int sides, int radius, int center_x, int center_y, Color color) {
        this.sides = sides;
        this.radius = radius;
        center.setX(center_x);
        center.setY(center_y);
        this.color = color;
    }

    public String toString(){
        return "Radius: " + radius +
                " Perimeter: " + getPerimter() +
                " Area: " + getArea();
    }

    public void draw (GraphicsContext g){
        double [] x_coordinates = new double[this.sides];
        double [] y_coordinates = new double [this.sides];
        double exterior_angle  = (this.sides-1) * getAngle();
        double increase_angle = (2 * Math.PI) / this.sides;
        for (int i = 0; i < sides; i++){
            x_coordinates[i] = (float) center.getX() + (radius * Math.cos(exterior_angle));
            y_coordinates[i] = (float) center.getY()+ (radius * Math.sin(exterior_angle));
            exterior_angle += increase_angle;
        }
        g.setFill(color);
        g.strokePolygon(x_coordinates, y_coordinates, sides);
        g.fillPolygon(x_coordinates,y_coordinates,sides);
    }
}