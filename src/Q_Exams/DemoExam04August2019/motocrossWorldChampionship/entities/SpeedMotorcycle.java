package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities;


public class SpeedMotorcycle extends MotorcycleImpl {
    private static final double CUBIC_CENTIMETERS = 125.0;
    private static final int MINIMUM_HORSEPOWER = 50;
    private static final int MAXIMUM_HORSEPOWER = 69;

    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected int getMinHorsePower() {
        return MINIMUM_HORSEPOWER;
    }

    @Override
    protected int getMaxHorsePower() {
        return MAXIMUM_HORSEPOWER;
    }
}
