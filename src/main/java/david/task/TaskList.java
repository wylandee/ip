package david.task;

import david.storage.Storage;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> items;
    private Storage storage;

    public TaskList(Storage storage) {
        this.storage = storage;
        items = new ArrayList<>(this.storage.load());
    }

    public TaskList() {
        items = new ArrayList<>();
    }

    public void addTask(Task task) {
        items.add(task);
    }

    public Task getTask(int i) {
        return items.get(i - 1);
    }

    public ArrayList<Task> getTasks() {
        return items;
    }

    public int size() {
        return this.getTasks().size();
    }

    public Task deleteTask(int i) {
        Task deleted = items.remove(i - 1);
        return deleted;
    }

    public void markAsDone(int i) {
        this.getTask(i).markAsDone();
    }

    public TaskList findTasks(String keyword) {
        TaskList temp = new TaskList();

        for (Task t : this.items) {
            String[] words = t.getText().split(" ");
            for (String word : words) {
                if (word.equals(keyword)) {
                    temp.addTask(t);
                    break;
                }
            }
        }
        return temp;
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
