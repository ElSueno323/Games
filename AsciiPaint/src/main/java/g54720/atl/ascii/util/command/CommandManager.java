package g54720.atl.ascii.util.command;

import java.util.Stack;

/**
 * Manage all command with a list of all the commands made.
 *
 * @author g54720
 */
public class CommandManager {

    private Stack<Command> undoStack = new Stack();
    private Stack<Command> redoStack = new Stack();

    /**
     * Exectue a command and add it to the list of command made.
     *
     * @throws NullPointerException when the command in parameter as null.
     * @param command a command to do.
     */
    public void execute(Command command) {
        if (command == null) {
            throw new NullPointerException("plus de commande");
        }
        command.execute();
        undoStack.add(command);
        redoStack.clear();
    }

    /**
     * Cancel the last command do.
     *
     * @throws Error when the list of command as empty.
     */
    public void undo() {
        if (!undoStack.empty()) {
            Command command = undoStack.pop();
            command.unexecute();
            redoStack.push(command);
        }
    }

    /**
     * Re-execute a cancel command
     */
    public void redo() {
        Command command =redoStack.pop();
        command.execute();
        undoStack.add(command);
    }
}
