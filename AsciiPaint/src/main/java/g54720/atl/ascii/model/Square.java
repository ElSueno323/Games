package g54720.atl.ascii.model;

/**
 * The shape Square who is a extends of the class Rectangle.
 *
 * @author g54720
 */
public class Square extends Rectangle {

    /**
     * Constructor to create a Square by using the super class of Rectangle.
     *
     * @param upperLeft a Point, coordinate of the upper left of the square.
     * @param side a Double ,is the size of a side.
     * @param color a char, is the color of the shape.
     * @throws IllegalArgumentException if the position as negative or null .
     *
     */
    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

}
