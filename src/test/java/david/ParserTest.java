package david.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import david.command.Command;
import david.command.DeadlineCommand;
import david.command.TodoCommand;
import david.exception.DukeException;

class ParserTest {

    @Test
    void parse_validTodoCommand_returnsTodoCommand() throws DukeException {
        Command c = Parser.parse("todo read book");
        assertTrue(c instanceof TodoCommand, "Expected a TodoCommand");
    }

    @Test
    void parse_invalidCommand_throwsException() {
        assertThrows(DukeException.class, () -> Parser.parse("blah blah blah"));
    }

    @Test
    void parse_deadlineWithDate_returnsDeadlineCommand() throws DukeException {
        Command c = Parser.parse("deadline return book /by 2019-12-02 2359");
        assertTrue(c instanceof DeadlineCommand, "Expected a DeadlineCommand");
    }
}
