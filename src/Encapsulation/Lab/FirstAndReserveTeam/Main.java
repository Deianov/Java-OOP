//04. First And Reserve Team
package Encapsulation.Lab.FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        ArrayList<Person> people = new ArrayList<>();
        Team team = new Team("Team1");

        while (lines-- > 0) {
            String[] data = reader.readLine().split(" ");

            try {
                Person person = new Person(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                team.addPlayer(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(String.format("First team have %d players", team.getFirstTeam().size()));
        System.out.println(String.format("Reserve team have %d players", team.getReserveTeam().size()));
    }
}
