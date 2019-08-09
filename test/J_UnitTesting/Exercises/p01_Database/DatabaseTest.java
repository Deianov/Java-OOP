package J_UnitTesting.Exercises.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class DatabaseTest {

    private Database db;
    private static final int MAX_ELEMENTS_COUNT = 16;

    private static final Integer[] INITIAL_ELEMENTS = {
            13, 42, 69, 73
    };

    @Before
    public void initDatabase() throws OperationNotSupportedException {
        db = new Database(INITIAL_ELEMENTS);
    }

    @Test
    public void creatingDatabaseShouldSetElementsCorrectly() {
        Assert.assertArrayEquals(this.db.getElements(), INITIAL_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithZeroElementShouldThrowException() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithMoreThanSixteenElementShouldThrowException() throws OperationNotSupportedException {
        new Database(new Integer[MAX_ELEMENTS_COUNT + 1]);
    }

    @Test
    public void addingElementShouldAddCorrectly() throws OperationNotSupportedException {
        int currentLength = this.db.getElements().length;
        int newElement = 17;
        this.db.add(newElement);
        Assert.assertEquals( currentLength + 1, this.db.getElements().length);
        Assert.assertEquals(newElement, this.db.getElements()[currentLength].intValue());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullShouldThrowException() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingFromEmptyDatabaseShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i <= INITIAL_ELEMENTS.length ; i++) {
            this.db.remove();
        }
    }

    @Test
    public void removeShouldDecreaseElementCount() throws OperationNotSupportedException {
        this.db.remove();
        Assert.assertEquals(this.db.getElements().length, INITIAL_ELEMENTS.length - 1);
    }

}