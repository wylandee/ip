import java.util.Scanner;

public class David {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(new Greeting());
        String word = sc.nextLine();
        while (!word.equals("bye")) {
            System.out.println(new Message(word));
            word = sc.nextLine();
        }

        System.out.println(new Goodbye());
    }
}
