package command;

public class DeadlineCommand extends Command {
    private String description;
    private String by;

    public DeadlineCommand(String args) throws DukeException {
        String[] parts = args.split("/by", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new DeadlineException("You know the format for deadline is like that right: deadline <task> /by <end>");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = new Deadline(description, by);
        tasks.addTask(task);
        ui.showMessage("    I add this task liao:\n    " + task);
        storage.save(tasks);
    }
}
