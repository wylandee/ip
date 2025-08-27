package david.command;

import david.task.Task;
import david.task.TaskList;
import david.ui.Ui;
import david.storage.Storage;
import david.exception.DukeException;

/**
 * Represents a command to mark a task as done.
 */
public class MarkCommand extends Command {
    private int index;

    public MarkCommand(String args) throws DukeException {
        try {
            this.index = Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            throw new DukeException("Eh give an index number after mark leh");
        }
    }

    /**
     * Marks the task at given index in the user's TaskList as done.
     * @param tasks List of Tasks.
     * @param ui User interface of chatbot.
     * @param storage User's data storage.
     * @throws DukeException If the user does not provide an index after mark.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = tasks.getTask(index);
        tasks.markAsDone(index);
        ui.showMessage("    Ok I mark as done liao:\n    " + task);
        storage.save(tasks);
    }
}
