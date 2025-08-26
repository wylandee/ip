public class Deadline extends Task {
    private String by;

    public Deadline(String text, String by) {
        super(text);
        this.by = by;
    }

    public String getBy() {
        return this.by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
