package g54720.atl.ascii.util.command;

import g54720.atl.ascii.model.AsciiPaint;

/**
 * The command for move a ColoredShape tho the game , moveShape is the extends
 * of the class of Command.
 *
 * @author g54720
 */
public class moveShape implements Command {

    private AsciiPaint model;
    private final int x;
    private final int y;
    private final int id;

    /**
     * Constructor to create a moveShape withe gived parameter.
     *
     * @param model the model of AsciiPaint.
     * @param x a integer ,abscissa of the move point.
     * @param y a integer, ordinate of the move point.
     * @param id a integer , the id of the shape.
     */
    public moveShape(AsciiPaint model, int x, int y, int id) {
        this.model = model;
        this.x = x;
        this.y = y;
        this.id = id;
    }

    @Override
    public void execute() {
        model.getDrawing().getShapes().get(id).move(x, y);
    }

    @Override
    public void unexecute() {
        model.getDrawing().getShapes().get(id).move(-x, -y);
    }

}
