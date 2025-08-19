import java.util.Arrays;

public class TaskList {
    Task[] items;

    public TaskList() {
        items = new Task[100];
    }

    public void addTask(Task task) {
        for (int i = 0; i < 100; i++) {
            if (items[i] == null) {
                items[i] = task;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            if (items[i] == null) {
                break;
            }
            sb.append(i + 1).append(". ").append(items[i]).append("\n    wha");
        }
        return sb.toString();
    }
}
