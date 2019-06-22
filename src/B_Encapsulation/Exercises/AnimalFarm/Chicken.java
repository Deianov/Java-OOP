package B_Encapsulation.Exercises.AnimalFarm;

import java.text.DecimalFormat;

class Chicken {
    private String name;
    private int age;

    private void setName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private String getName() { return this.name; }
    private int getAge() { return this.age; }

    Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private double calculateProductPerDay() {
        return (this.getAge() <= 5) ? 2 : (this.getAge() <= 11) ? 1 : 0.75;
    }

    double productPerDay () {
        return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.####");

        return String.format(
                "Chicken %s (age %d) can produce %s eggs per day.",
                this.getName(),
                this.getAge(),
                decimalFormat.format(this.calculateProductPerDay())
        );
    }
}
