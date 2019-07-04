//01. Vehicle
package E_Polymorphism.Exercises.Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]));

        data = reader.readLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]));

        int count = Integer.parseInt(reader.readLine());

        while (count-- > 0) {
            data = reader.readLine().split(" ");

            String command = data[0];
            String vehicle = data[1];
            double argument = Double.parseDouble(data[2]);

            switch (command) {
                case "Drive":
                    if (vehicle.equals("Car")) {
                        car.drive(argument);
                    } else {
                        truck.drive(argument);
                    }
                    break;
                case "Refuel":
                    if (vehicle.equals("Car")) {
                        car.refuel(argument);
                    } else {
                        truck.refuel(argument);
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
