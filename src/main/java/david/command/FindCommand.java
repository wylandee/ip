package david.command;

import david.exception.FindException;

import david.exception.DukeException;
import david.storage.Storage;
import david.task.TaskList;
import david.ui.Ui;

public class FindCommand extends Command {
    String keyword;

    public FindCommand(String args) throws DukeException {
        if (args.trim().isEmpty()) {
            throw new FindException("Find what leh? Don't leave the keyword empty can or not?");
        }
        this.keyword = args.trim();
    }

    @Override
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        TaskList tl = tasks.findTasks(keyword);
        if (tl.size() == 0) {
            //ui.showMessage("    Bro you sure you search the write word? No results leh.");
            return "    Bro you sure you search the write word? No results leh.";
        } else {
            //ui.showMessage("    Eh here is your matching tasks ok, I took very long to find:\n" + tl);
            return "    Eh here is your matching tasks ok, I took very long to find:\n" + tl;
        }
    }
}
