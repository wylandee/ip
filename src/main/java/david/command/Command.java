package david.command;

import david.exception.DavidException;
import david.storage.Storage;
import david.task.TaskList;

/**
 * Represents a command given by the user input
 */
public abstract class Command {
    /**
     * Executes logic of specific command
     * @param tasks List of Tasks.
     * @param storage User's data storage.
     * @throws DavidException If command input is invalid.
     */
    public abstract String execute(TaskList tasks, Storage storage) throws DavidException;

    /**
     * Makes sure chatbot does not stop.
     * @return False.
     */
    public boolean isExit() {
        return false;
    };
}
