package g54720.atl.ascii.util.command;

import g54720.atl.ascii.model.AsciiPaint;
import g54720.atl.ascii.model.Shape;
import g54720.atl.ascii.model.Group;

/**
 * The command of grouped two ColoredShapes ,Grouped is the extends of the
 * classe Command.
 *
 * @author g54720
 */
public class Grouped implements Command {

    private AsciiPaint model;
    private Shape idA;
    private Shape idB;
    private int idxA;
    private int idxB;
    private int idGrp;

    /**
     * Constructor to create a Group with gived parameter.
     *
     * @param model the model of AsciiPaint.
     * @param shapeA a ColoredShape,the first of ColoredShape .
     * @param shapeB a ColoredShape,the second of ColoredShape.
     */
    public Grouped(AsciiPaint model, Shape shapeA, Shape shapeB ,int idxA,int idxB) {
        this.model = model;
        this.idA = shapeA;
        this.idB = shapeB;
        this.idxA=idxA;
        this.idxB=idxB;
    }

    @Override
    public void execute() {
        idGrp = model.newGroup(idA.getColor(), idA, idB,idxA,idxB);
    }

    @Override
    public void unexecute() {
        model.removGroup((Group) model.getDrawing().getShapes().get(idGrp));
    }
}



