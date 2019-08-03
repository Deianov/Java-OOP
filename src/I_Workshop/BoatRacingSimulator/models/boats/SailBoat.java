package I_Workshop.BoatRacingSimulator.models.boats;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.helpers.Validator;
import I_Workshop.BoatRacingSimulator.models.Race;

public class SailBoat extends Boat {
    private int sailEfficiency;
    public SailBoat(String model, int weight, int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if(Validator.validateSailEfficiency(sailEfficiency)){
            this.sailEfficiency = sailEfficiency;
        } else {
            throw new ArgumentException("Sail Effectiveness must be between [1...100].");
        }
    }

    @Override
    public double calcSpeed(Race race) {
        return (race.getWindSpeed() * (this.sailEfficiency / 100.00)) - this.getWeight() + (race.getCurrentSpeed() / 2.00) ;
    }
}
