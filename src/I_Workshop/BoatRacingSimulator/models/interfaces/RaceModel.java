package I_Workshop.BoatRacingSimulator.models.interfaces;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.exceptions.DuplicateModelException;
import I_Workshop.BoatRacingSimulator.exceptions.InsufficientContestantsException;
import I_Workshop.BoatRacingSimulator.models.boats.Boat;

import java.util.Set;

public interface RaceModel {
    int getDistance();
    int getCurrentSpeed();
    int getWindSpeed();
    boolean allowsMotorBoats();
    Set<Boat> getParticipants();
    void startRace() throws InsufficientContestantsException;
    void addParticipant(Boat participant) throws DuplicateModelException, ArgumentException;
    String getStatistics();
    String getResult();
}
