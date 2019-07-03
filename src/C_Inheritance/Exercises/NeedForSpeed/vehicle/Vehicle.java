package C_Inheritance.Exercises.NeedForSpeed.vehicle;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    private void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        if (this.fuel >= fuelConsumption * kilometers) {
            fuel -= fuelConsumption * kilometers;
        }
    }
}
