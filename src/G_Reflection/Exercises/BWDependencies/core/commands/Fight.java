package G_Reflection.Exercises.BWDependencies.core.commands;

public class Fight extends Command {
    protected Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.getData()[0];
    }
}
