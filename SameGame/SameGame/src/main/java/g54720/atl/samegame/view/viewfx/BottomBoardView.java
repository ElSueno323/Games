package g54720.atl.samegame.view.viewfx;

import g54720.atl.samegame.model.Model;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Create the bottom of the board . With all option for play a game.
 *
 * @author g54720
 */
public class BottomBoardView extends GridPane {

    private final ChoiceBox level;
    private final TextField widht;
    private final TextField height;
    private final Button start;
    private final Button undo;
    private final Button redo;
    private Button btnWind;
/**
 * The constructor of create a gme with buttons.
 * @param model the Model, the database for information.
 */
    public BottomBoardView(Model model) {
        level = new ChoiceBox();
        level.setValue("3 Colors");
        level.getItems().add("3 Colors");
        level.getItems().add("4 Colors");
        level.getItems().add("5 Colors");

        widht = new TextField("5");
        height = new TextField("5");
        start = new Button("Start");
        undo = new Button("Undo");
        redo = new Button("Redo");

        this.setHgap(10);
        this.setAlignment(Pos.CENTER);

        this.add(undo, 0, 0);
        this.add(redo, 1, 0);

        this.add(start, 3, 0);
        this.add(level, 4, 0);

        Label widTex = new Label("Widht ,max=>" + model.getBoard()
                .getMaxWidth());
        Label heigTex = new Label("Height ,max=>" + model.getBoard()
                .getMaxHeight());
        this.add(widht, 5, 0);
        this.add(widTex, 6, 0);
        this.add(height, 5, 1);
        this.add(heigTex, 6, 1);
        
        //modif
        btnWind=new Button("New windows");
        this.add(btnWind, 0, 1);
    }

    /**
     * Give the button undo.
     *
     * @return a button
     */
    Button getUndo() {
        return undo;
    }

    /**
     * Give the button redo.
     *
     * @return a button
     */
    Button getRedo() {
        return redo;
    }

    /**
     * Give the choiceBox of level.
     *
     * @return a choiBox
     */
    ChoiceBox getLevel() {
        return level;
    }

    /**
     * Give the textField textWidht.
     *
     * @return a textField
     */
    TextField getTextWidht() {
        return widht;
    }

    /**
     * Give the textField textHeight.
     *
     * @return a textField
     */
    TextField getTextHeight() {
        return height;
    }

    /**
     * Give the button start.
     *
     * @return a button
     */
    public Button getStart() {
        return start;
    }
    
    public Button getBtnWind(){
        return btnWind;
    }

    /**
     * When the game is begin blocke button and change start with give up.
     */
    void beginGame() {
        if ("Start".equals(start.getText())) {
            this.getStart().setText("GIVE-UP");
            this.getTextWidht().setDisable(true);
            this.getTextHeight().setDisable(true);
            this.getLevel().setDisable(true);
        } else {
            this.getStart().setText("Start");
            this.getTextWidht().setDisable(false);
            this.getTextHeight().setDisable(false);
            this.getLevel().setDisable(false);
        }
    }
    
}






