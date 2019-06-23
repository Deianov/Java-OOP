package C_Inheritance.Exercises.Mankind;

class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if(lastName.length() < 4) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(super.toString())
                .append("Week Salary: ").append(String.format("%.2f", this.weekSalary))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.workHoursPerDay))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", this.weekSalary / (this.workHoursPerDay * 7)));

        return stringBuilder.toString();
    }
}
