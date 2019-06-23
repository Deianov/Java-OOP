package C_Inheritance.Exercises.Animals;

class Tomcat extends Cat {

    Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        throwIfEmpty(gender);
        if(!gender.equals("Male")) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        super.gender = gender;
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
