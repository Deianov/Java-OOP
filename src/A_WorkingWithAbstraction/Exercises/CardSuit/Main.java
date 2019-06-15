//01. Card Suit
package A_WorkingWithAbstraction.Exercises.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextLine() + ":");

        for (Suits suit: Suits.values()) {

            System.out.println(String.format("Ordinal value: %d; Name value: %s", suit.getValue(), suit.name()));
        }
    }
}
