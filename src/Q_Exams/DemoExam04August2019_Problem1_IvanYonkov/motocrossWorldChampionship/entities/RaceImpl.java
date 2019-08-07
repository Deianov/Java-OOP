package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities;

import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.constants.ValidationMessages;
import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities.interfaces.Race;
import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RaceImpl implements Race {

    private static final int MIN_NAME_LENGTH = 5;

    private static final int MIN_LAPS = 1;

    private String name;

    private int laps;

    private Collection<Rider> riders;

    private Map<String, Rider> ridersByName;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new ArrayList<>();
        this.ridersByName = new HashMap<>();
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
        if (null == rider) {
            throw new NullPointerException(ValidationMessages.Race.RIDER_ADD_TYPE_VALIDATION);
        }

        if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(ValidationMessages.Race.RIDER_ADD_PARTICIPATION_VALIDATION, rider.getName()));
        }

        if (this.ridersByName.containsKey(rider.getName())) {
            throw new IllegalArgumentException(String.format(ValidationMessages.Race.RIDER_ADD_DUPLICATION_VALIDATION, rider.getName(), this.getName()));
        }

        this.riders.add(rider);
        this.ridersByName.put(rider.getName(), rider);
    }

    private void setName(String name) {
        if (null == name || name.isEmpty() || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(ValidationMessages.Race.NAME_VALIDATION, name, MIN_NAME_LENGTH));
        }

        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < MIN_LAPS) {
            throw new IllegalArgumentException(String.format(ValidationMessages.Race.LAPS_VALIDATION, MIN_LAPS));
        }

        this.laps = laps;
    }
}
