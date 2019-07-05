package C_Inheritance.Exercises.Animals.animals;

public class Tomcat extends Cat {
    private static final String GENDER = "Male";
    private static final String ANIMAL_SOUND = "MEOW";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return ANIMAL_SOUND;
    }
}
