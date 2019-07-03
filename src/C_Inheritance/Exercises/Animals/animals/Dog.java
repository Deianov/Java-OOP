package C_Inheritance.Exercises.Animals.animals;

public class Dog extends Animal {
    private static final String ANIMAL_SOUND = "Woof!";

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return ANIMAL_SOUND;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n%s %d %s",
                super.getName(),
                super.getAge(),
                super.getGender());
    }
}
