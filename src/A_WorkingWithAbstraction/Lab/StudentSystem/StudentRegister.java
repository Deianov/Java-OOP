package A_WorkingWithAbstraction.Lab.StudentSystem;

import java.util.HashMap;

class StudentRegister {
    private static HashMap<String, Student> students = new HashMap<>();

    static Student addStudent(String name, int age, double grade) {

        Student student = new Student(name, age, grade);

        StudentRegister.students.putIfAbsent(name, student);

        return student;
    }

    static void showStudent(String name) {

        Student student = StudentRegister.students.get(name);

        if (student != null) {
            System.out.println(student.toString());
        }
    }
}
