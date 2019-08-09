package J_UnitTesting.Lab.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DummyTest {
    private Axe axe;
    private final int AXE_ATTACK = 10;
    private final int AXE_DURABILITY = 10;
    private Dummy dummy;
    private final int DUMMY_HEALTH = 20;
    private final int DUMMY_EXPERIENCE = 10;
    @Before
    public void initValues(){
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }
    @Test
    public void dummyShouldLosesHealthIfAttacked() {
        axe.attack(dummy);
        Assert.assertEquals((DUMMY_HEALTH - AXE_ATTACK), dummy.getHealth());
    }
    @Test (expected = IllegalStateException.class)
    public void dummyShouldThrowsExceptionIfAttacked() {
        axe.attack(dummy);
        axe.attack(dummy);
        // Dummy is dead
        axe.attack(dummy);
    }
    @Test
    public void dummyCanGiveXP() {
        axe.attack(dummy);
        axe.attack(dummy);
        // Dummy is dead
        Assert.assertEquals("Message",DUMMY_EXPERIENCE, dummy.giveExperience());
    }
    @Test(expected =  IllegalStateException.class)
    public void dummyShouldThrowsExceptionCantGiveXPIfNotDead() {
        axe.attack(dummy);
        // Dummy is not dead
        dummy.giveExperience();
    }
}