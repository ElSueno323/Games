package g54720.atl.samegame.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Create the board of the beads.
 *
 * @author g54720
 */
public class Board {

    private Bead[][] beads;
    private final int maxHeight = 21;

    private final int minHeight = 5;
    private final int maxWidth = 22;

    private final int minWidth = 5;
    private final int LVL_MIN = 3;
    private final int LVL_MAX = 5;
    private int hitBean = 0;

    /**
     * Constructor of the board. Create a board with all beads in the array 2d.
     *
     * @param height a integer, the height of the board.
     * @param width a integer , the width of the board.
     * @param level a integer , the level of the beads.
     */
    Board(int height, int width, int level) {
        if (height < minHeight || height > maxHeight
                || width < minWidth || width > maxWidth) {
            throw new IllegalArgumentException("length and width not correct");
        }
        if (level < LVL_MIN || level > LVL_MAX) {
            throw new IllegalArgumentException("Choose level not correct");
        }
        createBeads(height, width, level);
    }

    /**
     * Constructor of board ,with a arra of beads in parameter.Only for TEST
     *
     * @param beads array of bead.
     */
    protected Board(Bead[][] beads) {
        this.beads = beads;
    }

    /**
     * Get the max height of the board.
     *
     * @return a integer , the height max.
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    /**
     * Get the max width of the board.
     *
     * @return a integer, the width max.
     */
    public int getMaxWidth() {
        return maxWidth;
    }

    /**
     * Create a array of array with full of bean.
     *
     * @param height a integer , the height of the array of array of bead.
     * @param width a integer , the width of the array of array of bead.
     */
    void createBeads(int height, int width, int level) {
        if (height < minHeight || height > maxHeight
                || width < minWidth || width > maxWidth) {
            throw new IllegalArgumentException("length and width not correct");
        }
        if (level < LVL_MIN || level > LVL_MAX) {
            throw new IllegalArgumentException("Choose level not correct");
        }

        beads = new Bead[height][width];
        for (int i = 0; i < beads.length; i++) {
            for (int j = 0; j < beads[i].length; j++) {
                int colo = (int) (Math.random() * level) + 1;
                Bead newbead;
                switch (colo) {
                    case 1 -> {
                        newbead = new Bead(new Position(i, j), Color.CYAN);
                        beads[i][j] = newbead;
                    }
                    case 2 -> {
                        newbead = new Bead(new Position(i, j), Color.GREEN);
                        beads[i][j] = newbead;
                    }
                    case 3 -> {
                        newbead = new Bead(new Position(i, j), Color.RED);
                        beads[i][j] = newbead;
                    }
                    case 4 -> {
                        newbead = new Bead(new Position(i, j), Color.VIOLET);
                        beads[i][j] = newbead;
                    }
                    case 5 -> {
                        newbead = new Bead(new Position(i, j), Color.ORANGE);
                        beads[i][j] = newbead;
                    }
                }
            }
        }
    }

    /**
     * Get the board of the beads.
     *
     * @return a array of Beads.
     */
    public Bead[][] getBeads() {
        Bead[][] copy = new Bead[beads.length][beads[0].length];
        for (int x = 0; x < beads.length; x++) {
            for (int y = 0; y < beads[0].length; y++) {
                copy[x][y] = beads[x][y] == null ? null : new Bead(beads[x][y]);
            }
        }
        return copy;
    }

    /**
     * Give the color of the select bead.
     *
     * @param position a position, the position of select bead.
     * @return a color , the color of the bead.
     */
    public Color getBeadAt(Position position) {
        if (position.getX() < 0 || position.getX() >= beads.length
                || position.getY() < 0 || position.getY() >= beads[0].length) {
            throw new IllegalArgumentException(
                    "The position is outside the board.");
        }
        return beads[position.getX()][position.getY()].getColor();
    }

    /**
     * Change the actual score with the old score and change the actual array of
     * beads with the old array of beads.
     *
     * @param oldbeads a array of beads.
     */
    void undoBeads(Bead[][] oldbeads) {
        if (oldbeads.length != beads.length
                && oldbeads[0].length != beads[0].length) {
            throw new IllegalArgumentException(
                    "the array do not have the same size");
        }
        beads = oldbeads;
    }

