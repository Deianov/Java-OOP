package G_Reflection.Exercises.BWStrikeBack.core;

import G_Reflection.Exercises.BWStrikeBack.interfaces.Repository;
import G_Reflection.Exercises.BWStrikeBack.interfaces.Runnable;
import G_Reflection.Exercises.BWStrikeBack.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Engine implements Runnable {
	private static final String COMMANDS_PACKAGE_NAME = "G_Reflection.Exercises.BWStrikeBack.core.commands.";

	private Repository repository;
	private UnitFactory unitFactory;


	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				if (commandName.equalsIgnoreCase("fight")) {
					break;
				}
				String result = interpretCommand(data, commandName);
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) {

		String className = COMMANDS_PACKAGE_NAME + commandName.substring(0, 1).toUpperCase() + commandName.substring(1).toLowerCase();
		String result = "Invalid command!";

		try {
			Class aClass = Class.forName(className);
			Constructor constructor = aClass.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			constructor.setAccessible(true);

			Object classInstance = constructor.newInstance(data, this.repository, this.unitFactory);

			Method methodExecute = Arrays.stream(aClass.getDeclaredMethods())
					.filter(method -> method.getName().equals("execute"))
					.findFirst()
					.orElse(null);

			methodExecute.setAccessible(true);
			result = (String) methodExecute.invoke(classInstance);

		} catch (ClassNotFoundException  e) {
			return result;

		} catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return result;
	}
}
