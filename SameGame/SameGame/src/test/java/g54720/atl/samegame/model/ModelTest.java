package g54720.atl.samegame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author g54720
 */
public class ModelTest {

    public ModelTest() {
    }

    /**
     * Test of start method with a too big widht, of class Model.
     */
    @Test
    public void testStart_Start_with_widht_too_big() {
        System.out.println("Start_with_widht_too_big");
        Model model = new Model();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    model.start(3, 100, 5);
                });
    }

    /**
     * Test of start method with a too small widht, of class Model.
     */
    @Test
    public void testStart_Start_with_widht_too_small() {
        System.out.println("Start_with_widht_too_small");
        Model model = new Model();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    model.start(3, -1, 5);
                });
    }

    /**
     * Test of start method with a too big height, of class Model.
     */
    @Test
    public void testStart_Start_with_height_too_big() {
        System.out.println("Start_with_height_too_big");
        Model model = new Model();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    model.start(3, 5, 100);
                });
    }

    /**
     * Test of start method with a too small height, of class Model.
     */
    @Test
    public void testStart_Start_with_height_too_small() {
        System.out.println("Start_with_height_too_small");
        Model model = new Model();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    model.start(3, 5, -5);
                });
    }

    /**
     * Test of start method with a too small level, of class Model.
     */
    @Test
    public void testStart_Start_with_level_too_small() {
        System.out.println("Start_with_level_too_small");
        Model model = new Model();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    model.start(-3, 5, 5);
                });
    }

    /**
     * Test of start method with a too small level, of class Model.
     */
    @Test
    public void testStart_Start_with_level_too_big() {
        System.out.println("Start_with_level_too_big");
        Model model = new Model();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    model.start(100, 5, 5);
                });
    }

    /**
     * Test of play method before start a game, of class Model.
     */
    @Test
    public void testPlay_play_before_start() {
        System.out.println("play_before_start");
        Model model = new Model();
        Assertions.assertThrows(IllegalStateException.class,
                () -> {
                    model.play(new Position(0, 0));
                });
    }

    /**
     * Test of play method with invalide position, of class Model.
     */
    @Test
    public void testPlay_invalide_position() {
        System.out.println("play_invalide_position");
        Model model = new Model();
        model.start(3, 5, 5);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    model.play(new Position(6, 4));
                });
    }

    /**
     * Test of giveUp method before start a party, of class Model.
     */
    @Test
    public void testGiveUp_before_start() {
        System.out.println("GiveUp_before_start");
        Model instance = new Model();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            instance.giveUp();
        });
    }

    /**
     * Test of undoMove method before start a game, of class Model.
     */
    @Test
    public void testUndoMove_before_start() {
        System.out.println("GiveUp_before_start");
        Model instance = new Model();
        Bead[][] oldbeads = new Bead[5][5];
        Assertions.assertThrows(IllegalStateException.class,
                () -> {
                    instance.undoMove(oldbeads, 0);
                });
    }

    /**
     * Test of undoMove method with a invalid arguement of aaray of beads, of
     * class Model.
     */
    @Test
    public void testUndoMove_invalide_array_of_beads_start() {
        System.out.println("GiveUp_before_start");
        Model instance = new Model();
        instance.start(3, 5, 5);
        Bead[][] oldbeads = new Bead[6][6];
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    instance.undoMove(oldbeads, 0);
                });
    }

    /**
     * Test of hoverVisted method with a invalide position, of class Model.
     */
    @Test
    public void testHoverVisted_invalide_position() {
        System.out.println("HoverVisted_invalide_position");
        Model instance = new Model();
        instance.start(3, 5, 5);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    instance.hoverVisted(6, 0);
                });
    }
}


