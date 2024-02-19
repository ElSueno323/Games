/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import g54720.atl.ascii.model.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g54720
 */
public class PointTest {
    
    public PointTest() {
    }

    /**
     * Test of move method, of class Point.
     */
    @Test
    public void test_methode_Move() {
        double dx = 3.0;
        double dy = 4.0;
        Point instance = new Point(dx,dy);
        instance.move(dx, dy);
        System.out.println(instance.getX()+" "+instance.getY());
        assertEquals(instance.distanceTo(new Point(dx*2,dy*2)),0 );
    }

    /**
     * Test of distanceTo method, of class Point.
     */
    @Test
    public void test_methode_Distance_To() {
        Point other = new Point(5,5);
        Point instance = new Point(0,0);
        double disyance =instance.distanceTo(other);
        assertEquals(instance.distanceTo(other),disyance);
    }

    
}














