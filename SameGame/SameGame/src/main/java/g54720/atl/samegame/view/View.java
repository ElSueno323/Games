package g54720.atl.samegame.view;

/**
 *
 * @author g54720
 */
public interface View {

    /**
     * Print the main menu for the game with start the game or configuration
     */
    void startMenu();

    /**
     * Go to the menu who change the length of the board.
     */
    void configuration();

    /**
     * Print the map of the Same game.
     */
    void viewMap();

    /**
     * Ask the command to the player.
     */
    void askCommand();

    /**
     * The screen whent the game as win.
     */
    void winScreen();

    /**
     * The screen when the game as blocked.
     */
    void blockedScreen();

}




