package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape {
    private double x2;
    private double y2;

    // Constructror
    MyLine (double x, double y, double x2, double y2, MyColor color){
        super(x,y, color);
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getLength(){
        double length = Math.sqrt (Math.pow(x2-super.getX(),2) + Math.pow (y2-super.getY(),2));
        return length;
    }
    public String toString(){
        return "Length of the line is " +
                " and the angle with respect to x-axis is ";
    }
    public void draw(GraphicsContext g) {
        g.setStroke(super.getColor().getMyColor());
        g.setLineWidth(3);
        g.strokeLine (super.getX(), super.getY(), x2, y2);
    }

    @Override
    public MyRectangle getMyBoundingBox() {
        MyRectangle rec = new MyRectangle(super.getX() + (getLength()/2), super.getY(),getLength(),6, MyColor.NIGGA);
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