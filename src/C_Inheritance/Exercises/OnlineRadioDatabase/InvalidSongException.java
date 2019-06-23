
//  Custom exception hierarchy
//
//      InvalidSongException
//      -> InvalidArtistNameException
//      -> InvalidSongNameException
//      -> InvalidSongLengthException
//          -> InvalidSongMinutesException
//          -> InvalidSongSecondsException

package C_Inheritance.Exercises.OnlineRadioDatabase;

class InvalidSongException extends Throwable {
    private String message;

    InvalidSongException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
