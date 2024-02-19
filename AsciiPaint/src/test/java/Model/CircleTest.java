/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import g54720.atl.ascii.model.Point;
import g54720.atl.ascii.model.Circle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public class CircleTest {
    
    public CircleTest() {
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double dx = 0.0;
        double dy = 0.0;
        Circle instance = null;
        instance.move(dx, dy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IsInside method, of class Circle.
     */
    @Test
    public void testIsInside() {
        System.out.println("IsInside");
        Point p = null;
        Circle instance = null;
        boolean expResult = false;
        boolean result = instance.IsInside(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

