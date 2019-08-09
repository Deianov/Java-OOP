package J_UnitTesting.Exercises.p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> integerList;

    @Before
    public void createList(){
        integerList = new CustomLinkedList<>();
    }

    @Test
    public void getIntegerElementAtIndexReturnElement(){
        integerList.add(13);
        integerList.add(14);
        Assert.assertEquals(14, integerList.get(1).intValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getElementAtInvalidIndexThrowException(){
        integerList.add(13);
        integerList.get(1);
    }

    @Test
    public void addingShouldWork(){
        integerList.add(13);
        integerList.add(14);
        Assert.assertEquals(14, integerList.get(1).intValue());
    }

    @Test
    public void removingElementIntegerShouldWork(){
        integerList.add(13);
        integerList.remove(13);
        Assert.assertFalse(integerList.contains(13));
    }

    @Test
    public void removingNotFoundElementShouldReturnMinusOne(){
        integerList.add(13);
        Assert.assertEquals(-1, integerList.remove(14));
    }

    @Test
    public void removingElementFromEmptyListShouldReturnMinusOne(){
        Assert.assertEquals(-1, integerList.remove(13));
    }

    @Test
    public void removingByIndexShouldWork(){
        integerList.add(13);
        integerList.add(14);
        integerList.removeAt(0);
        Assert.assertFalse(integerList.contains(13));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removingByNegativeIndexShouldThrowException(){
        integerList.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removingInvalidIndexShouldThrowException(){
        integerList.add(13);
        integerList.removeAt(1);
    }

    @Test
    public void indexOfIntegerElementReturnCorrectIndex(){
        integerList.add(13);
        integerList.add(14);
        Assert.assertEquals(1, integerList.indexOf(14));
    }

    @Test
    public void indexOfNotExistElementShouldReturnMinusOne(){
        integerList.add(13);
        Assert.assertEquals(-1, integerList.indexOf(14));
    }

    @Test
    public void containsIntegerElementShouldReturnTrue(){
        integerList.add(13);
        Assert.assertTrue(integerList.contains(13));
    }

    @Test
    public void containsNotExistIntegerElementShouldReturnFalse(){
        integerList.add(13);
        Assert.assertFalse(integerList.contains(14));
    }



}