package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class MyCircle extends MyShape {
    private float x_coordinate;
    private float y_coordinate;
    private float radius;
    private Color color;

    // Constructor
    MyCircle(){
        x_coordinate = 0;
        y_coordinate = 0;
        radius = 0;
        color = Color.BLACK;
    }

    //Overloaded constructor
    MyCircle(float inX, float inY, float inRadius, Color color){
        this.x_coordinate = inX;
        this.y_coordinate = inY;
        this.radius = inRadius;
        this.color = color;
    }

    //Radius of the circle
    public float getRadius(){
        return radius;
    }
    //Area of the circle
    public float getArea(){
        return (float) (Math.PI * radius*radius);
    }

    //Perimeter of the circle
    public float getPerimter (){
        return (float) (2 * Math.PI * radius);
    }


    public String toString(){
        return "Center is " + this.x_coordinate + " " + this.y_coordinate+
                " and the radius is " + radius;
    }

    public void draw(GraphicsContext g){
        //g.setStroke(getColor());
        g.setFill(color);
        g.fillOval(x_coordinate,y_coordinate, radius, radius);
    }
}
