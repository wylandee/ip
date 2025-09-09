package david.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Task with a deadline
 */
public class Deadline extends Task {
    private LocalDateTime by;

    public Deadline(String text, String by) {
        super(text);
        assert by != null : "By should never be null";
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        this.by = LocalDateTime.parse(by, inputFormat);
    }

    public LocalDateTime getBy() {
        return this.by;
    }

    @Override
    public String toString() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM d yyyy, h:mma");
        return "[D]" + super.toString() + " (by: " + this.by.format(outputFormat) + ")";
    }
}
