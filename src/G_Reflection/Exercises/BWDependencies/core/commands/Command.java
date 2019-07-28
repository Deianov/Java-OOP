package G_Reflection.Exercises.BWDependencies.core.commands;

import G_Reflection.Exercises.BWDependencies.interfaces.Executable;

public abstract class Command implements Executable {

    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }
}
