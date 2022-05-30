package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CoordinatesTest.
 *
 * @author Kelvin Likollari & Ilker Kaymak
 */
public class CoordinatesTest
{
    /**
     * Default constructor for test class CoordinatesTest
     */
    public CoordinatesTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }


    /**
     * Test of getX method, of class Coordinates.
     */
    @Test
    public void testGetX()
    {
        Coordinates instance = new Coordinates(0, 0);
        assertEquals(0, instance.getX());
    }

    /**
     * Test of getY method, of class Coordinates.
     */
    @Test
    public void testGetY()
    {
        Coordinates instance = new Coordinates(0, 0);
        assertEquals(0, instance.getY());
    }

    /**
     * Test of setX method, of class Coordinates.
     */
    @Test
    public void testSetX() {
        int x = 5;
        Coordinates instance = new Coordinates(0, 0);
        instance.setX(x);
        assertEquals(x, instance.getX());
    }

    /**
     * Test of setY method, of class Coordinates.
     */
    @Test
    public void testSetY() {
        int y = 5;
        Coordinates instance = new Coordinates(0, 0);
        instance.setY(y);
        assertEquals(y, instance.getY());
    }

    /**
     * Test of equals method, of class Coordinates.
     */
    @Test
    public void testEquals()
    {
        Coordinates instance1 = new Coordinates(5, 5);
        Coordinates instance2 = new Coordinates(5, 5);
        assertTrue(instance1.equals(instance2));
    }

    /**
     * Test of equals method, of class Coordinates.
     */
    @Test
    public void testEquals1()
    {
        Coordinates instance1 = new Coordinates(0, 5);
        Coordinates instance2 = new Coordinates(5, 0);
        assertFalse(instance1.equals(instance2));
    }

    /**
     * Test of reset method, of class Coordinates.
     */
    @Test
    public void testReset()
    {
        Coordinates instance = new Coordinates(5, 5);
        instance.resetCoordinates();
        assertEquals(0, instance.getX());
        assertEquals(0, instance.getY());
    }

    /**
     * Test of reset method, of class Coordinates.
     */
    @Test
    public void testReset1()
    {
        Coordinates instance = new Coordinates(0, 0);
        instance.resetCoordinates();
        assertEquals(0, instance.getX());
        assertEquals(0, instance.getY());
    }

    /**
     * Test of toString method, of class Coordinates.
     */
    @Test
    public void testToString()
    {
        Coordinates instance = new Coordinates(5, 5);
        assertEquals("(5,5)", instance.toString());
    }
}
