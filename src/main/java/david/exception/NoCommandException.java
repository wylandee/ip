package david.exception;

/**
 * Initialise an Exception that will be thrown from invalid commands.
 */
public class NoCommandException extends DavidException {
    public NoCommandException(String message) {
        super(message);
    }
}
