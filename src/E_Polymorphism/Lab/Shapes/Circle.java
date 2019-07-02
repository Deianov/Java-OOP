package E_Polymorphism.Lab.Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
    }

    public final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        System.out.println(Math.PI * 2 * this.getRadius());
    }

    @Override
    protected void calculateArea() {
        System.out.println(Math.PI * this.getRadius() * this.getRadius());
    }
}
