package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape {

    private double height;
    private double width;

    // Constructors

    MyRectangle(){ super();}
    MyRectangle(double inX, double inY, double width, double height, MyColor color){
        super (inX, inY, color);
        this.width = width;
        this.height = height;
    }

    //Setters
    public void setHeight (double height){
        this.height = height;
    }
    public void setWidth (double width){
        this.width = width;
    }
    public void setArea(double area){
        this.height = area/2.0;
        this.width = area/2.0;
    }

    public void setPerimeter(double perimeter){
        this.height = perimeter/2.0;
        this.width = perimeter/2.0;
    }

    //Getters
    public double getHeight(){ return height;}
    public double getWidth() { return width;}
    public double getPerimeter() { return 2 *(height+width);}
    public double getArea() { return height * width;}

    //Corner points
    public double getTopLeftX() { return super.getX(); }
    public double getTopLeftY() { return super.getY(); }
    public double getTopRightX() { return super.getX() + getWidth(); }
    public double getTopRightY() { return super.getY() + getWidth(); }
    public double getBottomLeftX() { return super.getX() + getHeight(); }
    public double getBottomLeftY() { return super.getY() + getHeight(); }
    public double getBottomRightX() { return super.getX() + getHeight() + getWidth(); }
    public double getBottomRightY() { return super.getY() + getWidth() + getHeight(); }

    public String toString(){
        return "The width is " + getWidth() +
                " The height is " + getHeight() +
                " The perimeter is " + getPerimeter() +
                " and the area is " + getArea();
    }
    public void draw (GraphicsContext gc){
        gc.setFill(super.getColor().getMyColor());
        gc.strokeRect(super.getX()-(getWidth()/2), super.getY()- (getHeight()/2), getWidth(), getHeight());
        gc.fillRect(super.getX()-(getWidth()/2), super.getY()- (getHeight()/2), getWidth(), getHeight());
    }

    @Override
    public MyRectangle getMyBoundingBox() {
        return this;
    }

    @Override
    public boolean doOverlap(MyShape shape) {
        MyRectangle newShape = shape.getMyBoundingBox();   // the shape that is being compared to
        MyRectangle oldShape = this.getMyBoundingBox();   //  the shape I am trying to compare

        boolean flag = false;
        if (oldShape.getTopLeftX() >= newShape.getTopLeftX() && oldShape.getTopLeftX() <= newShape.getTopRightX()&&
                oldShape.getTopLeftY() >= newShape.getTopLeftY() && oldShape.getTopLeftY() <= newShape.getBottomLeftY()) flag = true;

        if (oldShape.getTopLeftX() >= newShape.getTopLeftX() && oldShape.getTopLeftX() <= newShape.getTopRightX() &&
                oldShape.getTopLeftY() >= newShape.getTopLeftY() && oldShape.getTopLeftY() <=  newShape.getBottomLeftY()) flag = true;

        if (newShape.getTopLeftX() >= oldShape.getTopLeftX() && newShape.getTopLeftX() <= oldShape.getTopRightX()&&
                newShape.getTopLeftY() >= oldShape.getTopLeftY() && newShape.getTopLeftY() <= oldShape.getBottomLeftY()) flag = true;

        if (newShape.getTopLeftX() >= oldShape.getTopLeftX() && newShape.getTopLeftX() <= oldShape.getTopRightX() &&
                newShape.getTopLeftY() >= oldShape.getTopLeftY() && newShape.getTopLeftY() <=  oldShape.getBottomLeftY()) flag = true;

        return flag;
    }
}
