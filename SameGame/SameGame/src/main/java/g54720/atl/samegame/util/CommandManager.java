package g54720.atl.samegame.util;

import java.util.Stack;

/**
 * Manage all command with a list of all the commands made.
 *
 * @author g54720
 */
public class CommandManager {

    private final Stack<Command> undoStack = new Stack();
    private final Stack<Command> redoStack = new Stack();

    /**
     * Execute a command and add it to the list of command made.
     *
     * @param command a command to do.
     */
    public void execute(Command command) {
        if (command != null) {
            command.execute();
            undoStack.push(command);
            redoStack.clear();
        }
    }

    /**
     * Cancel the last command do.
     *
     */
    public void undo() {
        if (!undoStack.empty()) {
            Command command = undoStack.pop();
            command.unexecute();
            redoStack.push(command);
        }
    }

    /**
     * Re-execute a cancel command.
     */
    public void redo() {
        if (!redoStack.empty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}


