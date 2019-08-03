package I_Workshop.BoatRacingSimulator.core.controllers.interfaces;

import I_Workshop.BoatRacingSimulator.exceptions.*;
import I_Workshop.BoatRacingSimulator.models.boats.Boat;
import I_Workshop.BoatRacingSimulator.models.Race;

public interface RaceManager {
    void setRace(Race race) throws RaceAlreadyExistsException;
    void addBoat(Boat boat) throws DuplicateModelException, ArgumentException, NoSetRaceException;
    void startRace() throws InsufficientContestantsException, NoSetRaceException;
    String getRaceResult();
    String getStatistics();
}
