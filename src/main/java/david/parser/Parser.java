package david.parser;

import david.command.*;
import david.exception.DukeException;
import david.exception.NoCommandException;

/**
 * Processes the command string and decides which command to execute.
 */
public class Parser {
    /**
     * Processes the command string and decides which command to execute.
     * @param fullCommand Command string.
     * @return Command.
     * @throws DukeException If command does not exist in the given list of commands.
     */
    public static Command parse(String fullCommand) throws DukeException {
        String[] parts = fullCommand.split(" ", 2);
        String commandWord = parts[0];

        switch (commandWord) {
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(parts[1]);
            case "deadline":
                return new DeadlineCommand(parts[1]);
            case "event":
                return new EventCommand(parts[1]);
            case "todo":
                return new TodoCommand(parts[1]);
            case "delete":
                return new DeleteCommand(parts[1]);
            case "bye":
                return new ExitCommand();
            default:
                throw new NoCommandException("Eh idk what you saying bro, use one of the commands");
        }
    }
}
