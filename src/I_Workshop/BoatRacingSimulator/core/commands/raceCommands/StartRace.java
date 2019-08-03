package I_Workshop.BoatRacingSimulator.core.commands.raceCommands;

import I_Workshop.BoatRacingSimulator.exceptions.InsufficientContestantsException;
import I_Workshop.BoatRacingSimulator.exceptions.NoSetRaceException;
import I_Workshop.BoatRacingSimulator.core.controllers.interfaces.RaceManager;

public class StartRace extends RaceCommand {
    public StartRace(RaceManager raceController) {
        super(raceController);
    }

    @Override
    public String execute(String[] args) {
        String message;
        try {
            this.getRaceController().startRace();
            message = this.getRaceController().getRaceResult();
        } catch (InsufficientContestantsException | NoSetRaceException e) {
           message = e.getMessage();
        }

        return message;
    }
}
