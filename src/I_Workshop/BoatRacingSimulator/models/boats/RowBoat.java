package I_Workshop.BoatRacingSimulator.models.boats;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.helpers.Validator;
import I_Workshop.BoatRacingSimulator.models.Race;

public class RowBoat extends Boat {
    private int oars;
    public RowBoat(String model, int weight, int oars) throws ArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) throws ArgumentException {
        if(Validator.validateParam(oars)) {
            this.oars = oars;
        } else {
            throw new ArgumentException(Validator.generateErrorMessage("Oars"));
        }
    }

    @Override
    public double calcSpeed(Race race) {
        return (this.oars * 100) - this.getWeight() + race.getCurrentSpeed();
    }
}
