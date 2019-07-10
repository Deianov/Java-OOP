package F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.shapes;

public class ClosedArc extends CurvedShape {
    private double circleSector;

    public ClosedArc(double radius, double startAngle, double endAngle) {
        super(radius, startAngle, endAngle);
        this.circleSector = this.getAngle() / this.getFullAngle();
    }

    @Override
    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius() * this.circleSector;
    }

    @Override
    public double getPerimeter() {
        return (Math.PI * 2 * this.getRadius() * this.circleSector) + (this.getRadius() * 2);
    }
}
