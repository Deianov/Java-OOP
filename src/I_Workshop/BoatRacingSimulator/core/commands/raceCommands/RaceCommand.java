package I_Workshop.BoatRacingSimulator.core.commands.raceCommands;

import I_Workshop.BoatRacingSimulator.core.commands.interfaces.Command;
import I_Workshop.BoatRacingSimulator.core.controllers.interfaces.RaceManager;

public abstract class RaceCommand implements Command {
    private RaceManager raceController;

    protected RaceCommand(RaceManager raceController) {
        this.raceController = raceController;
    }

    protected RaceManager getRaceController() {
        return this.raceController;
    }
}
