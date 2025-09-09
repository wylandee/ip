package david.exception;

/**
 * Initialise an Exception that will be thrown from Event Tasks.
 */
public class EventException extends DavidException {
    public EventException(String message) {
        super(message);
    }
}
