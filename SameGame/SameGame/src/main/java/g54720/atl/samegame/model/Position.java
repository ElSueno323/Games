package g54720.atl.samegame.model;

/**
 * Create a position in cartesian plane with a abscissa and a ordinate.
 *
 * @author g54720
 */
public class Position {

    private final int x;
    private final int y;

    /**
     * Constructor to create a position with abscissa and ordinate.
     *
     * @param x a int, abscissa of the position.
     * @param y a int , ordinate of the position.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x of the position .
     *
     * @return a int , abscissa of the position.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y of the position .
     *
     * @return a int ,ordinate of the position .
     */
    public int getY() {
        return y;
    }
}


