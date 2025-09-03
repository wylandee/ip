package david.command;

import david.exception.DavidException;
import david.storage.Storage;
import david.task.Task;
import david.task.TaskList;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(String args) throws DavidException {
        try {
            this.index = Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            throw new DavidException("Eh give an index number after delete leh");
        }
    }

    /**
     * Deletes the Task at the given in the user's TaskList.
     * @param tasks List of Tasks.
     * @param storage User's data storage.
     * @throws DavidException If the user does not provide an index after delete.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) throws DavidException {
        Task task = tasks.deleteTask(index);
        storage.save(tasks);
        return "Ok I this task kenna remove liao:\n" + task;
    }
}
