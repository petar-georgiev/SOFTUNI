package L02Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        Double result = Math.PI * 2 * radius;
        setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        Double result = Math.PI * radius * radius;
        setArea(result);
    }

    public final Double getRadius() {
        return radius;
    }
}
