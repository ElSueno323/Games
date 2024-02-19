package g54720.atl.samegame.view.viewfx;

import g54720.atl.samegame.model.Model;
import g54720.atl.samegame.model.Position;
import g54720.atl.samegame.util.BeadClick;
import g54720.atl.samegame.util.CommandManager;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/**
 * Change the Setting of the view board.
 *
 * @author g54720
 */
public class BoardView extends GridPane {

    /**
     * Create the view of board withe a style.
     */
    public BoardView() {
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: BLACK;");
        this.setMinSize(850, 650);
        this.setMaxSize(850, 650);
    }

    public void viewMap(Model model, ButtonPosition[][] mapBuBe, CommandManager managerCommand) {
        this.getChildren().clear();
        mapBuBe = new ButtonPosition[model.getBoard()
                .getBeads().length][model.getBoard().getBeads()[0].length];
        for (int i = 0; i < model.getBoard().getBeads().length; i++) {
            for (int j = 0; j < model.getBoard().getBeads()[0].length; j++) {
                ButtonPosition btnB = new ButtonPosition(i, j);
                mapBuBe[i][j] = btnB;
                String color = "black";
                if (model.getBoard().getBeads()[i][j] != null) {
                    color = model.getBoard().
                            getBeads()[i][j].getColor().toString();
                }
                createColorBut(btnB, color, model,mapBuBe,managerCommand);
                this.add(btnB, j, i);
            }
        }

    }

    void createColorBut(ButtonPosition btnB,
            String color, Model model,ButtonPosition[][] mapBuBe, CommandManager managerCommand) {
        btnB.setStyle(""
                + "-fx-border-color :DARK" + color + ";"
                + "-fx-border-radius:5em;"
                + "-fx-background-radius:2em;"
                + "-fx-border-width:1ex;"
                + "-fx-font-size: 1ex;"
                + "-fx-background-color : " + color + ";");
        if (!"black".equals(color)) {
            btnB.setOnAction((t) -> {
                if (model.hoverVisted(btnB.getX(), btnB.getY()).size() > 1) {
                    managerCommand.execute(new BeadClick(model,
                            new Position(btnB.getX(), btnB.getY())));
                }
            });
            btnB.setOnMouseEntered((t) -> {
                btnB.setOpacity(1);
                searchSame(btnB.getX(), btnB.getY(), true, mapBuBe,model);
            });
            btnB.setOnMouseExited((t) -> {
                btnB.setOpacity(0.7);
                searchSame(btnB.getX(), btnB.getY(), false,mapBuBe,model);
            });
            btnB.setOpacity(0.7);
        }
        btnB.setMaxSize(10, 10);
    }

    private void searchSame(int x, int y, boolean ilumination, ButtonPosition[][] mapBuBe, Model model) {
        List<Position> visted = model.hoverVisted(x, y);
        for (Position position : visted) {
            if (ilumination == true) {
                mapBuBe[position.getX()][position.getY()].setOpacity(1);
            } else {
                mapBuBe[position.getX()][position.getY()].setOpacity(0.7);
            }
        }
    }
}
