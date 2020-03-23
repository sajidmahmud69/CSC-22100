
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyPolygon extends MyShape{

    private int sides;
    private float radius;

    //Public methods
    public double getArea (){return (double)(1/2) * radius * getPerimter();}
    public double getPerimter() { return (double) sides * getSide();}
    public double getAngle (){ return 360/sides; }
    public double getSide (){ return (double) 2 * radius * Math.tan(180/sides); }

    //Overloaded constructor
    public MyPolygon(int sides, int radius, int center_x, int center_y, MyColor color) {
        super (center_x, center_y, color);
        this.sides = sides;
        this.radius = radius;
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
            x_coordinates[i] = (float) super.getX() + (radius * Math.cos(exterior_angle));
            y_coordinates[i] = (float) super.getY()+ (radius * Math.sin(exterior_angle));
            exterior_angle += increase_angle;
        }
        g.setFill(super.getColor().getMyColor());
        g.strokePolygon(x_coordinates, y_coordinates, sides);
        g.fillPolygon(x_coordinates,y_coordinates,sides);
    }

    @Override
    public MyRectangle getMyBoundingBox() {
        return null;
    }

    @Override
    public boolean doOverlap(){
        return false;
    }
}

