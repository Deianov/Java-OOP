package A_WorkingWithAbstraction.Lab.StudentSystem;

class Student {
    private String name;
    private int age;
    private double grade;

    Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return this.age;
    }

    void setAge(int age) {
        this.age = age;
    }

    double getGrade() {
        return this.grade;
    }

    void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s is %s years old. %s",
                this.name,
                this.age,
                this.grade >= 5.0 ? "Excellent student." : this.grade < 5.0 && this.grade >= 3.5 ? "Average student." : "Very nice person.");
    }
}
