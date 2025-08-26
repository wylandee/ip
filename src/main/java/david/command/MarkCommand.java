package david.command;

import david.task.Task;
import david.task.TaskList;
import david.ui.Ui;
import david.storage.Storage;
import david.exception.DukeException;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(String args) throws DukeException {
        try {
            this.index = Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            throw new DukeException("Eh give an index number after mark leh");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = tasks.getTask(index);
        tasks.markAsDone(index);
        ui.showMessage("    Ok I mark as done liao:\n    " + task);
        storage.save(tasks);
    }
}
