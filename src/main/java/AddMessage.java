public class AddMessage extends Message {

    public AddMessage (String text) {
        super("I add this task liao:\n    " + text);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
