package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities;

import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.constants.ValidationMessages;
import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities.interfaces.Motorcycle;
import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities.interfaces.Rider;

public class RiderImpl implements Rider {

    private static final int MIN_NAME_LENGTH = 5;

    private String name;

    private Motorcycle motorcycle;

    private int numberOfWins;

    private boolean canParticipate;

    public RiderImpl(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return this.motorcycle;
    }

    public void addMotorcycle(Motorcycle motorcycle) {
        if (null == motorcycle) {
            throw new NullPointerException(ValidationMessages.Rider.MOTORCYCLE_VALIDATION);
        }

        this.canParticipate = true;
        this.motorcycle = motorcycle;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    public boolean getCanParticipate() {
        return this.canParticipate && this.getMotorcycle() != null;
    }

    private void setName(String name) {
        if (null == name || name.isEmpty() || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(ValidationMessages.Rider.NAME_VALIDATION, name, MIN_NAME_LENGTH));
        }

        this.name = name;
    }
}
