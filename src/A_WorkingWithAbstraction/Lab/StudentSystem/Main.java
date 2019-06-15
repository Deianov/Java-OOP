//03. Student System
package A_WorkingWithAbstraction.Lab.StudentSystem;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;

        while (!"Exit".equals(line = scanner.nextLine())) {

            String[] commandTokens = line.split("\\s+");

            String command = commandTokens.length > 0 ? commandTokens[0] : "";
            String studentName = commandTokens.length > 1 ? commandTokens[1] : "";

            switch (command) {
                case "Create":
                    int age = Integer.parseInt(commandTokens[2]);
                    double grade = Double.parseDouble(commandTokens[3]);

                    StudentRegister.addStudent(studentName, age, grade);
                    break;
                case "Show":
                    StudentRegister.showStudent(studentName);
                    break;
            }
        }
    }
}
