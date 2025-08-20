public class Message {
    private final String horizontalLine = "----------------------------------";
    private String text;

    public Message(String text){
        this.text = text;
    }

    public String toString() {
        return String.format("    %s\n    %s\n    %s\n", horizontalLine, text, horizontalLine);
    }
}
