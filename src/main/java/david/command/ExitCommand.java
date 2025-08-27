package david.command;

import david.storage.Storage;
import david.task.TaskList;
import david.ui.Ui;

/**
 * Represents a command to exit the chatbot.
 */
public class ExitCommand extends Command {
    /**
     * Gets Ui to show goodbye message.
     * @param tasks List of Tasks.
     * @param ui User interface of chatbot.
     * @param storage User's data storage.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }

    /**
     * Makes chatbot end.
     * @return True
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
