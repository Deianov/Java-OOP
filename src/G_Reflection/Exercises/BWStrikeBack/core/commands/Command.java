package G_Reflection.Exercises.BWStrikeBack.core.commands;

import G_Reflection.Exercises.BWStrikeBack.interfaces.Executable;
import G_Reflection.Exercises.BWStrikeBack.interfaces.Repository;
import G_Reflection.Exercises.BWStrikeBack.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {

        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }
}
