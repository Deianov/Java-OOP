//02. Point in Rectangle
package A_WorkingWithAbstraction.Lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoords = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        Rectangle rectangle = new Rectangle(rectangleCoords);

        IntStream.range(0, Integer.parseInt(scanner.nextLine()))
                .boxed()
                .map(p -> {
                        Point point = new Point(Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray());
                        return point;
                })
                .forEach(e -> System.out.println(rectangle.contains(e)));
    }
}

