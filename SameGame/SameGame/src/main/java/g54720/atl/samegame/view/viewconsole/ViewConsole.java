package g54720.atl.samegame.view.viewconsole;

import g54720.atl.samegame.model.Model;
import g54720.atl.samegame.model.Position;
import g54720.atl.samegame.view.View;

/**
 * Create e view console.
 *
 * @author g54720
 */
public class ViewConsole implements View {

    private final Model model;

    /**
     * Constructor of the viewConsole. Initiate the attrivut model.
     *
     * @param model A Model.
     */
    public ViewConsole(Model model) {
        this.model = model;
    }

    @Override
    public void startMenu() {
        System.out.println("------Main Menu------\n"
                + "--> Start (height=" + model.getBoard().getBeads().length
                + " width=" + model.getBoard().getBeads()[0].length
                + "level=" + model.getLevel() + ")\n--> Configuration");

    }

    @Override
    public void configuration() {
        System.out.println("------Configuration------\n-->new size max(50)(30) "
                + "=>height widht");
    }

    /**
     * print the level change.
     */
    public void printchangeLevel() {
        System.out.println("level(3-5) =>level");
    }

    @Override
    public void viewMap() {
        String map = ("Score: " + model.getScore() + "Map : \n");
        for (int i = 0; i < model.getBoard().getBeads().length; i++) {
            for (int j = 0; j < model.getBoard().getBeads()[i].length; j++) {
                if (model.getBoard().getBeads()[i][j] != null) {
                    switch (model.getBoard().getBeadAt(new Position(i, j))) {
                        case CYAN ->
                            map = map + "c-";
                        case GREEN ->
                            map = map + "g-";
                        case RED ->
                            map = map + "r-";
                        case VIOLET ->
                            map = map + "v-";
                        case ORANGE ->
                            map = map + "o-";
                    }
                } else {
                    map = map + ".-";
                }
            }
            map = map + "\n";
        }
        System.out.print(map);
    }

    /**
     * Print e select message.
     *
     * @param text a string.
     */
    public void printD(String text) {
        System.out.println(text);
    }

    @Override
    public void askCommand() {
        System.out.println("--> Give me a position for a bead (xy) "
                + "Or undo(u) Or redo(r)");
    }

    @Override
    public void winScreen() {
        System.out.println("Nice You Finish :D !!! SCORE:" + model.getScore());
    }

    @Override
    public void blockedScreen() {
        System.out.println("You blocked the game !!! :( \n SCORE:"
                + model.getScore());
    }
}

