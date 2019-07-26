package G_Reflection.Lab.L03;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);


        Method[] setters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Field[] fields = Arrays.stream(reflection.getFields())
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);

        for (Field field : fields) {

            int modifiers = field.getModifiers();

            if (!Modifier.isPrivate(modifiers)) {
                System.out.println(String.format("%s must be private!", field.getName()));
            }
        }

        for (Method method : getters) {

            int modifiers = method.getModifiers();

            if (!Modifier.isPublic(modifiers)) {
                System.out.println(String.format("%s have to be public!", method.getName()));
            }
        }

        for (Method method : setters) {

            int modifiers = method.getModifiers();

            if (!Modifier.isPrivate(modifiers)) {
                System.out.println(String.format("%s have to be private!", method.getName()));
            }
        }

    }
}
