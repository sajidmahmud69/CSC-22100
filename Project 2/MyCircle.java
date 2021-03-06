package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyOval {
    private double radius;

    // Constructor
    MyCircle(){
        super();
    }

    MyCircle(double inX, double inY, double inRadius, MyColor color){
        super (inX, inY, inRadius, inRadius, color);
        this.radius = inRadius;
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
        return "Center is " + super.getX() + " " + super.getY()+
                " and the radius is " + radius;
    }

    public void draw(GraphicsContext g){
        g.setFill(super.getColor().getMyColor());
        g.fillOval(super.getX()-(getRadius()/2),super.getY() - (getRadius()/2), radius, radius);
    }

    // Interface methods
    @Override
    public MyRectangle getMyBoundingBox(){
        MyRectangle rec = new MyRectangle(super.getX(), super.getY(), radius, radius, MyColor.PINK);
        return rec;
    }

    @Override
    public boolean doOverlap(MyShape shape) {
        MyRectangle newShape = shape.getMyBoundingBox();   // the shape that is being compared to
        MyRectangle oldShape = this.getMyBoundingBox();   //  the shape I am trying to compare

        // When they do overlap
        if (oldShape.getTopLeftX() >= newShape.getTopLeftX() && oldShape.getTopLeftX() <= newShape.getTopRightX()&&
                oldShape.getTopLeftY() >= newShape.getTopLeftY() && oldShape.getTopLeftY() <= newShape.getBottomLeftY()) return true;

        if (oldShape.getTopLeftX() >= newShape.getTopLeftX() && oldShape.getTopLeftX() <= newShape.getTopRightX() &&
                oldShape.getTopLeftY() >= newShape.getTopLeftY() && oldShape.getTopLeftY() <=  newShape.getBottomLeftY()) return true;

        if (newShape.getTopLeftX() >= oldShape.getTopLeftX() && newShape.getTopLeftX() <= oldShape.getTopRightX()&&
                newShape.getTopLeftY() >= oldShape.getTopLeftY() && newShape.getTopLeftY() <= oldShape.getBottomLeftY()) return true;

        if (newShape.getTopLeftX() >= oldShape.getTopLeftX() && newShape.getTopLeftX() <= oldShape.getTopRightX() &&
                newShape.getTopLeftY() >= oldShape.getTopLeftY() && newShape.getTopLeftY() <=  oldShape.getBottomLeftY()) return true;

        return false;
    }
}