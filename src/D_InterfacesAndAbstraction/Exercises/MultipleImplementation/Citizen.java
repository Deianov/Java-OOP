package D_InterfacesAndAbstraction.Exercises.MultipleImplementation;

public class Citizen implements Person, Identifiable, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }



    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s", this.name, this.age, this.id, this.birthDate);
    }
}
