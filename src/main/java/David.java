import java.util.Scanner;

public class David {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList tl = new TaskList();

        System.out.println(new Greeting());
        String word = sc.next();
        while (!word.equals("bye")) {
            if (word.equals("list")) {
                System.out.println(new ListMessage(tl));
            } else if (word.equals("mark")) {
                int i = sc.nextInt();
                Task curr = tl.getTask(i);
                curr.markAsDone();
                System.out.println(new MarkMessage(curr.toString()));
            } else if (word.equals("deadline")) {
                String[] line = sc.nextLine().split("/by");
                tl.addTask(new Deadline(line[0].stripTrailing(), line[1].stripLeading()));
                System.out.println(new AddMessage(line[0].stripTrailing()));
            } else if (word.equals("event")) {
                String[] line = sc.nextLine().split("/from");
                String[] times = line[1].split("/to");
                tl.addTask(new Event(line[0].stripTrailing(), times[0].stripLeading().stripTrailing(), times[1].stripLeading()));
                System.out.println(new AddMessage(line[0].stripTrailing()));
            } else if (word.equals("todo")){
                String line = sc.nextLine();
                tl.addTask(new Todo(line));
                System.out.println(new AddMessage(line));
            }
        word = sc.next();
        }

        System.out.println(new Goodbye());
    }
}
