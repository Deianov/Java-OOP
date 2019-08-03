package I_Workshop.BoatRacingSimulator.core.commands.raceCommands;

import I_Workshop.BoatRacingSimulator.core.factories.interfaces.RaceFactory;
import I_Workshop.BoatRacingSimulator.core.factories.RaceWorkshop;
import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.exceptions.RaceAlreadyExistsException;
import I_Workshop.BoatRacingSimulator.models.Race;
import I_Workshop.BoatRacingSimulator.core.controllers.interfaces.RaceManager;

public class OpenRace extends RaceCommand {
    private RaceFactory raceFactory;

    public OpenRace(RaceManager raceController) {
        super(raceController);
        raceFactory = new RaceWorkshop();
    }

    @Override
    public String execute(String[] args) {
        String message;
        try {
            Race race = this.raceFactory.produce(args);
            this.getRaceController().setRace(race);
            message =
                    String.format(
                            "A new race with distance %d meters, " +
                                    "wind speed %d m/s and ocean current speed %d m/s has been set.",
                    race.getDistance(), race.getWindSpeed(), race.getCurrentSpeed());
        } catch (ArgumentException | RaceAlreadyExistsException e) {
            message = e.getMessage();
        }

        return message;
    }
}
