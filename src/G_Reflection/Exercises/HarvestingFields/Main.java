//01. Harvesting Fields
package G_Reflection.Exercises.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> aClass = RichSoilLand.class;
		Field[] fields = aClass.getDeclaredFields();

		Predicate<Field> predicate;

		String input;
		while (!"HARVEST".equals(input = scanner.nextLine())) {

			predicate = null;

			switch (input) {
				case "private" :
					predicate = field -> Modifier.isPrivate(field.getModifiers());
					break;
				case "protected" :
					predicate = field -> Modifier.isProtected(field.getModifiers());
					break;
				case "public" :
					predicate = field -> Modifier.isPublic(field.getModifiers());
					break;
				case "all" :
					predicate = field -> true;
					break;
			}

			if (predicate != null) {

				Arrays.stream(fields)
						.filter(predicate)
						.forEach(field -> System.out.println(String.format("%s %s %s"
								, Modifier.toString(field.getModifiers())
								, field.getType().getSimpleName()
								, field.getName()
						)));
			}
		}
	}
}
