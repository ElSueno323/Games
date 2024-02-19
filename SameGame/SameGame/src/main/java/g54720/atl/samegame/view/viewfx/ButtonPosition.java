package g54720.atl.samegame.view.viewfx;

import javafx.scene.control.Button;

/**
 * Create a button with a position.
 *
 * @author g54720
 */
public class ButtonPosition extends Button {

    private final int x;
    private final int y;

    /**
     * Constructor of button with the position.
     *
     * @param x a integer, abscissa .
     * @param y a integer, ordinate.
     */
    public ButtonPosition(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    /**
     * Get the attributes x.
     *
     * @return a integer.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the attributes y.
     *
     * @return a integer.
     */
    public int getY() {
        return y;
    }
}


