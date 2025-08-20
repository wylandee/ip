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
            } else {
                System.out.println(new AddMessage(word));
                tl.addTask(new Task(word));
            }
        word = sc.next();
        }

        System.out.println(new Goodbye());
    }
}
