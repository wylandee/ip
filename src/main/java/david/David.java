package david;

import david.command.Command;
import david.exception.DukeException;
import david.parser.Parser;
import david.storage.Storage;
import david.task.TaskList;
import david.ui.Ui;

/**
 * Entrypoint class for David chatbot.
 */
public class David {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public David(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage);
    }

    /**
     * Starts up chatbot.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                ui.showLine();
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public String getResponse(String input) {
        return "David heard: " + input;
    }

    public static void main(String[] args) {
        new David("data/tasks.txt").run();
    }
}
