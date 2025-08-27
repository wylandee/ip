package david.parser;

import david.command.*;
import david.exception.DukeException;
import david.exception.FindException;
import david.exception.NoCommandException;

public class Parser {
    public static Command parse(String fullCommand) throws DukeException {
        String[] parts = fullCommand.split(" ", 2);
        String commandWord = parts[0];
        String args;

        switch (commandWord) {
            case "list":
                return new ListCommand();
            case "mark":
                args = (parts.length < 2 ? "" : parts[1]);
                return new MarkCommand(args);
            case "deadline":
                args = (parts.length < 2 ? "" : parts[1]);
                return new DeadlineCommand(args);
            case "event":
                args = (parts.length < 2 ? "" : parts[1]);
                return new EventCommand(args);
            case "todo":
                args = (parts.length < 2 ? "" : parts[1]);
                return new TodoCommand(args);
            case "delete":
                args = (parts.length < 2 ? "" : parts[1]);
                return new DeleteCommand(args);
            case "find":
                args = (parts.length < 2 ? "" : parts[1]);
                return new FindCommand(args);
            case "bye":
                return new ExitCommand();
            default:
                throw new NoCommandException("Eh idk what you saying bro, use one of the commands");
        }
    }
}
