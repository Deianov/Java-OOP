// 06. Greedy Times
package A_WorkingWithAbstraction.Exercises.GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());

        String[] treasure = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < treasure.length - 1; i += 2) {

            String itemName = treasure[i];
            ItemType itemType = Item.getItemType(itemName);

            if (itemType != null) {
                int amount = Integer.parseInt(treasure[i + 1]);

                bag.add(new Item(itemName, amount, itemType));
            }
        }

        bag.print();
    }
}