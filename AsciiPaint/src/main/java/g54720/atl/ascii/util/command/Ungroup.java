package g54720.atl.ascii.util.command;

import g54720.atl.ascii.model.AsciiPaint;
import g54720.atl.ascii.model.Group;

/**
 * The command of ungroup a group , Ungroup is the extends of the classe
 * Command.
 *
 * @author g54720
 */
public class Ungroup implements Command {

    private AsciiPaint model;
    private int id;
    private final Group group;
    private boolean undo = false;

    /**
     * Contructor to create a Ungroup with gived parameter.
     *
     * @param model a AsciiPaint ,the model of AsciiPaint.
     * @param id a integer ,the id of the group to ungroup.
     * @param group a group ,the group to disolve.
     */
    public Ungroup(AsciiPaint model, int id, Group group) {
        this.model = model;
        this.id = id;
        this.group = group;
    }

    @Override
    public void execute() {
        model.removGroup(group);
    }

    @Override
    public void unexecute() {
        id = model.getDrawing().addShape(group);
        undo = true;
    }

}

