//03. Mankind
package C_Inheritance.Exercises.Mankind;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");

        try {
            Student student = new Student(
                    data[0],
                    data[1],
                    data[2]
            );

            data = scanner.nextLine().split("\\s+");

            Worker worker = new Worker(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3])
            );

            System.out.println(student.toString());
            System.out.println(worker.toString());

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }
}
