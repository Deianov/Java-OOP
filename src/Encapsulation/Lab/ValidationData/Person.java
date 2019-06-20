package Encapsulation.Lab.ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {

        this.lastName = lastName;
    }

    private void setAge(Integer age) {

        this.age = age;
    }

    private void setSalary(Double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }


    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void increaseSalary(double bonus) {
        if (this.age > 30) {
            this.salary += (this.salary * bonus / 100);
        } else {
            this.salary += (this.salary * bonus / 200);
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " gets " + this.salary + " leva";
    }
}
