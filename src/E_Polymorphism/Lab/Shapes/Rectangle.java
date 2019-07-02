package E_Polymorphism.Lab.Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    public final Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public final Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        System.out.println((this.getHeight() + this.getWidth()) * 2);
    }

    @Override
    protected void calculateArea() {
        System.out.println(this.getHeight() * this.getWidth());
    }
}
