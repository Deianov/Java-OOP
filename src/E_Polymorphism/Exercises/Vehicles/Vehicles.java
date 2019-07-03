package E_Polymorphism.Exercises.Vehicles;

public abstract class Vehicles implements Driving, Refueling {
    private Double fuelConsumption;
    private String vehiclesType;

    @Override
    public Double getFuelConsumption() {
        return null;
    }

    @Override
    public void drive(Double distance) {

    }

    @Override
    public Double getFuelQuantity() {
        return null;
    }
}
