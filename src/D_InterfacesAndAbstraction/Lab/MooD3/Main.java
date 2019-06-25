// MooD 3 - 84%
package D_InterfacesAndAbstraction.Lab.MooD3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] data = input.split("[\\s|]+");

        String name = data[0];
        String type = data[1];
        int level = Integer.parseInt(data[3]);

        Character character = null;

        switch (type) {
            case "Demon":
                character = new Demon(name, level, Double.parseDouble(data[2]));
                break;
            case "Archangel":
                character = new Archangel(name, level, Integer.parseInt(data[2]));
                break;
        }

        if (character != null) {
            System.out.println(character.toString());
        }
    }
}
