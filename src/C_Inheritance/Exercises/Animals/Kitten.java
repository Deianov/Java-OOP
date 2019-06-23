package C_Inheritance.Exercises.Animals;

class Kitten extends Cat {

    Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        throwIfEmpty(gender);
        if (!gender.equals("Female")) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        super.gender = gender;
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
