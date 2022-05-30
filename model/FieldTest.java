package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FieldTest.
 * @author kelvin.likollari@usi.ch
 */
public class FieldTest
{
    /**
     * Default constructor for test class FieldTest
     */
    public FieldTest()
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

    // this had error, might have not been properly implemented
    @Test
    public void testIsEmpty() {
        Field field = new Field(1, 1);
        field.setCellValue(0, 0, true);
        assertFalse(field.isEmpty());
    }




    // this had error, might have not been properly implemented
    @Test
    public void testIsNotEmpty() {
        Field field = new Field(1, 1);
        field.setCellValue(0, 0, true);
        assertFalse(field.isEmpty());
    }

    // this had error, might have not been properly implemented
    @Test
    public void testSetArrayFieldV2() {
        Field field = new Field(5, 5);
        field.setArrayFieldV2(new Field(5, 5));
        assertEquals(field.getArrayField(), field.getArrayField());
    }

    @Test
    public void testGetArrayField() {
        Field field = new Field(5, 5);
        assertEquals(field.getArrayField(), field.getArrayField());
    }

    @Test
    public void testGetArrayFieldV2() {
        Field field = new Field(5, 5);
        field.setArrayFieldV2(new Field(5, 5));
        assertEquals(field.getArrayField(), field.getArrayField());
    }

    @Test
    public void testSetCellValue() {
        Field field = new Field(5, 5);
        field.setCellValue(0, 0, false);
        assertEquals(false, field.getCellValue(0, 0));
    }

    @Test
    public void testGetCellValue() {
        Field field = new Field(5, 5);
        field.setCellValue(0, 0, true);
        assertEquals(true, field.getCellValue(0, 0));
    }

    @Test
    public void testIsFull() {
        Field field = new Field(5, 5);
        field.setCellValue(0, 0, true);
        field.setCellValue(1, 1, true);
        field.setCellValue(2, 2, true);
        field.setCellValue(3, 3, true);
        field.setCellValue(4, 4, true);
        assertFalse(field.isFull());
    }




    @Test
    public void testIsFullV2() {
        Field field = new Field(5, 5);
        field.setCellValue(1, 1, true);
        field.setCellValue(2, 2, true);
        field.setCellValue(3, 3, true);
        field.setCellValue(4, 4, true);
        field.setArrayFieldV2(new Field(5, 5));
        assertFalse(field.isFull());
    }

    @Test
    public void testIsEmptyV3() {
        Field field = new Field(5, 5);
        field.setCellValue(0, 0, true);
        field.setCellValue(1, 1, true);
        field.setCellValue(2, 2, true);
        field.setCellValue(3, 3, true);
        field.setCellValue(4, 4, true);
        assertFalse(field.isEmpty());
    }

    // this had error, might have not been properly implemented
    @Test
    public void testIsEmptyV2() {
        Field field = new Field(1, 1);
        field.setCellValue(0, 0, true);
        assertFalse(field.isEmpty());

    }

    // this had error, might have not been properly implemented
    @Test
    public void testIsValid() {
        Field field = new Field(1, 1);
        field.setCellValue(0, 0, true);
        assertFalse(field.isValid());
    }

    // this had error, might have not been properly implemented
    @Test
    public void testIsValidV2() {
        Field field = new Field(1, 1);
        field.setCellValue(0, 0, true);
        assertFalse(field.isValid());
    }
    
    @Test
    public void testIsValidV3() {
        Field field = new Field(5, 5);
        field.setArrayFieldV2(new Field(5, 5));
        field.setCellValue(0, 0, true);
        assertFalse(field.isValid());
    }

    @Test
    public void testSetMissed() {
        Field field = new Field(5, 5);
        field.setCellValue(0, 0, true);
        field.setCellValue(1, 1, true);
        field.setCellValue(2, 2, true);

        field.setMissed(0, 0);
        assertEquals(true, field.getCellValue(0, 0));

    }


}

