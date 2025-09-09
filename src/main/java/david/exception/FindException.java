package david.exception;

/**
 * Initialise an Exception that will be thrown from the find function.
 */
public class FindException extends DavidException {
    public FindException(String message) {
        super(message);
    }
}
