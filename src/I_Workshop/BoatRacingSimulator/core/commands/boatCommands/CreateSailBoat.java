package I_Workshop.BoatRacingSimulator.core.commands.boatCommands;

import I_Workshop.BoatRacingSimulator.core.factories.interfaces.BoatFactory;
import I_Workshop.BoatRacingSimulator.models.boats.Boat;
import I_Workshop.BoatRacingSimulator.repositories.Repository;

public class CreateSailBoat extends BoatCommand {
    public CreateSailBoat(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        super(boatRepository, boatFactory);
    }
}
