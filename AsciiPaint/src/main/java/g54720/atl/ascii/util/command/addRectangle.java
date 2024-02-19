package g54720.atl.ascii.util.command;

import g54720.atl.ascii.model.AsciiPaint;

/**
 * The command of add a rectangle to the game , addRectangle is the extends of
 * the class of Command.
 *
 * @author g54720
 */
public class addRectangle implements Command {

    private AsciiPaint model;
    private final int x;
    private final int y;
    private final double width;
    private final double height;
    private final char color;
    private int id;

    /**
     * Contructor to create a addCircle with gived parameter.
     *
     * @param model the model of AsciiPaint.
     * @param x a int ,abscissa of the point upper left.
     * @param y a int,ordinate of the point upper left.
     * @param width a double , the width of the rectangle.
     * @param height a double, the height of the rectangle.
     * @param color a char, the color of the rectangle.
     */
    public addRectangle(AsciiPaint model, int x, int y, double width, double height, char color) {
        this.model = model;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void execute() {
        id = model.newRectangle(x, y, width, height, color);
    }

    @Override
    public void unexecute() {
        model.removId(id);
    }

}


