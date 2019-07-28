//Problem 2.	Black Box Integer
package G_Reflection.Exercises.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> aClass = BlackBoxInt.class;

        // Class instance
        BlackBoxInt objectInstance = null;
        try {
            Constructor<BlackBoxInt> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);

            objectInstance = constructor.newInstance();

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // get field by Name
        Field innerValue = null;
        try {
            innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
            innerValue.setAccessible(true);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // Methods collection
        Method[] methods = BlackBoxInt.class.getDeclaredMethods();


        String input;
        while (!"END".equals(input = scanner.nextLine())) {

            String[] data = input.split("_");
            String command = data[0];
            int value = Integer.parseInt(data[1]);

            // get method by Name
            Method method = Arrays.stream(methods)
                    .filter(m -> m.getName().equals(command))
                    .findFirst()
                    .orElse(null);

            // run method
            try {
                assert method != null;
                method.setAccessible(true);
                method.invoke(objectInstance, value);

            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }

            // print field value
            try {
                assert innerValue != null;
                System.out.println(innerValue.getInt(objectInstance));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
