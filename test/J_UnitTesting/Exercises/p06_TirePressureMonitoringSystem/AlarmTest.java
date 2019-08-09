package J_UnitTesting.Exercises.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class AlarmTest {
    private final double LOW_PRESSURE_THRESHOLD = 17;
    private final double HIGH_PRESSURE_THRESHOLD = 21;
    private Alarm alarm;
    private Sensor sensor;

    public AlarmTest() throws NoSuchFieldException, IllegalAccessException {
        this.setInitialVariables();
    }

    private void setInitialVariables() throws NoSuchFieldException, IllegalAccessException {
        alarm = new Alarm();
        sensor = Mockito.mock(Sensor.class);

        // Set field with Reflection
        Field sensorField = Alarm.class.getDeclaredField("sensor");
        sensorField.setAccessible(true);
        sensorField.set(alarm, sensor);
    }

    @Test
    public void alarmOnSensorIsLessThanRange() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD - 1);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmOnSensorIsMoreThanRange() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD + 1);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmOffSensorInRange() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn((LOW_PRESSURE_THRESHOLD + HIGH_PRESSURE_THRESHOLD) / 2.0);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}