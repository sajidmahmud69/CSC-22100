
import javafx.scene.canvas.GraphicsContext;

abstract public class MyShape implements MyShapePosition{
    private double x, y;
    private MyColor color;
    // Default constructor
    MyShape(){
        x = 0;
        y = 0;
        color = MyColor.NIGGA;
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

    // Interface methods
    @Override
    public void setXCoordinates (double inX){
        setX(inX);
    }
    @Override
    public void setYCoordinates(double inY){
        setY(inY);
    }

    @Override
    public double[] getXYCoordinates(){
        double [] XYCoord = new double [2];
        XYCoord [0] = getX();
        XYCoord [1] = getY();
        return XYCoord;
    }

    public void moveTo (double x, double y){
        this.x += x;
        this.y += y;
    }

    public double distanceTo(double deltaX, double deltaY) {
        double distance = Math.pow ((x-deltaX),2) + Math.pow ((y-deltaY),2);
        return Math.sqrt(distance);
    }
}
