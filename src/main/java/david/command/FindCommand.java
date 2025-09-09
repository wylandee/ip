package david.command;

import david.exception.FindException;

import david.exception.DavidException;
import david.storage.Storage;
import david.task.TaskList;

public class FindCommand extends Command {
    String keyword;

    public FindCommand(String args) throws DavidException {
        if (args.trim().isEmpty()) {
            throw new FindException("Find what leh? Don't leave the keyword empty can or not?");
        }
        this.keyword = args.trim();
        assert keyword != null && !keyword.isEmpty() : "Keyword should not be null or empty";
    }

    @Override
    public String execute(TaskList tasks, Storage storage) throws DavidException {
        TaskList tl = tasks.findTasks(keyword);
        if (tl.size() == 0) {
            return "    Bro you sure you search the write word? No results leh.";
        } else {
            return "    Eh here is your matching tasks ok, I took very long to find:\n" + tl;
        }
    }
}
