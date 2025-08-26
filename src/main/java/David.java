import java.util.Scanner;

public class David {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public David(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage);
    }

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

    public static void main(String[] args) {
        new David("data/tasks.txt").run();
    }
}
