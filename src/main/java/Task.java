public class Task {
    String text;
    boolean isDone;
    public Task(String text) {
        this.text = text;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), text);
    }
}
