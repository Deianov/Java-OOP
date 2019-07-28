package H_ExceptionsAndErrorHandling;

import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int start;
        int end;

        System.out.print("Start number : ");
        input = scanner.nextLine();
        try {
            start = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.err.println("Bad number format exception: Start number = " + input);
            return;
        }

        System.out.print("End number : ");
        input = scanner.nextLine();
        try {
            end = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.err.println("Bad number format exception: End number = " + input);
            return;
        }

        try {
            printNumbers(start, end);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printNumbers(int start, int end) {
        if (start < 1) {
            throw new IllegalArgumentException("The start number must be >= 1.");
        }
        else if (end > 100) {
            throw new IllegalArgumentException("The end number must be <= 100.");
        }
        else if (start >= end) {
            throw new IllegalArgumentException("The start number must be < from the end number.");
        }
        else {
            for (int i = start; i <= end ; i++) {
                System.out.println(i);
            }
        }
    }
}
