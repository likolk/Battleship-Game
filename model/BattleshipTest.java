package model;



import static model.ShipType.CARRIER;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class BattleshipTest.
 *
 * @author kelvin.likollari@usi.ch
 */
public class BattleshipTest
{
    /**
     * Default constructor for test class BattleshipTest
     */
    public BattleshipTest()
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
    public void testGetShipType()
    {
        int len = 2;
        assertEquals("battleship", new Battleship(len).getShipType());
    }


}
