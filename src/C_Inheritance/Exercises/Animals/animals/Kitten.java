package C_Inheritance.Exercises.Animals.animals;

public class Kitten extends Cat {
    private static final String GENDER = "Female";
    private static final String ANIMAL_SOUND = "Meow";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return ANIMAL_SOUND;
    }
}
