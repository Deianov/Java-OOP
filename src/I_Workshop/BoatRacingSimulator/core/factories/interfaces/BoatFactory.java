package I_Workshop.BoatRacingSimulator.core.factories.interfaces;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.exceptions.NonExistantModelException;
import I_Workshop.BoatRacingSimulator.models.boats.Boat;

public interface BoatFactory {
    Boat produce(String[] args) throws ArgumentException, NonExistantModelException;
}
