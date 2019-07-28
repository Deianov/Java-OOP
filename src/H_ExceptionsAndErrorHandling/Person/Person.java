package H_ExceptionsAndErrorHandling.Person;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName.isBlank()) {
            throw new IllegalArgumentException("The first name cannot be null ot empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        if (lastName.isBlank()) {
            throw new IllegalArgumentException("The last name cannot be null ot empty");
        }
        return this.lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age should be in the range [0 ... 120]");
        }
        this.age = age;
    }
}
