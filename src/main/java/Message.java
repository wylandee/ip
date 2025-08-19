public class Message {
    String horizontalLine = "----------------------------------";
    String text;

    public Message(String text){
        this.text = text;
    }

    public String toString() {
        return String.format("%s\n%s\n%s\n", horizontalLine, text, horizontalLine);
    }
}
