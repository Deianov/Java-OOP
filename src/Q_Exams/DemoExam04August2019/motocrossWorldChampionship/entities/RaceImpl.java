package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.common.ExceptionMessages;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Race;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RaceImpl implements Race {
    private static final int MINIMUM_VALID_NAME_LENGTH = 5;
    private static final int MINIMUM_LAPS_ALLOWED = 1;
    private String name;
    private int laps;
    private Collection<Rider> riders;
    private Set<String> names;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new ArrayList<>();
        this.names = new HashSet<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MINIMUM_VALID_NAME_LENGTH){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, MINIMUM_VALID_NAME_LENGTH));
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < MINIMUM_LAPS_ALLOWED){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, MINIMUM_LAPS_ALLOWED));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return this.riders;
    }

    @Override
    public void addRider(Rider rider) {
        if(rider == null){
            throw new NullPointerException(ExceptionMessages.RIDER_INVALID);
        }
        String riderName = rider.getName();

        if(!rider.getCanParticipate()){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_NOT_PARTICIPATE, riderName));
        }
        if(this.names.contains(riderName)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_ALREADY_ADDED, riderName, this.getName()));
        }
        this.riders.add(rider);
        this.names.add(riderName);
    }
}
