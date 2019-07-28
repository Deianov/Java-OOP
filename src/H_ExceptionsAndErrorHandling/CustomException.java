package H_ExceptionsAndErrorHandling;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }

    public CustomException() {
        this("My default message.");
    }
}
