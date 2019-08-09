package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.common.ExceptionMessages;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Motorcycle;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Rider;

public class RiderImpl implements Rider {
    private static final int MINIMUM_VALID_NAME_LENGTH = 5;
    private String name;
    private Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate;

    public RiderImpl(String name) {
        this.setName(name);
        this.motorcycle = null;
        this.numberOfWins = 0;
        this.canParticipate = false;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MINIMUM_VALID_NAME_LENGTH){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, MINIMUM_VALID_NAME_LENGTH));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return this.motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null){
            throw new NullPointerException(ExceptionMessages.MOTORCYCLE_INVALID);
        }
        this.motorcycle = motorcycle;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() { return this.canParticipate; }
}
