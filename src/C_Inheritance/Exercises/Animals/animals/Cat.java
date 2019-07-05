package C_Inheritance.Exercises.Animals.animals;

public class Cat extends Animal {
    private static final String ANIMAL_SOUND = "Meow meow";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return ANIMAL_SOUND;
    }
}
