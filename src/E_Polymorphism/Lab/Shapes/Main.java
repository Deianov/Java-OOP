//02. Shapes
package E_Polymorphism.Lab.Shapes;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(5.0, 4.0);

        circle.calculateArea();
        circle.calculatePerimeter();

        rectangle.calculateArea();
        rectangle.calculatePerimeter();
    }
}
