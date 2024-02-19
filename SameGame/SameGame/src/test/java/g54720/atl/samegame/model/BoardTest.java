package g54720.atl.samegame.model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author g54720
 */
public class BoardTest {

    public BoardTest() {
    }

    private Bead[][] createBeads(int size) {
        Bead[][] beads = new Bead[size][size];
        for (int i = 0; i < beads.length; i++) {
            for (int j = 0; j < beads[i].length; j++) {
                switch (j % 5) {
                    case 0:
                        beads[i][j] = new Bead(new Position(i, j), Color.CYAN);
                        break;
                    case 1:
                        beads[i][j] = new Bead(new Position(i, j), Color.GREEN);
                        break;
                    case 2:
                        beads[i][j] = new Bead(new Position(i, j), Color.ORANGE);
                        break;
                    case 3:
                        beads[i][j] = new Bead(new Position(i, j), Color.RED);
                        break;
                    case 4:
                        beads[i][j] = new Bead(new Position(i, j), Color.VIOLET);
                        break;
                }
            }
        }
        return beads;
    }

    /**
     * Test of create a board with a height of 2, of class Board.
     */
    @Test
    public void testBoard_less_than_Min_Height() {
        System.out.println("testBoard_Less_than_Min_Height");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(2, 5, 3);
                });
    }

    /**
     * Test of create a board with a height of 100, of class Board.
     */
    @Test
    public void testBoard_More_than_Max_Height() {
        System.out.println("testBoard_More_than_Max_Height");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(100, 5, 3);
                });
    }

    /**
     * Test of create a board with a width of 2, of class Board.
     */
    @Test
    public void testBoard_less_than_Min_Width() {
        System.out.println("testBoard_less_than_Min_Width");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 2, 3);
                });
    }

    /**
     * Test of create a board with a width of 100, of class Board.
     */
    @Test
    public void testBoard_More_than_Max_Width() {
        System.out.println("testBoard_More_than_Max_Width");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 100, 3);
                });
    }

    /**
     * Test of create a board with a level of 1, of class Board.
     */
    @Test
    public void testBoard_less_than_LVL_MIN() {
        System.out.println("testBoard_less_than_LVL_MIN");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 5, 1);
                });
    }

    /**
     * Test of create a board with a level of 10, of class Board.
     */
    @Test
    public void testBoard_more_than_LVL_MAX() {
        System.out.println("testBoard_more_than_LVL_MAX");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 5, 10);
                });
    }

    /**
     * Test of createBeads a board with a height of 2, of class Board.
     */
    @Test
    public void testBoard_createBeads_less_than_Min_Height() {
        System.out.println("createBeads_less_than_Min_Height");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 5, 3);
                    x.createBeads(-1, 5, 3);
                });
    }

    /**
     * Test of createBeads with a height of 100, of class Board.
     */
    @Test
    public void testBoard_createBeads_More_than_Max_Height() {
        System.out.println("createBeads_More_than_Max_Height");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 5, 3);
                    x.createBeads(100, 5, 3);
                });
    }

    /**
     * Test of createBeads with a width of 2, of class Board.
     */
    @Test
    public void testBoard_createBeads_less_than_Min_Width() {
        System.out.println("createBeads_less_than_Min_Width");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 5, 3);
                    x.createBeads(5, -1, 3);
                });
    }

    /**
     * Test of createBeads with a width of 100, of class Board.
     */
    @Test
    public void testBoard_createBeads_More_than_Max_Width() {
        System.out.println("createBeads_More_than_Max_Width");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 5, 3);
                    x.createBeads(5, 100, 3);
                });
    }

    /**
     * Test of createBeads with a level of 1, of class Board.
     */
    @Test
    public void testBoard_createBeads_less_than_LVL_MIN() {
        System.out.println("createBeads_less_than_LVL_MIN");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 5, 3);
                    x.createBeads(5, 5, 1);
                });
    }

    /**
     * Test of createBeads with a level of 10, of class Board.
     */
    @Test
    public void testBoard_createBeads_more_than_LVL_MAX() {
        System.out.println("createBeads_more_than_LVL_MAX");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board x = new Board(5, 5, 3);
                    x.createBeads(5, 5, 10);
                });
    }

    /**
     * Test of getBeadAt with of a position outside, of class Board.
     */
    @Test
    public void testBoard_getBeatAt_a_position_X_outside_of_the_board_() {
        System.out.println("getBeatAt_a_position_X_outside_of_the_board");
        Board test = new Board(5, 5, 3);
        Position outside = new Position(25, 0);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    test.getBeadAt(outside);
                });
    }

    /**
     * Test of getBeadAt with of a position outside, of class Board.
     */
    @Test
    public void testBoard_getBeatAt_a_position_Y_outside_of_the_board_() {
        System.out.println("getBeatAt_a_position_Y_outside_of_the_board");
        Board test = new Board(5, 5, 3);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    test.getBeadAt(new Position(0, 25));
                });
    }

    /**
     * Test of getBeadAt with of a correctly position, of class Board.
     */
    @Test
    public void testBoard_getBeatAt_Operates_test() {
        System.out.println("getBeatAt_Operates_test");
        Board test = new Board(5, 5, 3);
        assertEquals(test.getBeadAt(new Position(0, 0)), test.getBeads()[0][0].getColor());
    }

    /**
     * Test of undoBeads with a incorect array with a different size, of class
     * Board.
     */
    @Test
    public void testBoard_undoBeads_size_different_test() {
        System.out.println("undoBeads_size_different_test");
        Board test = new Board(5, 5, 3);
        Bead[][] newBead = new Bead[12][12];
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    test.undoBeads(newBead);
                });
    }

    /**
     * Test of selectBeads with a incorect position, of class Board.
     */
    @Test
    public void testBoard_selectBeads_incorrect_position() {
        System.out.println("selectBeads_incorrect_position");
        Board test = new Board(5, 5, 3);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    test.selectBeads(5, 5);
                });
    }

    /**
     * Test of selectBeads correct return, of class Board.
     */
    @Test
    public void testBoard_selectBeads_Correct_hit() {
        System.out.println("selectBeads_correct_hit");
        Bead[][] test = createBeads(5);
        Board board = new Board(test);
        int point = board.selectBeads(1, 0);
        int egals = 5;
        assertEquals(point, egals);
    }

    /**
     * Test if the select bead is clean.
     */
    @Test
    public void testBoard_selectBeads_correct_clean() {
        System.out.println("selectBeads_correct_clean");
        Bead[][] test = createBeads(5);
        Board board = new Board(test);
        board.selectBeads(0, 0);
        boolean empty = true;
        for (Bead[] test1 : test) {
            if (test1[0] != null) {
                empty = false;
            }
        }
        assertEquals(empty, true);
    }

    /**
     * Test searchColor check if the colone of a position has selected.
     */
    @Test
    public void testBoard_searchColor_if_has_colonne_of_same_color() {
        System.out.println("searchColor_if_has_colonne_of_same_color");
        Bead[][] test = createBeads(5);
        Board board = new Board(test);
        Position pos = new Position(0, 0);
        Color col = board.getBeadAt(pos);
        boolean[][] bol = new boolean[test.length][test[0].length];
        boolean[][] bolcpy = new boolean[test.length][test[0].length];
        for (int i = 0; i < bol.length; i++) {
            for (int j = 0; j < bol.length; j++) {
                bolcpy[i][j] = bol[i][j];
            }
        }
        boolean same = true;
        board.searchColor(0, 0, col, bol);
        for (boolean[] bol1 : bol) {
            if (bol[pos.getX()][pos.getY()] == bolcpy[pos.getX()][pos.getY()]) {
                same = false;
            }
        }
        assertEquals(true, same);
    }

    /**
     * Test moveLeft if he move 3 column to left.
     */
    @Test
    public void testBoard_moveLeft_3_colonnes() {
        System.out.println("moveLeft_3_colonnes");
        Bead[][] test = createBeads(10);
        Board board = new Board(test);
        board.selectBeads(0, 1);
        board.selectBeads(0, 2);
        board.selectBeads(0, 3);
        board.moveLeft();
        String g = "";
        for (Bead[] test1 : test) {
            for (int j = 0; j < test.length; j++) {
                if (test1[j] != null) {
                    g = g + "o ";
                } else {
                    g = g + "x ";
                }
            }
            g = g + "\n";
        }
        //System.out.println(g);
        assertEquals(false, board.rightCol());
    }

    /**
     * Test hoverVisted when the position is incorrect.
     */
    @Test
    public void testBoard_hoverVisted_invalide_position() {
        System.out.println("hoverVisted_invalide_position");
        Bead[][] test = createBeads(5);
        Board board = new Board(test);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    board.hoverVisted(5, 0);
                });
    }
}






