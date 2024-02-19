/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import g54720.atl.ascii.model.Drawing;
import g54720.atl.ascii.model.Point;
import g54720.atl.ascii.model.Shape;
import g54720.atl.ascii.model.Circle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g54720
 */
public class DrawingTest {

    /**
     * Test of addShape method, of class Drawing.
     */
    @Test
    public void testAddShape() {
        Drawing draw = new Drawing();
        Circle test = new Circle(new Point(0, 2), 4, 'f');
        draw.addShape(test);
        assertEquals(draw.getShapeAT(new Point(0, 2)), test);

    }

    /**
     * Test of getShapeAT method, of class Drawing.
     */
    @Test
    public void testGetShapeAT() {
        System.out.println("getShapeAT");
        Point p = null;
        Drawing instance = new Drawing();
        Shape expResult = null;
        Shape result = instance.getShapeAT(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
