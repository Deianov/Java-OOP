package Q_Exams.RetakeExam15August2019.UnitTesting.heroRepository;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTest {
    private HeroRepository heroRepository;
    private Hero hero1;
    private Hero hero2;

    @Before
    public void init() {
        heroRepository = new HeroRepository();
        hero1 = new Hero("A", 10);
        hero2 = new Hero("B", 20);
    }

    @Test
    public void constructor_Return() {
        Assert.assertNotNull(heroRepository);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getRepositoryReturnUnMCollection() {
        heroRepository.getHeroes().clear();
    }

    @Test
    public void getCountMethod() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.remove(hero2.getName());
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void creatHeroNull (){
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatHeroExist (){
        heroRepository.create(hero1);
        heroRepository.create(hero1);
    }

    @Test
    public void createHeroReturn (){
        String result = heroRepository.create(hero1);
        String exp = String.format("Successfully added hero %s with level %d", hero1.getName(), hero1.getLevel());
        Assert.assertEquals(exp, result);
    }

    @Test(expected = NullPointerException.class)
    public void removeNullHeroException (){
        heroRepository.remove(null);
    }

    @Test
    public void removeReturn (){
        Assert.assertFalse(heroRepository.remove(hero1.getName()));
        heroRepository.create(hero1);
        Assert.assertTrue(heroRepository.remove(hero1.getName()));
    }

    @Test
    public void getHeroWithHLevel (){
        Assert.assertNull(heroRepository.getHeroWithHighestLevel());
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        Hero hero = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(hero2.getLevel(), hero.getLevel());
    }

    @Test
    public void getHeroMethod (){
        heroRepository.create(hero1);
        Assert.assertEquals(hero1, heroRepository.getHero(hero1.getName()) );
    }
}