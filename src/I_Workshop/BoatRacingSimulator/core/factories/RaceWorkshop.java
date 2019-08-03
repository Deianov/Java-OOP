package I_Workshop.BoatRacingSimulator.core.factories;

import I_Workshop.BoatRacingSimulator.core.factories.interfaces.RaceFactory;
import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.models.Race;

public class RaceWorkshop implements RaceFactory {
    @Override
    public Race produce(String[] args) throws ArgumentException {
        return new Race(Integer.parseInt(args[1]),
                                    Integer.parseInt(args[2]),
                                    Integer.parseInt(args[3]),
                                    Boolean.parseBoolean(args[4]));
    }
}
