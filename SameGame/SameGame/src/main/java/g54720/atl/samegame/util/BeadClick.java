package g54720.atl.samegame.util;

import g54720.atl.samegame.model.Bead;
import g54720.atl.samegame.model.Model;
import g54720.atl.samegame.model.Position;

/**
 * Create the command of click a bead.
 * @author g54720
 */
public class BeadClick implements Command {

    private final Model model;
    private final Position pos;
    private Bead oldMap[][];
    private final int oldScore;

    /**
     * The constructor of clickBead.
     *
     * @param model the model is the place where the change will take place.
     * @param pos the position of the bead select.
     */
    public BeadClick(Model model, Position pos) {
        this.model = model;
        this.pos = pos;
        oldScore = model.getScore();
    }

    @Override
    public void execute() {
        this.oldMap = model.getBoard().getBeads();
        model.play(pos);
    }

    @Override
    public void unexecute() {
        model.undoMove(oldMap, oldScore);
    }

}




