//06. Football Team Teams
package B_Encapsulation.Exercises.FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!"END".equals(line = reader.readLine())) {

            String[] data = line.split(";");

            try {
                switch (data[0]) {
                    case "Team":
                        Teams.add(new Team(data[1]));
                        break;
                    case "Add":
                        Team team = Teams.get(data[1]);
                        Player player = new Player(
                                data[2],
                                Integer.parseInt(data[3]),
                                Integer.parseInt(data[4]),
                                Integer.parseInt(data[5]),
                                Integer.parseInt(data[6]),
                                Integer.parseInt(data[7])
                        );
                        team.addPlayer(player);
                        break;
                    case "Remove":
                        Teams.get(data[1]).removePlayer(data[2]);
                        break;
                    case "Rating":
                        System.out.println(Teams.get(data[1]).toString());
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
