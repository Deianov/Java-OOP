package I_Workshop.BoatRacingSimulator.core.commands.boatCommands;

import I_Workshop.BoatRacingSimulator.core.factories.interfaces.BoatFactory;
import I_Workshop.BoatRacingSimulator.core.commands.interfaces.Command;
import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.exceptions.DuplicateModelException;
import I_Workshop.BoatRacingSimulator.exceptions.NonExistantModelException;
import I_Workshop.BoatRacingSimulator.models.boats.Boat;
import I_Workshop.BoatRacingSimulator.repositories.Repository;

public abstract class BoatCommand implements Command {
    private Repository<Boat> boatRepository;
    private BoatFactory boatFactory;

    protected BoatCommand(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        this.boatRepository = boatRepository;
        this.boatFactory = boatFactory;
    }

    @Override
    public String execute(String[] args) {
        String message;
        try {
            Boat boat = this.boatFactory.produce(args);
            if (boat != null) {
                boatRepository.add(boat);
                message = String.format("%s with model %s registered successfully.",
                        this.getClass().getSimpleName().replace("Create", "").replace("Boat", " boat"), args[1]);
            } else {
                throw new NonExistantModelException("Invalid boat model!");
            }
        } catch (ArgumentException | DuplicateModelException | NonExistantModelException e) {
            message = e.getMessage();
        }
        return message;
    }
}
