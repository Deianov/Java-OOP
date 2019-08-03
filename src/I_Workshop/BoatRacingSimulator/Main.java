package I_Workshop.BoatRacingSimulator;

import I_Workshop.BoatRacingSimulator.core.commandInterpreter.CommandHandler;
import I_Workshop.BoatRacingSimulator.core.factories.BoatWorkshop;
import I_Workshop.BoatRacingSimulator.core.factories.CommandWorkshop;
import I_Workshop.BoatRacingSimulator.core.controllers.MainController;
import I_Workshop.BoatRacingSimulator.core.factories.EngineWorkshop;
import I_Workshop.BoatRacingSimulator.core.factories.interfaces.CommandFactory;
import I_Workshop.BoatRacingSimulator.io.InputManager;
import I_Workshop.BoatRacingSimulator.io.OutputManager;
import I_Workshop.BoatRacingSimulator.models.boats.Boat;
import I_Workshop.BoatRacingSimulator.models.engines.Engine;
import I_Workshop.BoatRacingSimulator.core.controllers.RaceController;
import I_Workshop.BoatRacingSimulator.repositories.Repository;
import I_Workshop.BoatRacingSimulator.repositories.RepositoryImpl;

public class Main {
    public static void main(String[] args) {
        Repository<Boat> boatRepository = new RepositoryImpl<>();
        Repository<Engine> engineRepository = new RepositoryImpl<>();
        CommandFactory commandFactory =
                new CommandWorkshop(new EngineWorkshop(), new BoatWorkshop(engineRepository), engineRepository, boatRepository, new RaceController());
        MainController controller = new MainController(new InputManager(), new OutputManager(), new CommandHandler(commandFactory));
        controller.run();
    }
}
