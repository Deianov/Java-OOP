//04. Traffic Lights
package A_WorkingWithAbstraction.Exercises.TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TrafficLight[] trafficLights =
                Arrays.stream(reader.readLine()
                        .split(" "))
                        .map(light -> new TrafficLight(Lights.valueOf(light)))
                        .toArray(TrafficLight[]::new);

        int count = Integer.parseInt(reader.readLine());

        while (count-- > 0) {

            for (TrafficLight trafficLight : trafficLights) {

                trafficLight.update();
                System.out.print(trafficLight.toString() + " ");
            }
            System.out.println();
        }
    }
}
