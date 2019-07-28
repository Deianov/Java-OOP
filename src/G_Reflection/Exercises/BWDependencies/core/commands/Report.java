package G_Reflection.Exercises.BWDependencies.core.commands;

import G_Reflection.Exercises.BWDependencies.annotations.Inject;
import G_Reflection.Exercises.BWDependencies.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;

    protected Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String result = this.repository.getStatistics();
        return result;
    }
}
