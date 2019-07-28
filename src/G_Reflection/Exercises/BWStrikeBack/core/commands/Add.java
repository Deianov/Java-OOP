package G_Reflection.Exercises.BWStrikeBack.core.commands;

import G_Reflection.Exercises.BWStrikeBack.interfaces.Repository;
import G_Reflection.Exercises.BWStrikeBack.interfaces.Unit;
import G_Reflection.Exercises.BWStrikeBack.interfaces.UnitFactory;

public class Add extends Command {

    protected Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute(){
        String unitType = super.getData()[1];
        Unit unit = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unit);

        String result = unitType + " added!";
        return result;
    }
}
