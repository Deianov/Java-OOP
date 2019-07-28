//04. BarracksWars - The Commands Strike Back
package G_Reflection.Exercises.BWStrikeBack;

import G_Reflection.Exercises.BWStrikeBack.core.Engine;
import G_Reflection.Exercises.BWStrikeBack.core.factories.UnitFactoryImpl;
import G_Reflection.Exercises.BWStrikeBack.data.UnitRepository;
import G_Reflection.Exercises.BWStrikeBack.interfaces.Repository;
import G_Reflection.Exercises.BWStrikeBack.interfaces.Runnable;
import G_Reflection.Exercises.BWStrikeBack.interfaces.UnitFactory;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
