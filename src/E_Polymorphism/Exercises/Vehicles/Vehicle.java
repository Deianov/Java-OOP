package E_Polymorphism.Exercises.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle implements Driving, Refueling {
    private double fuelConsumption;
    private double fuelQuantity;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    @Override
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public void refuel(double fuel) {
        this.fuelQuantity += fuel;
    }

    @Override
    public void drive(double distance) {

        double fuelNeeded = distance * this.fuelConsumption;

        if (this.fuelQuantity >= fuelNeeded) {

            System.out.println(String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    decimalFormat.format(distance))
            );
            this.fuelQuantity -= fuelNeeded;
        } else {
            System.out.println(String.format("%s needs refueling",
                    this.getClass().getSimpleName())
            );
        }
    }

    @Override
    public String toString() {
        return
                String.format("%s: %.2f",
                        this.getClass().getSimpleName(),
                        this.fuelQuantity
        );
    }
}
