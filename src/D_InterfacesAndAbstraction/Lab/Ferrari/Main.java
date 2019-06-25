// Ferrari
package D_InterfacesAndAbstraction.Lab.Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Car ferrari = new Ferrari(name);

        System.out.println(ferrari.toString());

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}
