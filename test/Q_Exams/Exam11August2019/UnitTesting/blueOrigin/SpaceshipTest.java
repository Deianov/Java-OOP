package Q_Exams.Exam11August2019.UnitTesting.blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SpaceshipTest {
    private Spaceship spaceship;
    private Astronaut astronaut1;
    private Astronaut astronaut2;

    @Before
    public void init() {
        spaceship = new Spaceship("Test", 2);
        astronaut1 = new Astronaut("A", 0);
        astronaut2 = new Astronaut("B", 100);
    }

    @Test
    public void constructorReturnObject(){
        Assert.assertNotNull(spaceship);
    }

    @Test
    public void getCountReturn() {
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test
    public void getNameReturn() {
        Assert.assertEquals("Test", spaceship.getName());
    }

    @Test
    public void getCapacityReturn() {
        Assert.assertEquals(2, spaceship.getCapacity());
    }

    @Test
    public void addingIncreaseCount() {
        spaceship.add(astronaut1);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingInFullSpaceshipThrowException() {
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(new Astronaut("C", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingExistThrowException() {
        spaceship.add(astronaut1);
        spaceship.add(new Astronaut("A", 0));
    }

    @Test
    public void removingReturnTrue() {
        spaceship.add(astronaut1);
        Assert.assertTrue(spaceship.remove(astronaut1.getName()));
    }

    @Test
    public void removingReturnFalse() {
        spaceship.add(astronaut1);
        Assert.assertFalse(spaceship.remove(null));
    }

    @Test
    public void removingRemoveObject() {
        spaceship.add(astronaut1);
        spaceship.remove(astronaut1.getName());
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityThrowException() {
        new Spaceship("2", -1);
    }

    @Test(expected = NullPointerException.class)
    public void setNameThrowExceptionWithNull() {
        new Spaceship(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void setNameThrowExceptionWithEmptyString() {
        new Spaceship("  ", 1);
    }
}