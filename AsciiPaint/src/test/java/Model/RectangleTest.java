/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import g54720.atl.ascii.model.Point;
import g54720.atl.ascii.model.Rectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public class RectangleTest {
    
    public RectangleTest() {
    }

    /**
     * Test of IsInside method, of class Rectangle.
     */
    @Test
    public void testIsInside() {
        System.out.println("IsInside");
        Point p = new Point(4,5);
        Rectangle instance = new Rectangle(new Point(3,1), 9, 10, 'f');
        boolean result = instance.IsInside(p);
        assertEquals(true, instance.IsInside(p));
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double dx = 0.0;
        double dy = 0.0;
        Rectangle instance = null;
        instance.move(dx, dy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

