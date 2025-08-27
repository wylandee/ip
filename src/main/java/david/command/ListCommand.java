package david.command;

import david.storage.Storage;
import david.task.TaskList;
import david.ui.Ui;

/**
 * Represents a command to show TaskList.
 */
public class ListCommand extends Command {
    /**
     * Gets Ui to show TaskList.
     * @param tasks List of Tasks.
     * @param ui User interface of chatbot.
     * @param storage User's data storage.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage(tasks.toString());
    }
}
