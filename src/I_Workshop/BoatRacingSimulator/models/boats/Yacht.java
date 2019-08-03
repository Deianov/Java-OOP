package I_Workshop.BoatRacingSimulator.models.boats;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.helpers.Validator;
import I_Workshop.BoatRacingSimulator.models.engines.Engine;
import I_Workshop.BoatRacingSimulator.models.Race;

public class Yacht extends Boat {
    private Engine engine;
    private int cargoWeight;
    public Yacht(String model, int weight, Engine engine, int cargoWeight) throws ArgumentException {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) throws ArgumentException {
        if(Validator.validateParam(cargoWeight)) {
            this.cargoWeight = cargoWeight;
        } else {
            throw  new ArgumentException(Validator.generateErrorMessage("Cargo Weight"));
        }
    }

    @Override
    public double calcSpeed(Race race) {
        return this.engine.getOutput() - (this.getWeight() + this.cargoWeight) + (race.getCurrentSpeed() / 2.00);
    }
}
