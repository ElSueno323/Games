package g54720.atl.ascii.util.command;

import g54720.atl.ascii.model.AsciiPaint;

/**
 * The command of change the color of a ColoredShape tho the game , changeColor
 * is the extends of the class of Command.
 *
 * @author g54720
 */
public class changeColor implements Command {

    private AsciiPaint model;
    private char color;
    private final char oldcolor;
    private final int id;

    /**
     * Constructor to create a changeColor with gived parameter.
     *
     * @param model the model of AsciiPaint.
     * @param color a char, the new color of the shape.
     * @param id a integer , the id of the ColoredShape to change.
     */
    public changeColor(AsciiPaint model, char color, int id) {
        this.model = model;
        this.color = color;
        this.id = id;
        oldcolor = model.getDrawing().getShapes().get(id).getColor();
    }

    @Override
    public void execute() {
        model.getDrawing().getShapes().get(id).setColor(color);
    }

    @Override
    public void unexecute() {
        model.getDrawing().getShapes().get(id).setColor(oldcolor);
    }


}




