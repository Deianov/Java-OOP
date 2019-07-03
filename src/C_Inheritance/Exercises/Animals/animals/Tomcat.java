package C_Inheritance.Exercises.Animals.animals;

public class Tomcat extends Cat {
    private static final String ANIMAL_GENDER = "Male";
    private static final String ANIMAL_SOUND = "MEOW";

    public Tomcat(String name, int age) {
        super(name, age, ANIMAL_GENDER);
    }

    public Tomcat(String name, int age, String gender) {
        super(name, age, ANIMAL_GENDER);
    }

    @Override
    public String produceSound() {
        return ANIMAL_SOUND;
    }
}
