package g54720.atl.ascii.model;

/**
 * Create a point in cartesian plane with a abscissa and a ordinate.
 *
 * @author g54720
 */
public class Point {

    private double x;
    private double y;

    /**
     * Constructor to create a point with abscissa and ordinate.
     *
     * @param x a double, abscissa of the point.
     * @param y a double , ordinate of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The overload of the constructor of point with a parameter of Point with
     * transform her abscissa and her ordinate in a double .
     *
     * @param p a Point , a other point .
     */
    public Point(Point p) {
        this(p.x, p.y);
    }

    /**
     * Move the abscissa and ordinate of the actual point with the parameter dx
     * for abscissa and dy for ordinate.
     *
     * @param dx a double, abscissa of the move .
     * @param dy a double , ordinate of the move.
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * Calculate the distance of the actual point and a other point.
     *
     * @param other a point.
     * @return a double , who is the result of distance of two point.
     */
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow((other.x - this.x), 2)
                + Math.pow((other.y - this.y), 2));
    }

    /**
     * Get the x of the point .
     *
     * @return a abscissa of the point , a double .
     */
    public double getX() {
        return x;
    }

    /**
     * Get the y of the point .
     *
     * @return a ordinate of the point , a double .
     */
    public double getY() {
        return y;
    }

}
