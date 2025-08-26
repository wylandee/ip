package david.command;

import david.task.TaskList;
import david.ui.Ui;
import david.storage.Storage;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage(tasks.toString());
    }
}
