package Q_Exams.DemoExam04August2019.UnitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;


public class RaceEntryTest {
    private RaceEntry raceEntry;

    private UnitRider rider;
    private final String riderName = "Jon Snow";
    private final String RIDER_ADDED_MESSAGE = String.format("Rider %s added in race.", riderName);

    private final int DEFAULT_HORSEPOWER = 20;
    private final double DEFAULT_CUBIC_CENTIMETERS = 450;
    private final double DEFAULT_DELTA = 0.001;

    @Before
    public void init(){
        this.raceEntry = new RaceEntry();
        this.rider = new UnitRider(riderName, null);
    }

    @Test(expected = NullPointerException.class)
    public void addingRaiderWithNullValueShouldThrowException(){
        raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingTheSameUnitShouldThrowException(){
        UnitRider riderWhitSameName = new UnitRider(riderName, null);
        this.raceEntry.addRider(rider);
        this.raceEntry.addRider(riderWhitSameName);
    }

    @Test
    public void addingShouldReturnCorrectObject(){
        String result = this.raceEntry.addRider(rider);
        Assert.assertEquals(RIDER_ADDED_MESSAGE, result);
    }

    @Test
    public void addingShouldIncreaseSize(){
        this.raceEntry.addRider(rider);
        Assert.assertEquals(1, this.raceEntry.getRiders().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculatingAVGHorsePowerShouldThrowExceptionWithLessThanTwoRaiders(){
        rider = new UnitRider(riderName, new UnitMotorcycle("Name", DEFAULT_HORSEPOWER, DEFAULT_CUBIC_CENTIMETERS));
        this.raceEntry.addRider(rider);
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void calculatingAVGHorsePowerWorkCorrectly(){
        UnitRider riderA = new UnitRider("NameA", new UnitMotorcycle("ModelA", DEFAULT_HORSEPOWER, DEFAULT_CUBIC_CENTIMETERS));
        UnitRider riderB = new UnitRider("NameB", new UnitMotorcycle("ModelB", DEFAULT_HORSEPOWER, DEFAULT_CUBIC_CENTIMETERS));
        this.raceEntry.addRider(riderA);
        this.raceEntry.addRider(riderB);
        double result = this.raceEntry.calculateAverageHorsePower();

        Assert.assertEquals(DEFAULT_HORSEPOWER, result, DEFAULT_DELTA);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getRaidersShouldReturnUnmodifiableCollection(){
        Collection<UnitRider> riders = this.raceEntry.getRiders();
        riders.clear();
    }
}