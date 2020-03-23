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
        MyRectangle rec = new MyRectangle(super.getX()-(getLength()/2), super.getY(),getLength(),16, MyColor.NIGGA);
        return rec;
    }

    @Override
    public boolean doOverlap() {
        return false;
    }
}
