package g54720.atl.ascii.model;

/**
 * Create a Color for a Shape and implement the interface Shape.
 *
 * @author g54720
 */
public abstract class ColoredShape implements Shape {

    private char color;

    /**
     * Constructor to create o color for a Shape.
     *
     * @param color a char , is the color of the ColoredShape.
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * Show what is the color of the shape.
     *
     * @return a character who is a color.
     */
    @Override
    public char getColor() {
        return color;
    }

    /**
     * Set the color of the ColoredShape
     *
     * @param color a char, is a color
     */
    @Override
    public void setColor(char color) {
        this.color = color;
    }
}
