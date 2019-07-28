//03. BarracksWars - A New Factory
package G_Reflection.Exercises.BarracksWars;

import G_Reflection.Exercises.BarracksWars.interfaces.Repository;
import G_Reflection.Exercises.BarracksWars.interfaces.Runnable;
import G_Reflection.Exercises.BarracksWars.interfaces.UnitFactory;
import G_Reflection.Exercises.BarracksWars.core.Engine;
import G_Reflection.Exercises.BarracksWars.core.factories.UnitFactoryImpl;
import G_Reflection.Exercises.BarracksWars.data.UnitRepository;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
