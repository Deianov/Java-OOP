package J_UnitTesting.Lab.rpg_lab;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private final int TARGET_EXPERIENCE = 10;
    private final int TARGET_HEALTH = 10;
    private final boolean TARGET_IS_DEAD = true;
    private final int WEAPON_ATTACK = 10;
    private final int WEAPON_DURABILITY = 10;
    private final String HERO_NAME = "Pesho";
    @Test
    public void AttackGainsExperienceIfTargetIsDead() {
        // Anonymous class - Mockito object
        Target mockTarget = Mockito.mock(Target.class);
        Mockito.when(mockTarget.giveExperience()).thenReturn(TARGET_EXPERIENCE);
        Mockito.when(mockTarget.isDead()).thenReturn(Boolean.TRUE);
        // Anonymous class - instance of interface
        Weapon fakeWeapon = new Weapon() {
            public void attack(Target target) { }
            public int getAttackPoints() { return WEAPON_ATTACK; }
            public int getDurabilityPoints() { return 0; }
        };
        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(mockTarget);
        Assert.assertEquals("Wrong experience", TARGET_EXPERIENCE, hero.getExperience());
    }
}