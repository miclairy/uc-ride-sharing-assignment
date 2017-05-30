package model;

/**
 * Created by clbmi on 31/05/2017.
 */
public class InvalidDataException extends Exception {
    public InvalidDataException () {

    }

    public InvalidDataException (String message) {
        super (message);
    }

    public InvalidDataException (Throwable cause) {
        super (cause);
    }

    public InvalidDataException (String message, Throwable cause) {
        super (message, cause);
    }
}
