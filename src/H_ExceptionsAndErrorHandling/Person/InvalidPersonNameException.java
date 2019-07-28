package H_ExceptionsAndErrorHandling.Person;

public class InvalidPersonNameException extends IllegalArgumentException {

    public InvalidPersonNameException(String s) {
        super(s);
    }

    public InvalidPersonNameException() {
        this("Invalid Person Name");
    }
}
