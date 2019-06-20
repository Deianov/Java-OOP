package B_Encapsulation.Lab.FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Team {
    private final String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    void addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }

    String getName() {
        return this.name;
    }

    List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }
}
