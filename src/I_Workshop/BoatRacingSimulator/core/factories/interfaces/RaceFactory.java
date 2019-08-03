package I_Workshop.BoatRacingSimulator.core.factories.interfaces;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.models.Race;

public interface RaceFactory {
    Race produce(String[] args) throws ArgumentException;
}
