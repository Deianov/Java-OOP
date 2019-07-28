// 05. BarracksWars - Return of the Dependencies
package G_Reflection.Exercises.BWDependencies;

import G_Reflection.Exercises.BWDependencies.core.Engine;
import G_Reflection.Exercises.BWDependencies.core.commands.CommandInterpreterImpl;
import G_Reflection.Exercises.BWDependencies.core.factories.UnitFactoryImpl;
import G_Reflection.Exercises.BWDependencies.data.UnitRepository;
import G_Reflection.Exercises.BWDependencies.interfaces.CommandInterpreter;
import G_Reflection.Exercises.BWDependencies.interfaces.Repository;
import G_Reflection.Exercises.BWDependencies.interfaces.Runnable;
import G_Reflection.Exercises.BWDependencies.interfaces.UnitFactory;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
