package C_Inheritance.Exercises.OnlineRadioDatabase;

class InvalidSongSecondsException extends InvalidSongLengthException {
    InvalidSongSecondsException(String message) {
        super(message);
    }
}
