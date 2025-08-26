import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> items;
    private final Storage storage;

    public TaskList(Storage storage) {
        this.storage = storage;
        items = new ArrayList<>(this.storage.load());
    }

    public void addTask(Task task) {
        items.add(task);
        storage.save(this.items);
    }

    public Task getTask(int i) {
        return items.get(i - 1);
    }

    public Task deleteTask(int i) {
        Task deleted = items.remove(i - 1);
        storage.save(this.items);
        return deleted;
    }

    public void markAsDone(int i) {
        this.getTask(i).markAsDone();
        storage.save(this.items);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append("    ").append(i + 1).append(". ").append(items.get(i)).append("\n");
        }
        return sb.toString();
    }
}
