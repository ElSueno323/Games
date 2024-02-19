package g54720.atl.ascii.controller;

import g54720.atl.ascii.model.AsciiPaint;
import g54720.atl.ascii.model.Group;
import g54720.atl.ascii.model.Shape;
import g54720.atl.ascii.util.command.Command;
import g54720.atl.ascii.util.command.Grouped;
import g54720.atl.ascii.util.command.Ungroup;
import g54720.atl.ascii.util.command.addCircle;
import g54720.atl.ascii.util.command.addLine;
import g54720.atl.ascii.util.command.addRectangle;
import g54720.atl.ascii.util.command.addSquare;
import g54720.atl.ascii.util.command.changeColor;
import g54720.atl.ascii.util.command.deleteShape;
import g54720.atl.ascii.util.command.CommandManager;
import g54720.atl.ascii.util.command.moveShape;
import g54720.atl.ascii.view.MyView;
import java.util.Scanner;

/**
 * Controller for the Game model.
 *
 * @author g54720
 */
public class Controller {

    private AsciiPaint paint;
    private MyView view;
    private CommandManager manageCommande;

    /**
     * The constructor of Controller who initiate the private attributs.
     *
     * @param paint a AsciiPaint,the model.
     * @param view a MyView,a view.
     */
    public Controller(AsciiPaint paint, MyView view) {
        this.paint = paint;
        this.view = view;
        manageCommande = new CommandManager();
    }

    /**
     * Begin the initiate view and Start the loop of the game . And finish the
     * game .
     */
    public void start() {
        view.startWelcome();

        boolean gameStop = false;
        while (gameStop == false) {
            gameStop = exeCommande(askCommande());
        }

        view.stopGame();
    }

    /**
     * Ask to the player the command and return it.
     *
     * @return a array of String
     */
    private String[] askCommande() {
        Scanner clavier = new Scanner(System.in);
        view.askCommande();
        String task = clavier.nextLine();
        String taskSplit[] = task.split(" ");
        return taskSplit;
    }

    /**
     * Take the array of split string of command and do each function
     * determine.
     *
     * @param commandeSplit a array of string.
     * @return a boolean, true if the player choose "exit" ,false else.
     */
    public boolean exeCommande(String[] commandeSplit) {
        Command command;
        switch (commandeSplit[0]) {
            case "show":
                view.displayGame(paint);
                break;

            case "exit":
                return true;

            case "list":
                String listShape = "";
                for (int i = 0; i < paint.getDrawing().getShapes().size(); i++) {
                    Shape shape = paint.getDrawing().getShapes().get(i);
                    listShape = listShape + " "
                            + shape.getClass().getSimpleName() + "," + i + ";";
                }
                System.out.println(" List:" + listShape);
                break;

            case "undo":
                manageCommande.undo();
                break;

            case "redo":
                manageCommande.redo();
                break;

            case "add":
                addShape(commandeSplit);
                break;

            case "move":
                int shape = Integer.parseInt(commandeSplit[1]);
                if (shape < 0 || shape > paint.getDrawing().getShapes().size()) {
                    if (shape < 0) {
                        throw new IllegalArgumentException("forme index impossible");
                    } else {
                        throw new IllegalArgumentException("Out of bound");
                    }
                }
                int dx = Integer.parseInt(commandeSplit[2]);
                int dy = Integer.parseInt(commandeSplit[3]);
                command = new moveShape(paint, dx, dy, shape);
                manageCommande.execute(command);
                break;

            case "group":
                dx = Integer.parseInt(commandeSplit[1]);
                dy = Integer.parseInt(commandeSplit[2]);
                char color = paint.getDrawing().getShapes().get(dx).getColor();
                command = new Grouped(paint, paint.getDrawing().getShapes().get(dx),
                        paint.getDrawing().getShapes().get(dy),dx,dy);
                manageCommande.execute(command);
                break;

            case "ungroup":
                int idx = Integer.parseInt(commandeSplit[1]);
                String name = paint.getDrawing().getShapes().get(idx).getClass().getSimpleName();
                if (!("Group".equals(name))) {
                    throw new IllegalAccessError("pas un groupe");
                }
                Group group = (Group) paint.getDrawing().getShapes().get(idx);
                command = new Ungroup(paint, idx, group);
                manageCommande.execute(command);
                break;

            case "color":
                idx = Integer.parseInt(commandeSplit[1]);
                if (idx < 0 || idx > paint.getDrawing().getShapes().size()) {
                    if (idx < 0) {
                        throw new IllegalArgumentException("forme index impossible");
                    } else {
                        throw new IllegalArgumentException("Out of bound");
                    }
                }
                char newColor = commandeSplit[2].charAt(0);
                command = new changeColor(paint, newColor, idx);
                manageCommande.execute(command);
                break;

            case "delete":
                idx = Integer.parseInt(commandeSplit[1]);
                if (idx < 0 || idx > paint.getDrawing().getShapes().size()) {
                    if (idx < 0) {
                        throw new IllegalArgumentException("forme index impossible");
                    } else {
                        throw new IllegalArgumentException("Out of bound");
                    }
                }
                command = new deleteShape(paint, idx);
                manageCommande.execute(command);
        }
        return false;
    }

    /**
     * Create a new shape in the AsciiPaint drawing.
     *
     * @param commandeString a array of command in string.
     */
    private void addShape(String[] commandeString) {
        Command command;
        switch (commandeString[1]) {
            case "circle":
                command = new addCircle(paint, Integer.parseInt(commandeString[2]),
                        Integer.parseInt(commandeString[3]),
                        Integer.parseInt(commandeString[4]) + 1,
                        commandeString[5].charAt(0));
                manageCommande.execute(command);
                break;
            case "rectangle":
                command = new addRectangle(paint, Integer.parseInt(commandeString[2]),
                        Integer.parseInt(commandeString[3]),
                        Integer.parseInt(commandeString[4]) + 1,
                        Integer.parseInt(commandeString[5]) + 1,
                        commandeString[6].charAt(0));
                manageCommande.execute(command);
                break;
            case "square":
                command = new addSquare(paint, Integer.parseInt(commandeString[2]),
                        Integer.parseInt(commandeString[3]),
                        Integer.parseInt(commandeString[4]) + 1,
                        commandeString[5].charAt(0));
                manageCommande.execute(command);
                break;
            case "line":
                command = new addLine(paint, Integer.parseInt(commandeString[2]),
                        Integer.parseInt(commandeString[3]),
                        Integer.parseInt(commandeString[4]),
                        Integer.parseInt(commandeString[5]),
                        commandeString[6].charAt(0));
                manageCommande.execute(command);
        }
    }
}
