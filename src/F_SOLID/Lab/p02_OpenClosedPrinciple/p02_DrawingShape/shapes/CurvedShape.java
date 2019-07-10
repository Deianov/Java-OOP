package F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.shapes;

import F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.enums.ANGLE_TYPE;
import F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Drawable;
import F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public abstract class CurvedShape implements Shape, Drawable {
    private static ANGLE_TYPE angleType = ANGLE_TYPE.Degrees;
    private double radius;
    private double startAngle;
    private double endAngle;
    private double fullAngle;
    private double angle;

    public CurvedShape(double radius, double startAngle, double endAngle) {
        this.setRadius(radius);
        this.setStartAngle(startAngle);
        this.setEndAngle(endAngle);
        this.setFullAngle();
        this.setAngle();
    }

    public double getAngle() {
        return angle;
    }

    private void setAngle() {
        if (this.isCircle()) {
            this.angle = this.getFullAngle();
        } else {
            this.angle = (this.getEndAngle() - this.getStartAngle()) % this.getFullAngle();
        }
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    public double getStartAngle() {
        return startAngle;
    }

    private void setStartAngle(double startAngle) {
        this.startAngle = startAngle;
    }

    public double getEndAngle() {
        return endAngle;
    }

    private void setEndAngle(double endAngle) {
        this.endAngle = endAngle;
    }

    public double getFullAngle() {
        return fullAngle;
    }

    private void setFullAngle() {
        this.fullAngle = angleType.getAngle() * 2;
    }

    public boolean isCircle() {
        return (this.getStartAngle() % this.getFullAngle()) == (this.getEndAngle() % this.getFullAngle());
    }

    @Override
    public void draw() {
        System.out.println("Draw Curved Shape");
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
