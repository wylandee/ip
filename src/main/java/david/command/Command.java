package david.command;

import david.task.TaskList;
import david.ui.Ui;
import david.storage.Storage;
import david.exception.DukeException;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
    public boolean isExit() {
        return false;
    };
}
