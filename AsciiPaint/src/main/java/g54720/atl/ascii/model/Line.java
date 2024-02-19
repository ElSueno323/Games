package g54720.atl.ascii.model;

/**
 * The shape of a Line who extend of the class ColoredShape.
 *
 * @author g54720
 */
public class Line extends ColoredShape {

    private Point first;
    private Point seconde;
    private double coefficient;

    /**
     * Constructor to create a Line byusing the super class of ColoredShape who
     * use the super class Shape.
     *
     * @param first a point is the coordinate of the point .
     * @param seconde a point si the cordinate of the point.
     * @param color a char, the color of the line .
     */
    public Line(Point first, Point seconde, char color) {
        super(color);
        this.first = first;
        this.seconde = seconde;
        coefficient = (seconde.getY() - first.getY()) / (seconde.getX() - first.getX());

    }

    @Override
    public boolean IsInside(Point p) {
        double distancePoint = Math.abs(((coefficient * p.getX()) - p.getY() - (coefficient * first.getX() + first.getY()))) / Math.sqrt(coefficient * coefficient + 1);

        return (distancePoint < 0.5);
    }

    @Override
    public void move(double dx, double dy) {
        first.move(dx, dy);
        seconde.move(dx, dy);
        coefficient = (seconde.getY() - first.getY()) / (seconde.getX() - first.getX());
    }

}

