package g54720.atl.ascii.model;

/**
 * The shape of a Circle who extend of the class ColoredShape.
 *
 * @author g54720
 */
public class Circle extends ColoredShape {

    private Point center;
    private final double radius;

    /**
     * Constructor to create a Circle by using the super class of ColoredShape
     * who use the super class Shape.
     *
     * @param center a point , is the center of the circle.
     * @param radius a double , is the radius of the circle.
     * @param color a char, the color of the circle.
     * @throws IllegalArgumentException if the radius as lower than 0 or 0.
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("Negative or zero radius= " + radius);
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public boolean IsInside(Point p) {
        return center.distanceTo(p) < radius;
    }

}
