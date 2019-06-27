package D_InterfacesAndAbstraction.Exercises.MilitaryElite.soldiers;

import D_InterfacesAndAbstraction.Exercises.MilitaryElite.interfaces.Isoldier;
import D_InterfacesAndAbstraction.Exercises.MilitaryElite.models.LeutenantGeneralImpl;

import java.util.Map;

public class LeutenantGeneral extends LeutenantGeneralImpl {

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }

    public void addPrivates(Map<String, Isoldier> privates, String... ids) {
        if (ids != null) {
            for (String id: ids) {
                Isoldier soldier = privates.get(id);

                if (soldier != null && !id.equals(this.getId())) {

                    this.specialisedSoldiers.put(id, soldier);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(
                String.format("Name: %s %s Id: %s Salary: %.2f%n%s",
                        this.getFirstName(),
                        this.getLastName(),
                        this.getId(),
                        this.getSalary(),
                        "Privates:"
                )
        );

        for (Isoldier soldier: this.specialisedSoldiers.values()) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append("\t")
                    .append(soldier.toString());
        }
        return stringBuilder.toString();
    }
}

