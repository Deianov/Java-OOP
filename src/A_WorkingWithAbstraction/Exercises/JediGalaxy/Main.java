//05. Jedi Galaxy
package A_WorkingWithAbstraction.Exercises.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        Galaxy galaxy = new Galaxy(rows, cols);
        galaxy.init(0);

        long sumPointsJedi = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Let the Force be with you")) {
                break;
            }

            // Jedi
            int[] galaxyCoordsJedi = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            // Evil
            input = scanner.nextLine();
            int[] galaxyCoordsEvil = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            int row = galaxyCoordsEvil[0];
            int col = galaxyCoordsEvil[1];
            galaxy.destroyDiagonalByEvil(row, col);

            // Jedi One
            row = galaxyCoordsJedi[0];
            col = galaxyCoordsJedi[1];
            sumPointsJedi += galaxy.getDiagonal(row, col);
        }

        System.out.println(sumPointsJedi);
    }
}
