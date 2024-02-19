package g54720.atl.ascii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Create the drawing.
 *
 * @author g54720
 */
public class Drawing {

    private List<Shape> shapes;
    private int height ;  
    private int width ;
    
    private static final int DEFAULT_HEIGHT = 25;
    private static final int DEFAULT_WIDTH=25;

    /**
     * Overloading of constructor without parameter.It initialize a default
     * drawing with 100 of height and 100 of width and a list of shapes.
     */
    public Drawing() {
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }

    /**
     * The constructor of Drawing who initialize them attribute .
     *
     * @param height a integer , is the height of the drawing.
     * @param width a integer, is the width of the drawing.
     * @throws IllegalArgumentException if the height or the height in the
     * parameter as lower than 0 or 0.
     */
    public Drawing(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Negative or null "
                    + "width/height  h="
                    + height + " w=" + width);
        }
        this.height = height;
        this.width = width;
        shapes = new ArrayList<>();
    }

    /**
     * Add a shape in the list of shapes.
     *
     * @param shape a Shape.
     * @return a integer the id of the shape create.
     */
    public int addShape(Shape shape) {
        this.shapes.add(shape);
        return shapes.size() - 1;
    }
    public int addShape(Shape Shape ,int idx){
        this.shapes.add(idx, Shape);
        return idx;
    }

    /**
     * Check a if a shape as in the Point p.
     *
     * @param p a Point.
     * @return if a shape is in the Point return the shape else return a null.
     */
    public Shape getShapeAT(Point p) {

        for (Shape shape : shapes) {
            if (shape.IsInside(p)) {
                return shape;
            }
        }
        return null;
    }

    /**
     * Get the height of the drawing.
     *
     * @return a height of the drawing, a integer.
     */
    int getHeight() {
        return height;
    }

    /**
     * Get the width of the drawing.
     *
     * @return a width of the drawing, a integer.
     */
    int getWidth() {
        return width;
    }

    /**
     * Get the list of shapes on the drawing.
     *
     * @return a list of shape.
     */
    public List<Shape> getShapes() {
        List<Shape> copy=shapes;
        return copy;
    }
}
