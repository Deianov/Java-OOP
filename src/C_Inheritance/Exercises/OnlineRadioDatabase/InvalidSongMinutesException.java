package C_Inheritance.Exercises.OnlineRadioDatabase;

class InvalidSongMinutesException extends InvalidSongLengthException {
    InvalidSongMinutesException(String message) {
        super(message);
    }
}
