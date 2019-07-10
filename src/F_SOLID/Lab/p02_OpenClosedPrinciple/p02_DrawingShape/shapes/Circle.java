package F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.shapes;

public class Circle extends CurvedShape {

    public Circle(double radius) {
        super(radius, 0, 0);
    }

    @Override
    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * this.getRadius();
    }
}
