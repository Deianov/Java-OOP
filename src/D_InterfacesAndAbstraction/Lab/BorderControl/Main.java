// Border Control - 75%
package D_InterfacesAndAbstraction.Lab.BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        List<Identifiable> identifiables = new ArrayList<>();

        while (!"End".equals(line = reader.readLine())) {

            String[] data = line.split(" ");

            if (data.length == 2) {
                identifiables.add(new Robot(data[0], data[1]));
            } else  {
                identifiables.add(new Citizen(data[0], Integer.parseInt(data[1]), data[2]));
            }
        }

        String fakeIds = reader.readLine().toLowerCase();

        for (Identifiable ip : identifiables) {
            if (ip.getId().toLowerCase().endsWith(fakeIds)) {
                System.out.println(ip.getId());
            }
        }
    }
}
