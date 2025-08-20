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
                    try {
                        String[] line = sc.nextLine().split("/by");
                        if (line.length < 2 || line[0].strip().isEmpty() || line[1].strip().isEmpty()) {
                            throw new DeadlineException("You know the format for deadline is like that right: deadline <task> /by <end>");
                        }
                        Task dlTask = new Deadline(line[0].stripTrailing(), line[1].stripLeading());
                        tl.addTask(dlTask);
                        System.out.println(new AddMessage(dlTask.toString()));
                    } catch (DukeException de) {
                        System.out.println(de.getMessage());
                    }
                    break;

                case "event":
                    try {
                        String[] eventLine = sc.nextLine().split("/from");
                        if (eventLine.length < 2) {
                            throw new EventException("You know event must have /from and /to right");
                        }
                        String[] times = eventLine[1].split("/to");
                        if (times.length < 2) {
                            throw new EventException("You know the format for event is like that right: event <task> /from <start> /to <end>");
                        }
                        Task eventTask = new Event(
                                eventLine[0].stripTrailing(),
                                times[0].stripLeading().stripTrailing(),
                                times[1].stripLeading()
                        );
                        tl.addTask(eventTask);
                        System.out.println(new AddMessage(eventTask.toString()));
                    } catch (DukeException de) {
                        System.out.println(de.getMessage());
                    }

                    break;

                case "todo":
                    try {
                        String lineTodo = sc.nextLine();
                        if (lineTodo.isEmpty()) {
                            throw new TodoException("todo what leh? Don't leave the task empty can or not?");
                        }
                        Task tdTask = new Todo(lineTodo);
                        tl.addTask(tdTask);
                        System.out.println(new AddMessage(tdTask.toString()));

                    } catch (DukeException de) {
                        System.out.println(de.getMessage());
                    }
                    break;

                default:
                    try {
                        throw new NoCommandException("Eh idk what you saying bro, use one of the commands");
                    } catch (DukeException de) {
                        System.out.println(de.getMessage());
                    }
                    break;
            }
        word = sc.next();
        }

        System.out.println(new Goodbye());
    }
}
