package I_Workshop.BoatRacingSimulator.core.factories.interfaces;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.models.engines.Engine;

public interface EngineFactory {
    Engine produce(String[] args) throws ArgumentException;
}
