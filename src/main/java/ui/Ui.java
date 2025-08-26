package ui;

import java.util.Scanner;

public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showWelcome() {
        System.out.println("    ----------------------------------");
        System.out.println("    Eh David here\n    What you want me do for you?");
        System.out.println("    ----------------------------------");
    }

    public void showGoodbye() {
        System.out.println("    I zao liao ah. See you again soon!");
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showLine() {
        System.out.println("    ----------------------------------");
    }
}