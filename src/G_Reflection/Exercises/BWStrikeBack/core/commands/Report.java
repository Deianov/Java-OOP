package G_Reflection.Exercises.BWStrikeBack.core.commands;

import G_Reflection.Exercises.BWStrikeBack.interfaces.Repository;
import G_Reflection.Exercises.BWStrikeBack.interfaces.UnitFactory;

public class Report extends Command {

    protected Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String result = super.getRepository().getStatistics();
        return result;
    }
}
