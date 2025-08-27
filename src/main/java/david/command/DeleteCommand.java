package david.command;

import david.exception.DukeException;
import david.storage.Storage;
import david.task.Task;
import david.task.TaskList;
import david.ui.Ui;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(String args) throws DukeException {
        try {
            this.index = Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            throw new DukeException("Eh give an index number after delete leh");
        }
    }

    /**
     * Deletes the Task at the given in the user's TaskList.
     * @param tasks List of Tasks.
     * @param ui User interface of chatbot.
     * @param storage User's data storage.
     * @throws DukeException If the user does not provide an index after delete.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = tasks.deleteTask(index);
        ui.showMessage("Ok I this task kenna remove liao:\n" + task);
        storage.save(tasks);
    }
}
