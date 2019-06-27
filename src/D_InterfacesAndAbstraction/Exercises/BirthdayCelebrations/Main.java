//04. Birthday Celebrations
package D_InterfacesAndAbstraction.Exercises.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        List<Birthable> list = new ArrayList<>();

        while (!"End".equals(line = scanner.nextLine())) {

            String[] data = line.split("\\s+");

            switch (data[0]) {
                case "Citizen":
                    list.add(new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]));
                    break;
                case "Pet":
                    list.add(new Pet(data[1], data[2]));
                    break;
            }
        }

        String year = scanner.nextLine();

        list.stream()
                .filter(e -> e.getBirthDate().endsWith(year))
                .map(Birthable::getBirthDate)
                .forEach(System.out::println);
    }
}
