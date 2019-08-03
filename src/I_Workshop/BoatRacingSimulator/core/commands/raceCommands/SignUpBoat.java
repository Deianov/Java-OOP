package I_Workshop.BoatRacingSimulator.core.commands.raceCommands;

import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.exceptions.DuplicateModelException;
import I_Workshop.BoatRacingSimulator.exceptions.NoSetRaceException;
import I_Workshop.BoatRacingSimulator.exceptions.NonExistantModelException;
import I_Workshop.BoatRacingSimulator.models.boats.Boat;
import I_Workshop.BoatRacingSimulator.core.controllers.interfaces.RaceManager;
import I_Workshop.BoatRacingSimulator.repositories.Repository;

public class SignUpBoat extends RaceCommand {
    private Repository<Boat> boatRepository;

    public SignUpBoat(RaceManager raceController, Repository<Boat> boatRepository) {
        super(raceController);
        this.boatRepository = boatRepository;
    }

    @Override
    public String execute(String[] args) {
        String message;

        String model = args[1];

        try {
            this.getRaceController().addBoat(this.boatRepository.get(model));
            message = String.format("Boat with model %s has signed up for the current Race.", model);
        } catch (DuplicateModelException | ArgumentException | NoSetRaceException | NonExistantModelException e) {
            message = e.getMessage();
        }

        return message;
    }
}
