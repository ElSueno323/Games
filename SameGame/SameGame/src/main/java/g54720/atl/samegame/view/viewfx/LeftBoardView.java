package g54720.atl.samegame.view.viewfx;

import g54720.atl.samegame.model.Model;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Create the box of the left board.
 *
 * @author g54720
 */
public class LeftBoardView extends GridPane {

    private final GridPane boxScore;
    private final Label namSco;
    private final Label score;
    private final Label lastPoint;
    private final Label lastSco;
    private final GridPane lastScorebox;

    private final GridPane poppupEnd = new GridPane();

    /**
     * The Constructor of the left of the board view.
     */
    public LeftBoardView() {
        boxScore = new GridPane();
        namSco = new Label("    SCORE    ");
        score = new Label("000");
        namSco.setStyle("-fx-text-fill : Yellow;"
                + "-fx-font-size: 20px;");
        score.setStyle("-fx-text-fill : white;"
                + "-fx-font-size: 14px;");
        boxScore.setStyle("-fx-border-color :YELLOW;"
                + "-fx-background-color :BLACK;"
                + "-fx-text-fill : white;");

        lastPoint = new Label("000");
        lastSco = new Label("  LAST HIT  ");
        lastScorebox = new GridPane();

        lastSco.setStyle("-fx-text-fill : Yellow;"
                + "-fx-font-size: 20px;");
        lastPoint.setStyle("-fx-text-fill : white;"
                + "-fx-font-size: 14px;");
        lastScorebox.setStyle("-fx-border-color :YELLOW;"
                + "-fx-background-color :BLACK;"
                + "-fx-text-fill : white;"
        );
        lastScorebox.setMinSize(110, 50);
        lastScorebox.add(lastSco, 0, 0);
        lastScorebox.add(lastPoint, 0, 1);

        boxScore.setMinSize(110, 50);
        boxScore.add(namSco, 0, 0);
        boxScore.add(score, 0, 1);

        poppupEnd.setAlignment(Pos.CENTER);
        poppupEnd.setStyle("-fx-background-radius : 2em;"
                + "-fx-border-radius :2em;"
                + "-fx-border-height :1em;");
        poppupEnd.setOpacity(0);

        this.add(boxScore, 0, 0);
        this.add(lastScorebox, 0, 1);
        this.add(poppupEnd, 0, 2);
    }

    /**
     * Print a box with the screen's blocked.
     */
    void blockedScreen() {

        poppupEnd.getChildren().clear();
        poppupEnd.setOpacity(1);
        Label blocked = new Label("Blocked");
        blocked.setStyle("-fx-text-fill :red;");
        poppupEnd.add(blocked, 0, 0);
        poppupEnd.setStyle("-fx-background-color: black;"
                + "-fx-border-color :red;");
        poppupEnd.setMinSize(100, 40);
    }

    /**
     * Print a bow with the finished's screen.
     */
    void finishScreen() {
        poppupEnd.getChildren().clear();
        poppupEnd.setOpacity(1);
        Label finish = new Label("Finish");
        finish.setStyle("-fx-text-fill :blue;");
        poppupEnd.add(finish, 0, 0);
        poppupEnd.setStyle("-fx-background-color: gold;"
                + "-fx-border-color :gold;");
        poppupEnd.setMinSize(100, 40);
    }

    /**
     * Refresh the view with new score .
     *
     * @param model the Model, the database of samegame.
     */
    protected void refresh(Model model) {
        score.setText("000" + model.getScore());
        lastPoint.setText("000" + model.getHitscore());
        poppupEnd.setOpacity(0);
    }
}

