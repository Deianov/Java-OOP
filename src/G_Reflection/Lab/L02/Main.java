package G_Reflection.Lab.L02;

import java.lang.reflect.Method;
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

        Arrays.stream(getters)
                .forEach(method -> System.out.println(String.format("%s will return class %s",
                        method.getName(),
                        method.getReturnType().getName()))
                );

        Method[] setters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters)
                .forEach(method -> System.out.println(String.format("%s and will set field of class %s",
                        method.getName(),
                        method.getParameters()[0].getType().getName()))
                );
    }
}
