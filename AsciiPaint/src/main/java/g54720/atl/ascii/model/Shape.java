package g54720.atl.ascii.model;

/**
 * Is the interface of all shape .
 *
 * @author g54720
 */
public interface Shape {

    /**
     * Check if the Point of the parameter is inside the shape.
     *
     * @param p a Point, with a abscissa and ordinate .
     * @return true if the Point p is inside the shape.
     */
    boolean IsInside(Point p);

    /**
     * Move the abscissa and ordinate and add to the point of the shape.
     *
     * @param dx abscissa of a Shape ,a double.
     * @param dy ordinate of a Shape ,a double.
     */
    void move(double dx, double dy);

    char getColor();

    void setColor(char color);

}
