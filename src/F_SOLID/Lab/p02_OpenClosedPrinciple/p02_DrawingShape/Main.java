package F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape;

import F_SOLID.Lab.p02_OpenClosedPrinciple.p02_DrawingShape.shapes.*;

public class Main {
    public static void main(String[] args) {

        CurvedShape circle = new Circle(5.0);
        CurvedShape closedArc = new ClosedArc(5.0, 0.0, 90.0);
        RectangleShape square = new Square(5.0);

        circle.draw();
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.isCircle());
        System.out.println();

        closedArc.draw();
        System.out.println(closedArc.getArea());
        System.out.println(closedArc.getPerimeter());
        System.out.println(closedArc.isCircle());
        System.out.println();

        square.draw();
        System.out.println(square.getArea());
        System.out.println(square.getPerimeter());
        System.out.println();
    }
}
