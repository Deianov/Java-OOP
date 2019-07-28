package H_ExceptionsAndErrorHandling.Person;

public class Main {
    public static void main(String[] args) {

        try {
            Person person = new Person(" ", " ", 20);

        } catch (IllegalArgumentException ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        try {
            Student student = new Student("4havdar", "chocho@gmail.com");

        } catch (InvalidPersonNameException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
