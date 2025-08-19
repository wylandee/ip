import java.util.Scanner;

public class David {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList tl = new TaskList();

        System.out.println(new Greeting());
        String word = sc.nextLine();
        while (!word.equals("bye")) {
            if (word.equals("list")) {
                System.out.println(new ListMessage(tl));
            } else {
                System.out.println(new AddMessage(word));
                tl.addTask(new Task(word));
            }
            word = sc.nextLine();
        }

        System.out.println(new Goodbye());
    }
}
