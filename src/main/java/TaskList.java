import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> items;

    public TaskList() {
        items = new ArrayList<>();
    }

    public void addTask(Task task) {
        items.add(task);
    }

    public Task getTask(int i) {
        return items.get(i - 1);
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
