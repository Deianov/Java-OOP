package J_UnitTesting.Exercises.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private String[] elements = {"A", "B", "C", "D", "E"};
    private ListIterator list;

    @Before
    public void createList() throws OperationNotSupportedException {
        this.list = new ListIterator(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingListWithNullShouldThrowException() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void moveShouldReturnTrueIfAbelToMove(){
        for (int i = 1; i < elements.length; i++) {
            Assert.assertTrue(list.move());
        }
    }

    @Test
    public void moveShouldReturnFalseIfNotNextElement(){
        for (int i = 1; i < elements.length; i++) {
            Assert.assertTrue(list.move());
        }
        Assert.assertFalse(list.move());
    }

    @Test
    public void hasNextShouldReturnTrueIfHasNext(){
        Assert.assertTrue(list.hasNext());
    }

    @Test
    public void hasNextShouldReturnFalseIfHasNotNext() throws OperationNotSupportedException {
        list = new ListIterator("A");
        Assert.assertFalse(list.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldThrowExceptionOnEmptyCollection() throws OperationNotSupportedException {
        new ListIterator().print();
    }

    @Test
    public void printShouldReturnCorrectElement(){
        Assert.assertEquals(this.list.print(), elements[0]);
    }

}