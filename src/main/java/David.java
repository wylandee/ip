import java.util.Scanner;

public class David {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList tl = new TaskList();

        System.out.println(new Greeting());
        String word = sc.next();
        while (!word.equals("bye")) {
            switch (word) {
                case "list":
                    System.out.println(new ListMessage(tl));
                    break;

                case "mark":
                    int i = sc.nextInt();
                    Task curr = tl.getTask(i);
                    curr.markAsDone();
                    System.out.println(new MarkMessage(curr.toString()));
                    break;

                case "deadline":
                    String[] line = sc.nextLine().split("/by");
                    tl.addTask(new Deadline(line[0].stripTrailing(), line[1].stripLeading()));
                    System.out.println(new AddMessage(line[0].stripTrailing()));
                    break;

                case "event":
                    String[] eventLine = sc.nextLine().split("/from");
                    String[] times = eventLine[1].split("/to");
                    tl.addTask(new Event(
                            eventLine[0].stripTrailing(),
                            times[0].stripLeading().stripTrailing(),
                            times[1].stripLeading()
                    ));
                    System.out.println(new AddMessage(eventLine[0].stripTrailing()));
                    break;

                case "todo":
                    String lineTodo = sc.nextLine();
                    tl.addTask(new Todo(lineTodo));
                    System.out.println(new AddMessage(lineTodo));
                    break;

            }
        word = sc.next();
        }

        System.out.println(new Goodbye());
    }
}
