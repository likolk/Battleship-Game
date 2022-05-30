package model;


import static model.ShipType.CARRIER;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The test class ResettedGridTest.
 *
 * @author kelvin.likollari@usi.ch
 */
public class ResettedGridTest
{
    /**
     * Default constructor for test class ResettedGridTest
     */
    public ResettedGridTest()
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
    public void testResettedGrid() {
        // should return carrier
        int len = 0;
        assertEquals("empty", new ResettedGrid(len).getShipType());
    }

}
