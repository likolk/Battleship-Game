package model;



import static model.ShipType.CARRIER;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CruiserTest.
 *
 * @author kelvin.likollari@usi.ch
 */
public class CruiserTest
{
    /**
     * Default constructor for test class CruiserTest
     */
    public CruiserTest()
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

    @Test
    public void testGetCruiserType() {
        int len = 3;
        assertEquals("cruiser", new Cruiser(len).getShipType());
    }

    @Test
    public void testGetCarrierType() {
        int len = 5;
        assertEquals("carrier", new Carrier(len).getShipType());
    }

    @Test
    public void testGetSubmarineType() {
        int len = 3;
        assertEquals("submarine", new Submarine(len).getShipType());
    }

    @Test
    public void testCruiser() {
        Cruiser c = new Cruiser(3, 3, 3, false, false, false, false);
        assertEquals(3, c.getSize());
        assertEquals(3, c.getPositionX());
        assertEquals(3, c.getPositionY());
    }
}
