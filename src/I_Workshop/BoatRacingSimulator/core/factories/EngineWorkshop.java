package I_Workshop.BoatRacingSimulator.core.factories;

import I_Workshop.BoatRacingSimulator.core.factories.interfaces.EngineFactory;
import I_Workshop.BoatRacingSimulator.exceptions.ArgumentException;
import I_Workshop.BoatRacingSimulator.models.engines.Engine;
import I_Workshop.BoatRacingSimulator.models.engines.Jet;
import I_Workshop.BoatRacingSimulator.models.engines.Sterndrive;

public class EngineWorkshop implements EngineFactory {
    @Override
    public Engine produce(String[] args) throws ArgumentException {
        String type = args[args.length - 1];

        String model = args[1];
        int hp = Integer.parseInt(args[2]);
        int dis = Integer.parseInt(args[3]);

        Engine engine = null;

        switch (type) {
            case "Jet":
                engine = new Jet(model, hp, dis);
                break;
            case "Sterndrive":
                engine = new Sterndrive(model, hp, dis);
                break;
        }
        return engine;
    }
}
