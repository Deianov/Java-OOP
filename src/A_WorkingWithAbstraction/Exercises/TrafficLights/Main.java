//04. Traffic Lights
package A_WorkingWithAbstraction.Exercises.TrafficLights;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] initialStates = scanner.nextLine().split("\\s+");

        int count = Integer.parseInt(scanner.nextLine());

        ArrayList<TrafficLight> trafficLights = new ArrayList<>();

        for (String state : initialStates) {
            TrafficLight trafficLight = new TrafficLight(Lights.valueOf(state));
            trafficLights.add(trafficLight);
        }

        while (count-- > 0) {
            System.out.println();

            for (TrafficLight trafficLight : trafficLights) {

                trafficLight.update();
                System.out.print(trafficLight.toString() + " ");
            }
        }
    }
}