    /**
     * Search if the area of the beads with same color with the abscica and
     * ordinate and change the array of boolean visited. And remove all of beads
     * in in the same position of array visited.
     *
     * @param x a integer, ordinate of a array .
     * @param y a integer ,abscissa of a array.
     */
    int selectBeads(int x, int y) {
        if (x < 0 || x >= beads.length || y < 0 || y >= beads[0].length) {
            throw new IllegalArgumentException(" a position not correct");
        }
        boolean[][] visited = new boolean[beads.length][beads[0].length];

        if (beads[x][y] != null) {
            searchColor(x, y, beads[x][y].getColor(), visited);
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[i].length; j++) {
                    if (visited[i][j]) {
                        beads[i][j] = null;
                        visited[i][j] = false;
                    }
                }
            }
        }
        int copy = hitBean - 2;
        hitBean = 0;
        return copy;
    }

    /**
     * Search if the color as in the area.
     *
     * @param x a integer, a ordinate of a position on the board of beads.
     * @param y a integer, a abscica of a position on the board of beads.
     * @param color a Color , of the bead.
     * @return a boolean false if out side of board or the color is not the same
     * or if the position already visited.
     */
    boolean searchColor(int x, int y, Color color, boolean[][] visited) {
        boolean hitMoreone = false;
        if (x < 0 || x >= beads.length || y < 0 || y >= beads[0].length) {
            return false;
        }
        if (beads[x][y] == null) {
            return false;
        }
        if (beads[x][y].getColor() != color) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (hitBean > 1) {
            hitMoreone = true;
            visited[x][y] = true;
        }
        hitBean++;
        return searchColor(x + 1, y, color, visited)
                || searchColor(x - 1, y, color, visited)
                || searchColor(x, y + 1, color, visited)
                || searchColor(x, y - 1, color, visited) && hitMoreone;
    }

    /**
     * Check if the game is win.
     *
     * @return true if there are no more bead.
     */
    boolean isEmpty() {
        for (Bead[] beadTab : beads) {
            for (Bead beadXY : beadTab) {
                if (beadXY != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if the board is blocked and no move is possible.
     *
     * @return a boolean,true if no one beads have same color of it's neighboor.
     */
    boolean isBlocked() {
        for (int x = 0; x < beads.length; x++) {
            for (int y = 0; y < beads[x].length; y++) {
                if (beads[x][y] != null) {
                    if (Block(x, y)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Check if the game is block and return it.
     *
     * @param x a integer, a ordinate of a position on the board of beads.
     * @param y a integer, a abscica of a position on the board of beads.
     * @return a booleand
     */
    boolean Block(int x, int y) {
        return 0 <= x - 1 && beads[x - 1][y] != null
                && beads[x][y].getColor().equals(beads[x - 1][y].getColor())
                || (0 <= y - 1 && beads[x][y - 1] != null
                && beads[x][y].getColor().equals(beads[x][y - 1].getColor()))
                || x + 1 > beads.length && beads[x + 1][y] != null
                && beads[x][y].getColor().equals(beads[x + 1][y].getColor())
                || y + 1 > beads[x].length && beads[x][y + 1] != null
                && beads[x][y].getColor().equals(beads[x][y + 1].getColor());

    }

    /**
     * Lists the bead's positions with the same colour side by side.
     *
     * @param x a integer , the ordinate of position
     * @param y a integer , the asbcisa of position
     * @return a list of position.
     */
    List<Position> hoverVisted(int x, int y) {
        if (x < 0 || x >= beads.length || y < 0 || y >= beads[0].length) {
            throw new IllegalArgumentException(" Invalide position");
        }
        boolean[][] visited = new boolean[beads.length][beads[0].length];
        List<Position> listPos = new ArrayList<>();
        if (beads[x][y] != null) {
            int oldhitBean = hitBean;
            searchColor(x, y, beads[x][y].getColor(), visited);
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[0].length; j++) {
                    if (visited[i][j] == true) {
                        listPos.add(new Position(i, j));
                    }
                }
            }
            hitBean = oldhitBean;
        }
        return listPos;
    }

    /**
     * When a bead is on top of an empty case, it throws it away.
     *
     */
    void bellowBeads() {
        for (int x = 0; x < beads.length; x++) {
            for (int y = 0; y < beads[x].length; y++) {
                if (x + 1 < beads.length && beads[x][y] != null
                        && beads[x + 1][y] == null) {
                    beads[x + 1][y] = beads[x][y];
                    beads[x][y] = null;
                    x = 0;
                    if (y == 0) {
                        y = -1;
                    } else {
                        y = 0;
                    }
                }
            }
        }
    }

    /**
     * When a column is empty check if you have to move the column to its right
     */
    void moveLeft() {
        while (rightCol()) {
            for (int y = 0; y < beads[0].length - 1; y++) {
                if (beads[beads.length - 1][y] == null) {
                    for (Bead[] bead : beads) {
                        bead[y] = bead[y + 1];
                        bead[y + 1] = null;
                    }
                }
            }
        }
    }

    /**
     * Check if there is still an empty column
     *
     * @return true if have a column empty between column not empty.
     */
    boolean rightCol() {
        for (int y = 0; y < beads[0].length - 1; y++) {
            if (y != 0) {
                if (beads[beads.length - 1][y] == null
                        && beads[beads.length - 1][y + 1] != null) {
                    return true;
                }
            }
        }
        return false;
    }
}

