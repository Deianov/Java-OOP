package Encapsulation.Lab.SalaryIncrease;

class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    void increaseSalary(double bonus) {
        if (this.age > 30) {
            this.salary += (this.salary * bonus / 100);
        } else {
            this.salary += (this.salary * bonus / 200);
        }
    }

    String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    Integer getAge() {
        return age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " gets " + this.salary + " leva";
    }
}
