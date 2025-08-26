package parser;

import command.*;
import exception.DukeException;
import exception.NoCommandException;

public class Parser {
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
