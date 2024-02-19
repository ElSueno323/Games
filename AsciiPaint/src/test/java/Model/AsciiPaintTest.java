/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model; //@srv : package

import g54720.atl.ascii.model.Point;
import g54720.atl.ascii.model.AsciiPaint;
import g54720.atl.ascii.model.Shape;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public class AsciiPaintTest {
    
    public AsciiPaintTest() {
    }

    /**
     * Test of newCircle method, of class AsciiPaint.
     */
    @Test
    public void testNewCircle() {
        System.out.println("newCircle");
        int x = 0;
        int y = 0;
        double radius = 0.0;
        char color = ' ';
        AsciiPaint instance = new AsciiPaint();
        instance.newCircle(x, y, radius, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newRectangle method, of class AsciiPaint.
     */
    @Test
    public void testNewRectangle() {
        System.out.println("newRectangle");
        int x = 0;
        int y = 0;
        double width = 0.0;
        double height = 0.0;
        char color = ' ';
        AsciiPaint instance = new AsciiPaint();
        instance.newRectangle(x, y, width, height, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newSquare method, of class AsciiPaint.
     */
    @Test
    public void testNewSquare() {
        System.out.println("newSquare");
        int x = 0;
        int y = 0;
        double side = 0.0;
        char color = ' ';
        AsciiPaint instance = new AsciiPaint();
        instance.newSquare(x, y, side, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class AsciiPaint.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        AsciiPaint instance = new AsciiPaint();
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class AsciiPaint.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        AsciiPaint instance = new AsciiPaint();
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShapeAt method, of class AsciiPaint.
     */
    @Test
    public void testGetShapeAt() {
        System.out.println("getShapeAt");
        Point p = null;
        AsciiPaint instance = new AsciiPaint();
        Shape expResult = null;
        Shape result = instance.getShapeAt(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

