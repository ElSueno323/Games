package g54720.atl.samegame.view.viewfx;

import g54720.atl.samegame.model.Model;
import g54720.atl.samegame.model.Position;
import g54720.atl.samegame.util.Observers.Observer;
import g54720.atl.samegame.util.BeadClick;
import g54720.atl.samegame.util.CommandManager;
import g54720.atl.samegame.view.*;
import java.util.List;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Create the view with Java fx.
 *
 * @author g54720
 */
public class ViewFx implements View, Observer {

    private final Model model;

    private CommandManager managerCommand = new CommandManager();

    private  Stage stage;

    private final GridPane interfaceGame;
    private final LeftBoardView leftGame;
    private final BoardView game;

    private final BottomBoardView menu;
    private ButtonPosition[][] mapBuBe;
    
    private Scene scene;

    /**
     * The constructor of the ViewFx.
     *
     * @param model the façade of the game.
     * @param stage the window of the screen.
     */
    public ViewFx(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;
        stage.setTitle("SAME-GAME");
        model.subscribe(this);

        mapBuBe = new ButtonPosition[model.getBoard().getBeads().length]
                [model.getBoard().getBeads()[0].length];

        leftGame = new LeftBoardView();
        game = new BoardView();

        menu = new BottomBoardView(model);

        interfaceGame = new GridPane();
        interfaceGame.setPadding(new Insets(20));
        
        
        menu.getBtnWind().setOnAction(t->newView());
        
        startMenu();
        interfaceGame.add(leftGame, 0, 0);
        interfaceGame.add(game, 1, 0);
        interfaceGame.add(menu, 1, 1);
        configuration();               
        scene = new Scene(interfaceGame, 1000, 750);
        stage.setScene(scene);
        stage.show();
    }
    public ViewFx(Model model,Stage stage,int a) {
        stage.setTitle("Copy");
        this.model=model;
        game = new BoardView();
        interfaceGame = new GridPane();
        leftGame=new LeftBoardView();
        menu=new BottomBoardView(model);
        model.subscribe(this);
        scene=new Scene(game,500,500);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Change the window when the player click tho the button start.
     */
    @Override
    public void startMenu() {
        if (!model.isStartGame()) {
            menu.getStart().setOnAction((t) -> {
                game.getChildren().clear();
                int level = Integer.parseInt(menu.getLevel().getValue().
                        toString().split(" ")[0]);
                int x = Integer.parseInt(menu.getTextWidht()
                        .getText().split(" ")[0]);
                int y = Integer.parseInt(menu.getTextHeight()
                        .getText().split(" ")[0]);
                if (x > model.getBoard().getMaxWidth() || x < 5) {
                    x = model.getBoard().getMaxWidth();
                }
                if (y > model.getBoard().getMaxHeight() || y < 5) {
                    y = model.getBoard().getMaxHeight();
                }
                model.start(level, x, y);
                menu.beginGame();
            });
        } else {
            menu.getStart().setOnAction((t) -> {
                menu.beginGame();
                model.giveUp();
            });

        }
    }

    /**
     * Create the action of button undo and redo.
     */
    @Override
    public void configuration() {
        menu.getUndo().setOnAction((t) -> {
            managerCommand.undo();
        });
        menu.getRedo().setOnAction((t) -> {
            managerCommand.redo();
        });
    }

    /**
     * Refresh the window when an action is taken.
     */
    @Override
    public void viewMap() {
        game.viewMap(model,mapBuBe,managerCommand);
        leftGame.refresh(model);
    }

    /**
     * Create a button bead with color and a style.
     *
     * @param btnB a ButtonPosition, the button who receives the configurations.
     * @param color a String , the color of the button.
     */
    private void createColorBut(ButtonPosition btnB, String color) {
        game.createColorBut(btnB, color, model,mapBuBe,managerCommand);

    }



    @Override
    public void askCommand() {
        game.getChildren().clear();
        for (int i = 0; i < model.getBoard().getBeads().length; i++) {
            for (int j = 0; j < model.getBoard().getBeads()[i].length; j++) {
                ButtonPosition btnB = new ButtonPosition(i, j);
                mapBuBe[i][j] = btnB;
                if (model.getBoard().getBeads()[i][j] != null) {
                    String color = model.getBoard().getBeads()[i][j]
                            .getColor().toString();
                    createColorBut(btnB, color);
                } else {
                    createColorBut(btnB, "black");
                }
                game.add(btnB, j, i);
            }
        }
    }

    @Override
    public void winScreen() {
        leftGame.finishScreen();
    }

    @Override
    public void blockedScreen() {
        leftGame.blockedScreen();
    }

    @Override
    public void update(String message) {
        switch (message.split(" ")[0]) {
            case "start":
            case "giveup":
                startMenu();
                managerCommand = new CommandManager();
                break;
        }
        viewMap();
        if (model.isEmpty() || model.isBlocked()) {
            if (model.isEmpty()) {
                winScreen();
            } else {
                blockedScreen();
            }
        }
    }
    
    
    public void newView(){
        Stage newSta=new Stage();       
        View newFx=new ViewFx(model,newSta,5);
        newFx.viewMap();
    } 
}