package F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.shapes;

public class Square extends RectangleShape {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public double getArea() {
        return this.getWidth() * this.getHeight();
    }

    @Override
    public double getPerimeter() {
        return this.getWidth() * 4;
    }
}
