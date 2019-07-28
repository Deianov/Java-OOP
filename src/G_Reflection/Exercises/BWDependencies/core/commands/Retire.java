package G_Reflection.Exercises.BWDependencies.core.commands;

import G_Reflection.Exercises.BWDependencies.annotations.Inject;
import G_Reflection.Exercises.BWDependencies.interfaces.Repository;

public class Retire extends Command {
    @Inject
    private Repository repository;

    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];

        try {
            this.repository.removeUnit(unitType);

        } catch (IllegalArgumentException e) {
           return  e.getMessage();
        }

        String result = unitType + " retired!";
        return result;
    }
}
