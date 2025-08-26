package david.command;

import david.task.Task;
import david.task.Todo;
import david.task.TaskList;
import david.ui.Ui;
import david.storage.Storage;
import david.exception.DukeException;
import david.exception.TodoException;

public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String args) throws DukeException {
        if (args.trim().isEmpty()) {
            throw new TodoException("todo what leh? Don't leave the david.task empty can or not?");
        }
        this.description = args.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = new Todo(description);
        tasks.addTask(task);
        ui.showMessage("    I add this david.task liao:\n    " + task);
        storage.save(tasks);
    }
}
