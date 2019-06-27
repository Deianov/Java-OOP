//06. Military Elite
package D_InterfacesAndAbstraction.Exercises.MilitaryElite;

import D_InterfacesAndAbstraction.Exercises.MilitaryElite.interfaces.Isoldier;
import D_InterfacesAndAbstraction.Exercises.MilitaryElite.soldiers.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        LinkedHashMap<String, Isoldier> soldiers = new LinkedHashMap<>();

        while (!"End".equals(line = reader.readLine())) {

            String[] data = line.split("\\s+");

            String id = data[1];
            String firstName = data[2];
            String lastName = data[3];
            String argument = data[4];

            Isoldier soldier = null;
            LeutenantGeneral general = null;

            try {
                switch (data[0]) {
                    case "Private":
                        soldier = new SpecialisedSoldier(id, firstName, lastName, Double.parseDouble(argument), null);
                        break;
                    case "LeutenantGeneral":
                        general = new LeutenantGeneral(id, firstName, lastName, Double.parseDouble(argument));
                        general.addPrivates(soldiers, subArrayFromIndex(data, 5));
                        break;
                    case "Engineer":
                        soldier = new Engineer(id, firstName, lastName, Double.parseDouble(argument), data[5], subArrayFromIndex(data, 6));
                        break;
                    case "Commando":
                        soldier = new Commando(id, firstName, lastName, Double.parseDouble(argument), data[5], subArrayFromIndex(data, 6));
                        break;
                    case "Spy":
                        soldier = new Spy(id, firstName, lastName, argument);
                        break;
                }
            } catch (IllegalArgumentException e) {
                continue;
            }

            if (soldier != null) {
                soldiers.putIfAbsent(soldier.getId(), soldier);
            }
            if (general != null) {
                soldiers.putIfAbsent(general.getId(), general);
            }
        }
        soldiers.values().forEach(e -> System.out.println(e.toString()));
    }

    private static String[] subArrayFromIndex(String[] array, int fromIndex) {

        return Arrays.stream(array, fromIndex, array.length).toArray(String[]::new);
    }
}