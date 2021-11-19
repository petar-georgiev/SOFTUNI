package L02PointInRectangle;

public class Rectangle {
    private final Point A;
    private final Point B;

    public Rectangle(Point A, Point B) {
        this.A = A;
        this.B = B;
    }

    public boolean contains(Point p) {
        return p.getX() >= A.getX() && p.getY() >= A.getY()
                && p.getX() <= B.getX() && p.getY() <= B.getY();
    }
}
