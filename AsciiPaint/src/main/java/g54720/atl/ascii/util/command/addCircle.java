package g54720.atl.ascii.util.command;

import g54720.atl.ascii.model.AsciiPaint;

/**
 * The command of add a circle tho the game , addCircle is the extends of the
 * class of Command.
 *
 * @author g54720
 */
public class addCircle implements Command {

    private AsciiPaint model;
    private final int x;
    private final int y;
    private final double radius;
    private final char color;
    private int id;

    /**
     * Contructor to create a addCircle with gived parameter.
     *
     * @param model the model of AsciiPaint.
     * @param x a int ,abscissa of the point.
     * @param y a int, ordinate of the point.
     * @param radius a double , is the radius of the circle.
     * @param color a char, the color of the circle.
     */
    public addCircle(AsciiPaint model, int x, int y, double radius, char color) {
        this.model = model;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void execute() {
        id = model.newCircle(x, y, radius, color);
    }

    @Override
    public void unexecute() {
        model.removId(id);
    }

}




