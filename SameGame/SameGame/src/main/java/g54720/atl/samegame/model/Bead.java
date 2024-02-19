package g54720.atl.samegame.model;

/**
 * Create a bead with a position and a color.
 *
 * @author g54720
 */
public class Bead {

    private final Position position;
    private final Color color;

    /**
     * Constructor of a bead.
     *
     * @param position a position , with a ordinate and a abscissa.
     * @param color
     */
    Bead(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

    Bead(Bead bead) {
        this.position = bead.position;
        this.color = bead.color;
    }

    /**
     * Get the position of the bead.
     *
     * @return a position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Get the color of the bead.
     *
     * @return a color.
     */
    public Color getColor() {
        return color;
    }
    

}










