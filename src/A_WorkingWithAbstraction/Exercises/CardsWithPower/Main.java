//03. Cards With Power
package A_WorkingWithAbstraction.Exercises.CardsWithPower;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rankName = scanner.nextLine();
        String suitName = scanner.nextLine();

        Ranks rank = Ranks.valueOf(rankName);
        Suits suit = Suits.valueOf(suitName);

        System.out.println(String.format("Card name: %s of %s; Card power: %d", rank.name(), suit.name(), rank.getValue() + suit.getValue()));
    }
}
