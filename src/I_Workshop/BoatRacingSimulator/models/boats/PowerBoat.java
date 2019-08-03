package I_Workshop.BoatRacingSimulator.models.boats;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.models.engines.Engine;
import I_Workshop.BoatRacingSimulator.models.Race;

public class PowerBoat extends Boat {
    private Engine primaryEngine;
    private Engine secondaryEngine;

    public PowerBoat(String model, int weight, Engine primaryEngine,
                     Engine secondaryEngine) throws ArgumentException {
        super(model, weight);
        this.primaryEngine = primaryEngine;
        this.secondaryEngine = secondaryEngine;
    }

    @Override
    public double calcSpeed(Race race) {
        return (this.primaryEngine.getOutput()
                + this.secondaryEngine.getOutput()) - this.getWeight()
                + (race.getCurrentSpeed() / 5.00);
    }
}
