package g54720.atl.ascii.util.command;

import g54720.atl.ascii.model.AsciiPaint;

/**
 * The command of add a square tho the game , addSquare is the extends of the
 * class of Command.
 *
 * @author g54720
 */
public class addSquare implements Command {

    private AsciiPaint model;
    private final int x;
    private final int y;
    private final double side;
    private final char color;
    private int id;

    /**
     * Constructor to create a addSquare with gived parameter.
     *
     * @param model the model of AsciiPaint.
     * @param x a int, coordinate of the upper left of the square.
     * @param y a int, ordinate the upper left of the square.
     * @param side a Double ,is the size of a side.
     * @param color a char, is the color of the shape.
     *
     */
    public addSquare(AsciiPaint model, int x, int y, double side, char color) {
        this.model = model;
        this.x = x;
        this.y = y;
        this.side = side;
        this.color = color;
    }

    @Override
    public void execute() {
        id = model.newSquare(x, y, side, color);
    }

    @Override
    public void unexecute() {
        model.removId(id);
    }

}

