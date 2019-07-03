package C_Inheritance.Exercises.NeedForSpeed.vehicle;

public class RaceMotorcycle extends Motorcycle {
    private static final Double DEFAULT_FUEL_CONSUMPTION = 8.0;

    public RaceMotorcycle(Double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    @Override
    public Double getDefaultFuelConsumption() {
        return  DEFAULT_FUEL_CONSUMPTION;
    }
}
