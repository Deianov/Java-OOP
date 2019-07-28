package G_Reflection.Exercises.BWDependencies.core.factories;

import G_Reflection.Exercises.BWDependencies.interfaces.Unit;
import G_Reflection.Exercises.BWDependencies.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "G_Reflection.Exercises.BWDependencies.models.units.";

	@Override
	public Unit createUnit(String unitType) {

		String unitClass = UNITS_PACKAGE_NAME + unitType;

		try {
			Class unit = Class.forName(unitClass);
			Constructor constructor = unit.getDeclaredConstructors()[0];
			constructor.setAccessible(true);
			Object trainUnit = constructor.newInstance();
			return (Unit)trainUnit;

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException ignore) {
		}

		throw new IllegalArgumentException("Wrong unit type: " + unitType);
	}
}
