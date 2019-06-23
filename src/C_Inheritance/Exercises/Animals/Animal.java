package C_Inheritance.Exercises.Animals;

class Animal {
    protected static final String INPUT_ERROR_MESSAGE = "Invalid input!";
    private String name;
    private int age;
    protected String gender;

    Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        throwIfEmpty(name);
        this.name = name;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        throwIfEmpty(gender);
        this.gender = gender;
    }

    protected String produceSound() {
        return "Not implemented!";
    }

    protected void throwIfEmpty(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.gender;
    }
}
