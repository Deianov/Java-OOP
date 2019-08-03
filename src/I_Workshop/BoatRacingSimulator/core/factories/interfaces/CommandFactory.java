package I_Workshop.BoatRacingSimulator.core.factories.interfaces;

import I_Workshop.BoatRacingSimulator.core.commands.interfaces.Command;

public interface CommandFactory {
    Command produce(String type);
}
