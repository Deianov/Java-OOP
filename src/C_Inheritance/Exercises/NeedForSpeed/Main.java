//04. Need For Speed
package C_Inheritance.Exercises.NeedForSpeed;

import C_Inheritance.Exercises.NeedForSpeed.vehicle.*;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car(50, 100);
        Vehicle familyCar = new FamilyCar(10.0, 100);
        Vehicle sportCar = new SportCar(10.0, 100);

        Vehicle motorcycle = new Motorcycle(10.0, 100);
        Vehicle raceMotorcycle = new RaceMotorcycle(10.0, 100);
        Vehicle crossMotorcycle = new CrossMotorcycle(10.0, 100);

        System.out.println(car.getFuel());
        car.drive(10);
        car.drive(10);
        System.out.println(car.getFuel());
    }
}