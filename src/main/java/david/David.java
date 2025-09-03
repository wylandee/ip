package david;

import david.storage.Storage;
import david.task.TaskList;

/**
 * Entrypoint class for David chatbot.
 */
public class David {
    private Storage storage;
    private TaskList tasks;

    public David(String filePath) {
        storage = new Storage(filePath);
        tasks = new TaskList(storage);
    }

    public Storage getStorage() {
        return this.storage;
    }

    public TaskList getTaskList() {
        return this.tasks;
    }
}
