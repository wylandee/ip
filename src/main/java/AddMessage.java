public class AddMessage extends Message {

    public AddMessage (String text) {
        super("added: " + text);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
