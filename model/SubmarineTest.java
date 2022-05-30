package model;



import static model.ShipType.CARRIER;
import static model.ShipType.SUBMARINE;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class SubmarineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SubmarineTest
{
    /**
     * Default constructor for test class SubmarineTest
     */
    public SubmarineTest()
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
    public void testGetTypeSubMarine()
    {
        int len = 3;
        assertEquals("submarine", new Submarine(len).getShipType());
    }
}
