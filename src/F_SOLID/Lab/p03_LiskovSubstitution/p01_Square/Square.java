package F_SOLID.Lab.p03_LiskovSubstitution.p01_Square;

public class Square extends TwoDimensionalShape {

    @Override
    public double getArea() {
        return this.getWidth() * this.getHeight();
    }
}
