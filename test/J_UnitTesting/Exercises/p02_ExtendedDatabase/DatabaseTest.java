package J_UnitTesting.Exercises.p02_ExtendedDatabase;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database db;
    private Person[] people;
    private final String[] NAMES = {"A", "B", "C", "D", "E",};

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        people = new Person[NAMES.length];

        for (int i = 0; i < NAMES.length ; i++) {
            people[i] = new Person(i + 1, NAMES[i]);
        }
        db = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUserNameShouldThrowExceptionWhenCalledWithNull() throws OperationNotSupportedException {
        db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionWithDuplicatedUsername() throws OperationNotSupportedException {
        int newID = NAMES.length;
        String duplicateName = NAMES[0];

        db.add(new Person(newID + 1, duplicateName));
        db.findByUsername(duplicateName);
    }

    @Test
    public void findByUsernameReturnPersonCorrectly() throws OperationNotSupportedException {
        Person firstPerson = people[0];
        Assert.assertEquals(firstPerson, db.findByUsername(firstPerson.getUsername()));
    }

    @Test
    public void findByIDReturnPersonCorrectly() throws OperationNotSupportedException {
        Person firstPerson = people[0];
        Assert.assertEquals(firstPerson, db.findById(firstPerson.getId()));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIDShouldThrowExceptionWithDuplicatedID() throws OperationNotSupportedException {
        Person firstPerson = people[0];
        db.add(firstPerson);
        db.findById(firstPerson.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullPersonShouldThrowException() throws OperationNotSupportedException {
        db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyDBShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i <= NAMES.length ; i++) {
            db.remove();
        }
    }

    @Test
    public void removeWorkCorrectly() throws OperationNotSupportedException {
        db.remove();
        Assert.assertEquals(db.getElements().length, NAMES.length - 1);
    }

    @Test
    public void getElementsWorkCorrectly(){
        Assert.assertArrayEquals(people, db.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void setElementsWhitLengthMoreThan16ShouldThrowException() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void setElementsWhitEmptyShouldThrowException() throws OperationNotSupportedException {
        new Database();
    }
}