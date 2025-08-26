public class Task {
    private String text;
    private boolean isDone;
    public Task(String text) {
        this.text = text;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), text);
    }
}
