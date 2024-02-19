package g54720.atl.ascii.util.command;

import g54720.atl.ascii.model.AsciiPaint;
import g54720.atl.ascii.model.Shape;

/**
 * The command for delete a ColoredShape tho the game , deleteShape is the
 * extends of the class of Command.
 *
 * @author g54720
 */
public class deleteShape implements Command {

    private AsciiPaint model;
    private int id;
    private final Shape shape;

    /**
     * Constructor to create a deleteShape with gived parameter.
     *
     * @param model the model of AsciiPaint.
     * @param id a integer, the id of the Shape to delete.
     */
    public deleteShape(AsciiPaint model, int id) {
        this.model = model;
        this.id = id;
        shape = model.getDrawing().getShapes().get(id);
    }

    @Override
    public void execute() {
        model.removId(id);
    }

    @Override
    public void unexecute() {
        id = model.getDrawing().addShape(shape,id);
    }


}


