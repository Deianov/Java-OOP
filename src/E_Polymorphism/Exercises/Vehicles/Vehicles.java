package E_Polymorphism.Exercises.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles implements Driving, Refueling {
    private double fuelConsumption;
    private String vehiclesType;
    private double fuelQuantity;

    @Override
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public void drive(double distance) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

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
    public double getFuelQuantity() {
        return this.fuelQuantity;
    }
}
