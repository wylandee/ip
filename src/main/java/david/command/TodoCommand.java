package david.command;

import david.exception.DavidException;
import david.exception.TodoException;
import david.storage.Storage;
import david.task.Task;
import david.task.TaskList;
import david.task.Todo;

/**
 * Represents a command to create a Todo task.
 */
public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String args) throws DavidException {
        if (args.trim().isEmpty()) {
            throw new TodoException("todo what leh? Don't leave the task empty can or not?");
        }
        this.description = args.trim();
    }

    /**
     * Creates a Todo task and adds it into the user's TaskList.
     * @param tasks List of Tasks.
     * @param ui User interface of chatbot.
     * @param storage User's data storage.
     * @throws DavidException If user does not provide task description.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) throws DavidException {
        Task task = new Todo(description);
        tasks.addTask(task);
        //ui.showMessage("    I add this task liao:\n    " + task);
        storage.save(tasks);
        return "    I add this task liao:\n    " + task;
    }
}
