package H_ExceptionsAndErrorHandling.Person;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.isBlank()) {
            throw new InvalidPersonNameException("Student name is blank!");
        }

        for (char c : name.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                throw new InvalidPersonNameException("Are not allowed any special character or numeric value in a name");
            }
        }
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    private void setEmail(String email) {
        // TODO: 28.07.2019
        this.email = email;
    }
}
