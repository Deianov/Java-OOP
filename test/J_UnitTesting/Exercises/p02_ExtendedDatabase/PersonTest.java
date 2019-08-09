package J_UnitTesting.Exercises.p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    private final int ID = 1;
    private final String NAME = "Pesho";
    private Person person = new Person(ID, NAME);

    @Test
    public void getId() {
        Assert.assertEquals(ID, person.getId());
    }

    @Test
    public void getUsername() {
        Assert.assertEquals(NAME, person.getUsername());
    }
}