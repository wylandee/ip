package david.command;

import david.exception.DukeException;
import david.storage.Storage;
import david.task.TaskList;
import david.ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    public boolean isExit() {
        return false;
    }

    ;
}
