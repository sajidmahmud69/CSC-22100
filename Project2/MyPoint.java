public interface MyPoint {
    public void setXCoordinates (double inX);
    public void setYCoordinates (double inY);
    public double [] getXYCoordinates ();
    public void moveTo (double x, double y);
    public double distanceTo(double x, double y);
}
