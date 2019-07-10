package F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.shapes;

import F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Drawable;
import F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public abstract class RectangleShape implements Shape, Drawable {
    private double width;
    private double height;

    public RectangleShape(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Draw Rectangular Shape");
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
