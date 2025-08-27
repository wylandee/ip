package david.command;

import david.exception.DukeException;
import david.storage.Storage;
import david.task.Task;
import david.task.TaskList;
import david.ui.Ui;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(String args) throws DukeException {
        try {
            this.index = Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            throw new DukeException("Eh give an index number after delete leh");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = tasks.deleteTask(index);
        ui.showMessage("Ok I this task kenna remove liao:\n" + task);
        storage.save(tasks);
    }
}
