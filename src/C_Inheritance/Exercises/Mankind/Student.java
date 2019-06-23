package C_Inheritance.Exercises.Mankind;

class Student extends Human {
    private String facultyNumber;

    Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if(facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return String.format("%sFaculty number: %s", super.toString(), this.facultyNumber);
    }
}
