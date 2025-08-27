package david.command;

import david.task.Task;
import david.task.Deadline;
import david.task.TaskList;
import david.ui.Ui;
import david.storage.Storage;
import david.exception.DukeException;
import david.exception.DeadlineException;

/**
 * Represents a command to create a Deadline task.
 */
public class DeadlineCommand extends Command {
    private String description;
    private String by;

    public DeadlineCommand(String args) throws DukeException {
        String[] parts = args.split("/by", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new DeadlineException("You know the format for deadline is like that right: deadline <task> /by <end>");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    /**
     * Creates a Deadline task and adds it into the user's TaskList.
     * @param tasks List of Tasks.
     * @param ui User interface of chatbot.
     * @param storage User's data storage.
     * @throws DukeException If the user's input does not follow the deadline format: deadline <task> /by <end>.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = new Deadline(description, by);
        tasks.addTask(task);
        ui.showMessage("    I add this task liao:\n    " + task);
        storage.save(tasks);
    }
}
