package g54720.atl.ascii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The shape of a Group of Shapes ,extends ColoredShape
 *
 * @author g54720
 */
public class Group extends ColoredShape {

    private List<Shape> listcolor = new ArrayList<>(); //@srv: on préfère utiliser Shape
    private int indexA;
    private int indexB;
    /**
     * Constructor to create a Group of Colored by using the super class of
     * Shape who use the super class Shape.
     *
     * @param color a character of colors.
     * @param x a Shape.
     * @param y a Shape.
     */
    public Group(char color, Shape x, Shape y,int idxA,int idxB) {
        super(color);
        listcolor.add(x);
        listcolor.add(y);
        this.indexA=idxA;
        this.indexB=idxB;
    }

    @Override
    public boolean IsInside(Point p) {
        return listcolor.stream().anyMatch(Shape -> (Shape.IsInside(p)));
    }

    @Override
    public void move(double dx, double dy) {
        listcolor.forEach(Shape -> {
            Shape.move(dx, dy);
        });
    }

    @Override
    public void setColor(char color) {
        listcolor.forEach(Shape -> {
            Shape.setColor(color);
        });
    }

    /**
     * Get the the of color of shape.
     *
     * @return a list of colored shape.
     */
    List<Shape> getListColor() {
        List<Shape> copy=listcolor;
        return copy;
    }

    public int getIndexA() {
        return indexA;
    }

    public int getIndexB() {
        return indexB;
    }

}

