package G_Reflection.Exercises.BWDependencies.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
