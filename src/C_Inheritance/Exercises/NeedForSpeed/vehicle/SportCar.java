package C_Inheritance.Exercises.NeedForSpeed.vehicle;

public class SportCar extends Car {
    private static final Double DEFAULT_FUEL_CONSUMPTION = 10.0;

    public SportCar(Double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    @Override
    public Double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }
}
