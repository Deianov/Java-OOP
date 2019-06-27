package D_InterfacesAndAbstraction.Exercises.MilitaryElite.soldiers;

import D_InterfacesAndAbstraction.Exercises.MilitaryElite.soldiers.entities.Mission;

import java.util.LinkedHashMap;

public class Commando extends SpecialisedSoldier {
    private LinkedHashMap<String, Mission> missionsMap;

    public Commando(String id, String firstName, String lastName, double salary, String corps, String[] missions) {
        super(id, firstName, lastName, salary, corps);
        this.missionsMap = new LinkedHashMap<>();
        this.addMissions(missions);
    }

    private void addMissions(String[] missions) {
        for (int i = 0; i < missions.length - 1; i += 2) {
            String code = missions[i];
            String state = missions[i + 1];

            Mission mission;

            try {
                mission = new Mission(code, state);

                if (!missionsMap.containsKey(code)) {
                    missionsMap.put(code, mission);
                }
            } catch (IllegalArgumentException e) {
                e.getMessage();
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
                .append("Missions:");

        for (Mission mission : missionsMap.values()) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append("\t")
                    .append(mission.toString());
        }
        return stringBuilder.toString();
    }
}
