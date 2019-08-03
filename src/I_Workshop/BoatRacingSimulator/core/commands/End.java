package I_Workshop.BoatRacingSimulator.core.commands;

import I_Workshop.BoatRacingSimulator.core.commands.interfaces.Command;

public class End implements Command {
    @Override
    public String execute(String[] args) {
        return args[0];
    }
}
