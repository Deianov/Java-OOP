package J_UnitTesting.Exercises.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;

public class SensorTest {

    private final Sensor sensor = new Sensor();

    @Test
    public void sensorReturnRandomNumbers(){
        Assert.assertNotEquals(sensor.popNextPressurePsiValue(), sensor.popNextPressurePsiValue());
    }

}