package C_Inheritance.Exercises.NeedForSpeed.vehicle;

public class Vehicle {
    private static final Double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private Double fuelConsumption;
    private Double fuel;
    private int horsePower;

    public Vehicle(Double fuel, int horsePower) {
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
    }

    public Double getDefaultFuelConsumption() {
        return Vehicle.DEFAULT_FUEL_CONSUMPTION;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuel() {
        return fuel;
    }

    private void setFuel(Double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(Double kilometers) {
        Double fuelNeeded = this.fuelConsumption * (kilometers / 100.0);

        if (kilometers > 0 && this.fuel >= fuelNeeded) {
            this.setFuel(this.getFuel() - fuelNeeded);
        }
    }
}
