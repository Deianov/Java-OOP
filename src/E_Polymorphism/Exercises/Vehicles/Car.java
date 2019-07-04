package E_Polymorphism.Exercises.Vehicles;

public class Car extends Vehicle {
    private static final double AIR_CONDITION_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITION_CONSUMPTION);
    }
}
