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
                    Task dlTask = new Deadline(line[0].stripTrailing(), line[1].stripLeading());
                    tl.addTask(dlTask);
                    System.out.println(new AddMessage(dlTask.toString()));
                    break;

                case "event":
                    String[] eventLine = sc.nextLine().split("/from");
                    String[] times = eventLine[1].split("/to");
                    Task eventTask = new Event(
                            eventLine[0].stripTrailing(),
                            times[0].stripLeading().stripTrailing(),
                            times[1].stripLeading()
                    );
                    tl.addTask(eventTask);
                    System.out.println(new AddMessage(eventTask.toString()));
                    break;

                case "todo":
                    String lineTodo = sc.nextLine();
                    Task tdTask = new Todo(lineTodo);
                    tl.addTask(tdTask);
                    System.out.println(new AddMessage(tdTask.toString()));
                    break;

            }
        word = sc.next();
        }

        System.out.println(new Goodbye());
    }
}
