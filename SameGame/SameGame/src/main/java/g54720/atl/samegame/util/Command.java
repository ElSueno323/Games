package g54720.atl.samegame.util;

/**
 * Is the interface of all command.
 *
 * @author g54720
 */
public interface Command {

    /**
     * Execute the actual command.
     */
    public void execute();

    /**
     * Cancel the actual command.
     */
    public void unexecute();

}
