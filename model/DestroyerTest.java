package model;



import static model.ShipType.CARRIER;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class DestroyerTest.
 *
 * @author kelvin.likollari@usi.ch
 */
public class DestroyerTest
{
    /**
     * Default constructor for test class DestroyerTest
     */
    public DestroyerTest()
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
    public void testGetTypeDestroyer()
    {
        int len = 3;
        assertEquals("destroyer", new Destroyer(len).getShipType());
    }
}
