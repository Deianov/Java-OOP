package E_Polymorphism.Exercises.Vehicles;

public class Truck extends Vehicle {
    private static final double AIR_CONDITION_CONSUMPTION = 1.6;
    private static final double REFUEL_FACTOR = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITION_CONSUMPTION);
    }

    @Override
    public void refuel(double fuel) {
        super.setFuelQuantity(super.getFuelQuantity() + (fuel * REFUEL_FACTOR));
    }
}
