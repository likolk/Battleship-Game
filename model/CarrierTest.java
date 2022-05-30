package model;



import static model.ShipType.CARRIER;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class CarrierTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CarrierTest
{
    /**
     * Default constructor for test class CarrierTest
     */
    public CarrierTest()
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
    public void testGetShipType() {
        // should return carrier
        int len = 5;
        assertEquals("carrier", new Carrier(len).getShipType());
    }

}
