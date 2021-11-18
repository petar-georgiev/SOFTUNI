package L02PointInRectangle;


import L02PointInRectangle.input.Reader;

public class Main {
    public static void main(String[] args) {
        int [] rectanglePoints = Reader.readIntArray("\\s+");
        Point A = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point B = new Point(rectanglePoints[2], rectanglePoints[3]);

        Rectangle rect = new Rectangle(A,B);

        int count = Reader.readIntArray("\\s+")[0];

        while (count-->0){
            int[] singPoint = Reader.readIntArray("\\s+");
            Point p = new Point(singPoint[0],singPoint[1]);

            boolean  isWithin = rect.contains(p);
            System.out.println(isWithin);
        }
    }
}
