package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DisplayFieldTest.
 *
 * @author kelvin.likollari@usi.ch
 */
public class DisplayFieldTest
{
    /**
     * Default constructor for test class DisplayFieldTest
     */
    public DisplayFieldTest()
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
    public void testDisplayField()
    {
        int row = 1;
        int col = 1;
        DisplayField df = new DisplayField(row, col);
        assertEquals(row, df.getRow());
        assertEquals(col, df.getCol());
    }

}
