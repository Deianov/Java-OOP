package F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.enums;

public enum ANGLE_TYPE {
    Degrees(180.0),
    Grads(200.0),
    Radians(Math.PI);

    double angle;

    public double getAngle() {
        return angle;
    }

    ANGLE_TYPE(double angle) {
        this.angle = angle;
    }
}
