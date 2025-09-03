package david.command;

import david.storage.Storage;
import david.task.TaskList;

/**
 * Represents a command to show TaskList.
 */
public class ListCommand extends Command {
    /**
     * Gets Ui to show TaskList.
     * @param tasks List of Tasks.
     * @param storage User's data storage.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        return tasks.toString();
    }
}
