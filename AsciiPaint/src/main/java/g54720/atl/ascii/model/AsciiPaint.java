package g54720.atl.ascii.model;

/**
 * The paint of Ascii for the all drawing.
 *
 * @author g54720
 */
public class AsciiPaint {

    private Drawing drawing;

    /**
     * Overloading the constructor. It call the other overloarding of Drawing
     * who initial a default drawing .
     */
    public AsciiPaint() {
        drawing = new Drawing();
    }

    /**
     * Constructor of AsciiPaint who initiate the attribute with the parameter
     *
     * @param height a integer , is the height of the drawing of AsciiPaint.
     * @param width a integer , is the height of the drawing of AsciiPaint.
     */
    public AsciiPaint(int height, int width) {
        drawing = new Drawing(height, width);
    }

    /**
     * Initiate a circle with the parameter and add a circle in the drawing.
     *
     * @param x a integer, abscissa of the position of circle.
     * @param y a integer, ordinate of the position of circle.
     * @param radius a double, the radius of the circle
     * @param color a character , the color fo the circle.
     * @return a integerw the id of the shape.
     * @throws IllegalArgumentException if the radius as lower than 0 or 0.
     */
    public int newCircle(int x, int y, double radius, char color) {
        if (radius <= 0) {
            throw new IllegalArgumentException(
                    "Negativ or Zero ,radius=" + radius);
        }
        Circle circle = new Circle(new Point(x, y), radius, color);
        return drawing.addShape(circle);
    }

    /**
     * Initiate a rectangle with the parameter and add a rectangle in the
     * drawing.
     *
     * @param x a integer, abscissa of the position of rectangle.
     * @param y a integer, ordinate of the position of rectangle.
     * @param width a double, the width of the rectangle.
     * @param height a double, the height of the rectangle.
     * @param color a character , the color fo the rectangle.
     * @return a integer, the id of shape.
     * @throws IllegalArgumentException if the width or heigth as lower than 0 or 0.
     */
    public int newRectangle(int x, int y, double width, double height, char color) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException(
                    "Negativ or Zero ,width =" + width + " height = " + height);
        }
        Rectangle rectangle = new Rectangle(new Point(x, y), width, height, color);
        return drawing.addShape(rectangle);
    }

    /**
     * Initiate a square with the parameter and add a square in the drawing.
     *
     * @param x a integer, abscissa of the position of square.
     * @param y a integer, ordinate of the position of square.
     * @param side a double, the side of the square.
     * @param color a character , the color fo the square.
     * @return a integer, the id of shape.
     * @throws IllegalArgumentException if the side as lower than 0 or 0.
     */
    public int newSquare(int x, int y, double side, char color) {
        if (side <= 0) {
            throw new IllegalArgumentException(
                    "Negativ or Zero ,side " + side);
        }
        Square square = new Square(new Point(x, y), side, color);
        return drawing.addShape(square);
    }

    /**
     * Initiate a line with the parameter and add a line in the drawing.
     *
     * @param x a integer , abscissa of the position of the first point of line.
     * @param y a integer, ordinate of the position of the first point of line.
     * @param dx a integer, abscissa of the position of the second point of
     * line.
     * @param dy a integer , ordinate ofthe position of the seconde point of
     * line.
     * @param color a char n the color of the new line .
     * @return a integer the id of shape.
     */
    public int newLine(int x, int y, int dx, int dy, char color) {
        Line line = new Line(new Point(x, y), new Point(dx, dy), color);
        return drawing.addShape(line);
    }

    /**
     * Create a new group with shape .
     *
     * @param color a character ,the color of the group.
     * @param x a colored shape .
     * @param y a colored shape .
     * @return a integer the id of the group.
     *
     */
    public int newGroup(char color, Shape x, Shape y,int idxA,int idxB) {
        Group group = new Group(color, x, y,idxA,idxB);
        int id = drawing.addShape(group);
        drawing.getShapes().remove(x);
        drawing.getShapes().remove(y);
        return id;
    }

    /**
     * Remove a group from the model AsciiPaint but check if is in the model.
     *
     * @param group a group to remove
     */
    public void removGroup(Group group) {
        if (drawing.getShapes().contains(group)) {
            drawing.addShape(group.getListColor().get(0),group.getIndexA());
            drawing.addShape(group.getListColor().get(1),group.getIndexB());
            drawing.getShapes().remove(group);
        }
    }

    /**
     * Remove the shape.
     *
     * @param id integer
     */
    public void removId(int id) {
        drawing.getShapes().remove(id);
    }

    /**
     * Get the width of the drawing.
     *
     * @return a width of the drawing, a integer.
     */
    public int getWidth() {
        return drawing.getWidth();
    }

    /**
     * Get the height of the drawing.
     *
     * @return a height of the drawing, a integer.
     */
    public int getHeight() {
        return drawing.getHeight();
    }

    /**
     * Get the shape of the drawing.
     *
     * @param p the point of the position.
     * @return true if a shape is on the drawing, a boolean.
     */
    public Shape getShapeAt(Point p) {
        return drawing.getShapeAT(p);
    }

    /**
     * Get the drawing.
     *
     * @return drawing of the ascii paint.
     */
    public Drawing getDrawing() {
        return drawing;
    }

}
