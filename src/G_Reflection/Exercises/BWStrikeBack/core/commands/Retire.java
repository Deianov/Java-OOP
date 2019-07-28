package G_Reflection.Exercises.BWStrikeBack.core.commands;

import G_Reflection.Exercises.BWStrikeBack.interfaces.Repository;
import G_Reflection.Exercises.BWStrikeBack.interfaces.UnitFactory;

public class Retire extends Command {

    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];

        try {
            super.getRepository().removeUnit(unitType);

        } catch (IllegalArgumentException e) {
           return  e.getMessage();
        }

        String result = unitType + " retired!";
        return result;
    }
}
