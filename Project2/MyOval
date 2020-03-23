
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval extends MyShape {
    //Attributes
    private double small_radius;
    private double big_radius;

    // Constructor
    MyOval (){ super();}
    MyOval (double inX, double inY, double width, double height, MyColor color){
        super(inX, inY, color);
        this.small_radius = height;
        this.big_radius = width;
    }

    // Major and minor axis of ellipses
    public double major_axis = big_radius/2.0;
    public double minor_axis = small_radius/2.0;

    // Get methods
    public double getPerimeter (){
        double discriminant = (3 * major_axis + minor_axis) * (major_axis + 3 * minor_axis);
        double sqrt_discriminant = Math.sqrt(discriminant);
        double perimeter=  Math.PI * ((3 * (major_axis+minor_axis)) - sqrt_discriminant);
        return perimeter;
    }

    public double getArea(){ return Math.PI * major_axis * minor_axis;}

    public String toString(){
        return " The major axis is " + major_axis +
                " The minor axis is " + minor_axis +
                " The perimeter of the oval is " + getPerimeter() +
                " The area of the oval is " + getArea();
    }

    // Abstract method

    public void draw (GraphicsContext gc){
        gc.setFill(super.getColor().getMyColor());
        gc.strokeOval(super.getX() - (big_radius/2), super.getY() - (small_radius/2),
                      big_radius, small_radius);
        gc.fillOval(super.getX() - (big_radius/2), super.getY() - (small_radius/2),
                big_radius, small_radius);
    }

    @Override
    public MyRectangle getMyBoundingBox(){
        MyRectangle rec = new MyRectangle(super.getX(), super.getY(), big_radius, small_radius, MyColor.PINK);
        return rec;
    }

    @Override
    public boolean doOverlap() {
        return false;
    }
}
