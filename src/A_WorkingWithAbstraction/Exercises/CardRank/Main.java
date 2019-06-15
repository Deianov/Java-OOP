//02. Card Rank
package A_WorkingWithAbstraction.Exercises.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextLine() + ":");

        for (Ranks rank: Ranks.values()) {

            System.out.println(String.format("Ordinal value: %d; Name value: %s", rank.ordinal(), rank.name()));
        }
    }
}
