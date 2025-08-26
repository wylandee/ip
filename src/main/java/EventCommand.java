public class EventCommand extends Command {
    private String description;
    private String from;
    private String to;

    public EventCommand(String args) throws DukeException {
        String[] parts = args.split("/from", 2);
        if (parts.length < 2) {
            throw new EventException("You know event must have /from and /to right");
        }

        String[] times = parts[1].split("/to", 2);
        if (times.length < 2) {
            throw new EventException("You know the format for event is like that right: event <task> /from <start> /to <end>");
        }

        this.description = parts[0].trim();
        this.from = times[0].trim();
        this.to = times[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = new Event(description, from, to);
        tasks.addTask(task);
        ui.showMessage("    I add this task liao:\n    " + task);
        storage.save(tasks);
    }
}
