package david.task;

import java.util.ArrayList;

/**
 * Represents a list of Tasks.
 */
import david.storage.Storage;

public class TaskList {
    private ArrayList<Task> items;
    private Storage storage;

    /**
     * Initialise a TaskList from a storage object.
     * @param storage Storage
     */
    public TaskList(Storage storage) {
        this.storage = storage;
        this.items = new ArrayList<>(this.storage.load());
    }

    /**
     * Initialise an empty TaskList
     */
    public TaskList() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a Task into the list.
     * @param task Task
     */
    public void addTask(Task task) {
        this.items.add(task);
    }

    public Task getTask(int i) {
        return this.items.get(i - 1);
    }

    public ArrayList<Task> getTasks() {
        return this.items;
    }

    /**
     * Returns the number of Tasks in the list.
     * @return Number of Tasks in list.
     */
    public int size() {
        return this.getTasks().size();
    }

    /**
     * Deletes the Task at index i - 1, returns the deleted Task.
     * @param i index of Task
     * @return deleted Task.
     */
    public Task deleteTask(int i) {
        Task deleted = this.items.remove(i - 1);
        return deleted;
    }

    /**
     * Mark Task in list as done.
     * @param i index of Task
     */
    public void markAsDone(int i) {
        this.getTask(i).markAsDone();
    }

    /**
     * Find Tasks that match the given keyword.
     * @param keyword Keyword
     * @return A TaskList containing matching Tasks.
     */
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
