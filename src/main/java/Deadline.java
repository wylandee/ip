public class Deadline extends Task {
    private String by;

    public Deadline(String text, String by) {
        super(text);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
