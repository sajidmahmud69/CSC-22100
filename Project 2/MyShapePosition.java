package sample;

public interface MyShapePosition extends MyPoint {
    public MyRectangle getMyBoundingBox();
    public boolean doOverlap (MyShape shape);
}
