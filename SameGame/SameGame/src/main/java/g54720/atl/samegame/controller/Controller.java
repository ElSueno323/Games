package g54720.atl.samegame.controller;

import java.util.Scanner;
import g54720.atl.samegame.model.Model;
import g54720.atl.samegame.model.Position;
import g54720.atl.samegame.view.viewconsole.ViewConsole;
import g54720.atl.samegame.util.Command;
import g54720.atl.samegame.util.BeadClick;
import g54720.atl.samegame.util.CommandManager;

/**
 * Create the controller with a model and a view of console.
 *
 * @author g54720
 */
public class Controller {

    private Scanner clavier = new Scanner(System.in);
    private final Model model;
    private final ViewConsole view;
    private CommandManager managerCommand;

    /**
     * Constructor of the controller with parameter .
     *
     * @param model a Model , the model of the SameGame.
     * @param view a View ,the view of the SameGame .
     */
    public Controller(Model model, ViewConsole view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Begin the game.
     */
    public void Begin() {
        start();
        gameProgress();
    }

    /**
     * The progress of the game .
     */
    void gameProgress() {
        menuChoose();
        while (!endGame()) {
            askCommand();
        }
        if (model.isEmpty()) {
            view.winScreen();
        } else {
            view.viewMap();
            view.blockedScreen();
        }
    }

    /**
     * Start the game game. Print the main menu.
     */
    void start() {
        view.startMenu();
        managerCommand = new CommandManager();
    }

    /**
     * Ask to the player if he want begin the game of change the length of the
     * map .
     */
    public void menuChoose() {
        String choose = clavier.nextLine();
        while (!choose.equals("start") && !choose.equals("configuration")) {
            view.printD("invalide commande");
            view.startMenu();
            choose = clavier.nextLine();
        }
        switch (choose) {
            case "start":
                beginGame();
                break;
            case "configuration":
                configGame();
                break;
        }
    }

    /**
     * Start the game and print the welcome view.
     */
    public void beginGame() {
        askCommand();
    }

    /**
     * Ask the command for a move.
     */
    public void askCommand() {
        Command command;
        view.viewMap();
        view.askCommand();
        String[] splitCommand = clavier.nextLine().split("");

        while (splitCommand.length == 0 || splitCommand.length > 2) {
            view.askCommand();
            splitCommand = clavier.nextLine().split("");
        }
        switch (splitCommand[0]) {
            case "u":
                managerCommand.undo();
                break;
            case "r":
                managerCommand.redo();
                break;
            default:
                int x = Integer.parseInt(splitCommand[0]);
                int y = Integer.parseInt(splitCommand[1]);

                if (x >= 0 && x < model.getBoard().getBeads().length
                        && y >= 0 && y < model.getBoard().getBeads()[0].length) {

                    command = new BeadClick(model, new Position(x, y));
                    managerCommand.execute(command);
                }
        }
    }

    /**
     * Change the configuration of the game. and ask whats is the new size of
     * the map and the difficulty.
     *
     */
    public void configGame() {
        view.configuration();
        String choose = clavier.nextLine();
        String chooseSplit[] = choose.split(" ");
        int height = Integer.parseInt(chooseSplit[0]);
        int width = Integer.parseInt(chooseSplit[1]);
        int level;
        while (height > model.getBoard().getMaxHeight() || height <= 0
                || width > model.getBoard().getMaxWidth() || width <= 0) {
            view.printD("Try again");
            view.configuration();
            choose = clavier.nextLine();
            chooseSplit = choose.split(" ");
            height = Integer.parseInt(chooseSplit[0]);
            width = Integer.parseInt(chooseSplit[1]);
        }
        view.printchangeLevel();
        level = clavier.nextInt();
        while (level < 3 || level > 5) {
            view.printchangeLevel();
            level = clavier.nextInt();
        }
        model.start(level, width, height);
        gameProgress();
    }

    /**
     * Check if the game is end.
     *
     * @return a boolean, if true the game is finish.
     */
    public boolean endGame() {
        return model.isBlocked() || model.isEmpty();
    }
}

