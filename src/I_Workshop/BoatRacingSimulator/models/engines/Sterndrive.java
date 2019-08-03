package I_Workshop.BoatRacingSimulator.models.engines;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.models.engines.Engine;

public class Sterndrive extends Engine {
    public Sterndrive(String model, int horsepower, int displacement) throws ArgumentException {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return this.getHorsepower() * 7 + this.getDisplacement();
    }
}
