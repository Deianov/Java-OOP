package G_Reflection.Exercises.BWDependencies.core.commands;

import G_Reflection.Exercises.BWDependencies.annotations.Inject;
import G_Reflection.Exercises.BWDependencies.interfaces.Repository;
import G_Reflection.Exercises.BWDependencies.interfaces.Unit;
import G_Reflection.Exercises.BWDependencies.interfaces.UnitFactory;

public class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Add(String[] data) {
        super(data);
    }

    @Override
    public String execute(){
        String unitType = super.getData()[1];
        Unit unit = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unit);

        String result = unitType + " added!";
        return result;
    }
}
