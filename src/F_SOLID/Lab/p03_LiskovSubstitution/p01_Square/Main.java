package F_SOLID.Lab.p03_LiskovSubstitution.p01_Square;

public class Main {
    public static void main(String[] args) {

        Shape square = new Rectangle();
        Rectangle rectangle = new Rectangle();

        System.out.println(square.getArea());
        System.out.println(rectangle.getArea());
    }
}
