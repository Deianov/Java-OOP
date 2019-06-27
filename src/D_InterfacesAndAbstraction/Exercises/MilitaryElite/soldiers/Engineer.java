package D_InterfacesAndAbstraction.Exercises.MilitaryElite.soldiers;

import D_InterfacesAndAbstraction.Exercises.MilitaryElite.soldiers.entities.Repair;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Engineer extends SpecialisedSoldier {

    private LinkedHashMap<String, Repair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps, String... arrayRepairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashMap<>();
        this.addRepairs(arrayRepairs);
    }

    private void addRepairs(String... arr) {
        if (arr != null) {

            for (int i = 0; i < arr.length - 1; i += 2) {

                String partName = arr[i];
                int hoursWorked = Integer.parseInt(arr[i + 1]);

                if (!this.repairs.containsKey(partName)) {
                    this.repairs.put(partName, new Repair(partName, hoursWorked));
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(this.getCorps())
                .append(System.lineSeparator())
                .append("Repairs:");

        for (Repair repair : repairs.values()) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append("\t")
                    .append(repair.toString());
        }
        return stringBuilder.toString();
    }
}
