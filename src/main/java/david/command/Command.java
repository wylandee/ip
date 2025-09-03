package david.command;

import david.exception.DukeException;
import david.storage.Storage;
import david.task.TaskList;
import david.ui.Ui;

/**
 * Represents a command given by the user input
 */
public abstract class Command {
    /**
     * Executes logic of specific command
     * @param tasks List of Tasks.
     * @param ui User interface of chatbot.
     * @param storage User's data storage.
     * @throws DukeException If command input is invalid.
     */
    public abstract String execute(TaskList tasks, Storage storage) throws DukeException;

    /**
     * Makes sure chatbot does not stop.
     * @return False.
     */
    public boolean isExit() {
        return false;
    };
}
