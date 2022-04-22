package L02Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

   protected abstract void calculatePerimeter();
   protected abstract void calculateArea();

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        calculatePerimeter();
        return perimeter;
    }

    public Double getArea() {
        calculateArea();
        return area;
    }
}
