package G_Reflection.Exercises.BWDependencies.core;

import G_Reflection.Exercises.BWDependencies.interfaces.*;
import G_Reflection.Exercises.BWDependencies.interfaces.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
	private CommandInterpreter commandInterpreter;

	public Engine(CommandInterpreter commandInterpreter) {
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = "Invalid command!";

				Executable command = this.commandInterpreter.interpretCommand(data, commandName);

				if (command != null) {
					result = command.execute();
				}

				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);

			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
