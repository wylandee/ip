public class MarkMessage extends Message {

    public MarkMessage(String text) {
        super("I have marked this task as done\n" + text);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
