package C_Inheritance.Exercises.Animals;

class Frog extends Animal {

    Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }
}
