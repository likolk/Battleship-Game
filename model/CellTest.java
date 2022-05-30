package model;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class CellTest.
 *
 * @author kelvin.likollari@usi.ch
 */
public class CellTest
{
    /**
     * Default constructor for test class CellTest
     */
    public CellTest()
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
    public void testGetCellNumber() {
        Cell cell = new Cell(1);
        assertEquals(1, cell.getCellNumber());
    }

    @Test
    public void testIsOccupied() {
        Cell cell = new Cell(1);
        assertFalse(cell.isOccupied());
    }

    @Test
    public void testSetOccupied() {
        Cell cell = new Cell(1);
        cell.setOccupied(true);
        assertTrue(cell.isOccupied());
    }

    @Test
    public void testIsHit() {
        Cell cell = new Cell(1);
        assertFalse(cell.isHit());
    }

    @Test
    public void testSetHit() {
        Cell cell = new Cell(1);
        cell.setHit();
        assertTrue(cell.isHit());
    }
    // TODO: Finish with the rest of the tests


}
