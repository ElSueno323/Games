package g54720.atl.samegame.model;

import g54720.atl.samegame.util.Observers.Observable;
import g54720.atl.samegame.util.Observers.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Create the façade of the model
 *
 * @author g54720
 */
public class Model implements Observable {

    private final List<Observer> observers = new ArrayList<>();
    private boolean startGame = false;
    private boolean endGame;
    private final Board board;
    private int score;
    private int hitscore;
    private final int HEIGHT_DEFAULT = 5;
    private final int WIDTH_DEFAULT = 5;
    private final int LEVEL_DEFAULT = 5;
    private int level;

    /**
     * Constructor of Model with argument . Create a board with a choose level.
     *
     */
    public Model() {
        board = new Board(HEIGHT_DEFAULT, WIDTH_DEFAULT, LEVEL_DEFAULT);
        level=LEVEL_DEFAULT;
    }

    /**
     * Start a game with a level and size of array of bead.
     *
     * @param level a integer, number of different color.
     * @param widht a integer, the widht of the array of bead.
     * @param height a integer, the height of array of bead.
     */
    public void start(int level, int widht, int height) {
        if (startGame) {
            throw new IllegalStateException("game already start");
        }
        this.level=level;
        startGame = true;
        endGame = false;
        score = 0;
        hitscore = 0;
        board.createBeads(height, widht, level);
        notify("start");
    }

    /**
     * Play a move with a position. Hit bead and takes down the balls and
     * crushes them to the left.
     *
     * @param position a Position, the position of selected bead.
     */
    public void play(Position position) {
        if (!startGame) {
            throw new IllegalStateException("game not start");
        }
        int hit = board.selectBeads(position.getX(), position.getY());
        hitscore = hit * (hit - 1);
        board.bellowBeads();
        board.moveLeft();
        score = score + hitscore;
        notify("click");
    }

    /**
     * Give up the game.Re-start;
     */
    public void giveUp() {
        if (!startGame) {
            throw new IllegalStateException("game not started");
        }
        endGame = false;
        startGame = false;
        notify("giveup");
    }

    /**
     * Get a copy of the boards.
     *
     * @return a board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Get if the game started .
     *
     * @return a boolean
     */
    public boolean isStartGame() {
        return startGame;
    }

    /**
     * Cancel the last move.
     *
     * @param oldbeads array of beads, the last array of beads.
     * @param oldscore a int, the last score.
     */
    public void undoMove(Bead[][] oldbeads, int oldscore) {
        if (!startGame) {
            throw new IllegalStateException("game not started");
        }
        board.undoBeads(oldbeads);
        score = oldscore;
        notify("undo");
    }

    /**
     * Get the level of the board.
     *
     * @return a integer, the level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Get the actual move's socre.
     *
     * @return a integer, the score.
     */
    public int getHitscore() {
        return hitscore;
    }

    /**
     * Check if the game is blocked.
     *
     * @return a boolean,true if the game is blocked.
     */
    public boolean isBlocked() {
        return endGame = board.isBlocked();
    }

    /**
     * Check if the baord is empty.
     *
     * @return a boolean.
     */
    public boolean isEmpty() {
        return endGame = board.isEmpty();
    }

    /**
     * Get the score of the player.
     *
     * @return a integer the score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Give the list of position of all beads around a give position with the
     * same color.
     *
     * @param x a integer, abscissa of position.
     * @param y a integer, ordinate of position.
     * @return a list of position.
     */
    public List<Position> hoverVisted(int x, int y) {
        return board.hoverVisted(x, y);
    }

    @Override
    public void subscribe(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    /**
     * Notify for all observer, and call his update.
     *
     * @param message a string.
     */
    private void notify(String message) {
        observers.forEach(observer -> {
            observer.update(message);
        });
    }
}












