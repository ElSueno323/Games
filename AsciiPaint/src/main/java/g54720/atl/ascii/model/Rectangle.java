package g54720.atl.ascii.model;

/**
 * The shape of a Rectangle who extend of the class ColoredShape.
 *
 * @author g54720
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private final double width;
    private final double height;

    /**
     * Constructor to create a Rectangle by using the super class of
     * ColoredShape who use the super class Shape.
     *
     * @param upperLeft a Point, is the coordinate of the point upper left.
     * @param width a double , the width of the rectangle.
     * @param height a double, the height of the rectangle.
     * @param color a char, the color of the rectangle.
     * @throws IllegalArgumentException if width or height as lower of 0 or 0.
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(""
                    + "Negative or null width or negative or null height "
                    + " width =" + width + " heigth=" + height);
        }
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean IsInside(Point p) {
        return (upperLeft.getX() < p.getX()
                && upperLeft.getY() < p.getY())
                && (upperLeft.getX() + width > p.getX()
                && upperLeft.getY() < p.getY())
                && (upperLeft.getX() < p.getX()
                && upperLeft.getY() + height > p.getY())
                && (upperLeft.getX() + width > p.getX()
                && upperLeft.getY() + height > p.getY());
    }

    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }


}
