package C_Inheritance.Exercises.NeedForSpeed.vehicle;

public class Car extends Vehicle {
    private static final Double DEFAULT_FUEL_CONSUMPTION = 3.0;

    public Car(Double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    @Override
    public Double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }
}
