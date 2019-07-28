package G_Reflection.Exercises.BWStrikeBack.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
