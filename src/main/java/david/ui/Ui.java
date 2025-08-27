package david.ui;

import java.util.Scanner;

/**
 * Represents the user interface for the reading of user inputs and printing of bot outputs.
 */
public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Reads user input.
     * @return User input as a string.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Prints greeting line
     */
    public void showWelcome() {
        System.out.println("    ----------------------------------");
        System.out.println("    Eh David here\n    What you want me do for you?");
        System.out.println("    ----------------------------------");
    }

    /**
     * Prints goodbye line.
     */
    public void showGoodbye() {
        System.out.println("    I zao liao ah. See you again soon!");
    }

    /**
     * Prints error message when there is an exception.
     * @param message Error message.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Prints response message for the given command.
     * @param message Response message for a command.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints the horizontal line which show bot responses.
     */
    public void showLine() {
        System.out.println("    ----------------------------------");
    }
}