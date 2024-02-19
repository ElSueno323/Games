package g54720.atl.ascii.util.command;

import g54720.atl.ascii.model.AsciiPaint;

/**
 * The command of add a line to the game, addLine is the extends of the class of
 * Command.
 *
 * @author g54720
 */
public class addLine implements Command {

    private AsciiPaint model;
    private final int x;
    private final int y;
    private final int dx;
    private final int dy;
    private final char color;
    private int id;

    /**
     * Constructor to create a addLine with gived parameter.
     *
     * @param model the model of AsciiPaint.
     * @param x a int ,abscissa of the first point.
     * @param y a int, ordinate of the first point.
     * @param dx a int, ordinate of the second point.
     * @param dy a int, ordinate of the second point.
     * @param color a char, the color of the circle.
     */
    public addLine(AsciiPaint model, int x, int y, int dx, int dy, char color) {
        this.model = model;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }

    @Override
    public void execute() {
        id = model.newLine(x, y, dx, dy, color);
    }

    @Override
    public void unexecute() {
        model.removId(id);
    }


}






