package C_Inheritance.Exercises.Animals.animals;

public abstract class Animal {
    private static final String INPUT_ERROR_MESSAGE = "Invalid input!";
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public abstract String produceSound();

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s"
                ,this.getClass().getSimpleName()
                ,this.getName()
                ,this.getAge()
                ,this.getGender()
                ,this.produceSound()
        );
    }
}
