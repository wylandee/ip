public class ListMessage extends Message {
    public ListMessage(TaskList tl) {
        super("Wah these are the tasks in your list:\n    " + tl.toString());
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
