package I_Workshop.BoatRacingSimulator.models.engines;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;

public class Jet extends Engine {
    public Jet(String model, int horsepower, int displacement) throws ArgumentException {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return this.getHorsepower() * 5 + this.getDisplacement();
    }
}
