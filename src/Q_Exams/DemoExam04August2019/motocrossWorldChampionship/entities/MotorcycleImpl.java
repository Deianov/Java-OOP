package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.common.ExceptionMessages;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Motorcycle;

public abstract class MotorcycleImpl implements Motorcycle {
    private static final int MINIMUM_VALID_NAME_LENGTH = 4;
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected MotorcycleImpl(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.trim().length() < MINIMUM_VALID_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL, model, MINIMUM_VALID_NAME_LENGTH));
        }
        this.model = model;
    }

    private void setHorsePower(int horsePower){
        if (horsePower < this.getMinHorsePower() || horsePower > this.getMaxHorsePower()){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
        this.horsePower = horsePower;
    }

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    protected abstract int getMinHorsePower();
    protected abstract int getMaxHorsePower();

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / this.getHorsePower() * laps;
    }
}
