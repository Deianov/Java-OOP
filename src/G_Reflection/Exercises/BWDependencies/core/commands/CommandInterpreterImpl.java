package G_Reflection.Exercises.BWDependencies.core.commands;

import G_Reflection.Exercises.BWDependencies.annotations.Inject;
import G_Reflection.Exercises.BWDependencies.interfaces.CommandInterpreter;
import G_Reflection.Exercises.BWDependencies.interfaces.Executable;
import G_Reflection.Exercises.BWDependencies.interfaces.Repository;
import G_Reflection.Exercises.BWDependencies.interfaces.UnitFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_PATH = "G_Reflection.Exercises.BWDependencies.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable = null;
        commandName =  commandName.substring(0, 1).toUpperCase() + commandName.substring(1).toLowerCase();

        try {
            Class<? extends Executable> aClass = (Class<? extends Executable>) Class.forName(COMMANDS_PACKAGE_PATH + commandName);
            Constructor<? extends Executable> constructor = aClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);

            executable = constructor.newInstance((Object) data);

            // Inject
            this.injectFields(executable);
        } catch (ClassNotFoundException ignore) {


        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return executable;
    }

    private void injectFields(Executable executable) {

        Field[] fields = executable.getClass().getDeclaredFields();
        Field[] currentFields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(Inject.class);

            if (annotation != null) {

                for (Field currentField : currentFields) {
                    if (currentField.getType().equals(field.getType())) {
                        try {
                            field.setAccessible(true);
                            field.set(executable, currentField.get(this));

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
