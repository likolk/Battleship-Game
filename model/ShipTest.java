package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * The test class ShipTest.
 * @author kelvin.likollari@usi.ch
 */
public class ShipTest
{
    /**
     * Default constructor for test class ShipTest
     */
    public ShipTest()
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
    public void testShip()
    {
        Ship ship = new Ship(2,2,2,
                true, true, true, true);
        assertEquals(2,ship.getPositionX());
        assertEquals(2,ship.getPositionY());
        assertEquals(2,ship.getSize());
    }

    @Test
    public void testShip2()
    {
        Ship ship = new Ship(100,55,22, true, true, true, true);
        assertEquals(55,ship.getPositionX());
        assertEquals(22, ship.getPositionY());
        assertEquals(100,ship.getSize());
    }

    // TODO: Fix this test
    @Test
    public void getCoordinates()
    {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        // assertEquals(2, ship.getCoordinates()[2]);
        // assertEquals(2,ship.getCoordinates()[2]);
    }


    @Test
    public void testSetSize() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        ship.setSize(3);
        assertEquals(3,ship.getSize());
    }

    @Test
    public void testSetPositionX() {
        Ship ship = new Ship(2,2,2,     true, true, true, true);
        ship.setPositionX(3);
        assertEquals(3,ship.getPositionX());
    }

    @Test
    public void testSetPositionY() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        ship.setPositionY(3);
        assertEquals(3,ship.getPositionY());
    }

    @Test
    public void testSetPositionXAndY() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        ship.setPositionXAndY(3,3);
        assertEquals(3,ship.getPositionX());
        assertEquals(3,ship.getPositionY());
    }

    @Test
    public void testGetSize() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        assertEquals(2,ship.getSize());
    }

    @Test
    public void testGetPositionX() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        assertEquals(2,ship.getPositionX());
    }

    @Test
    public void testGetPositionY() {
        Ship ship = new Ship(2,2,2,     true, true, true, true);
        assertEquals(2,ship.getPositionY());
    }

    @Test
    public void testGetPosition() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        assertEquals(2,ship.getPositionX());
        assertEquals(2,ship.getPositionY());
    }

    // TODO: Fix the 2 tests below
    /*
    @Test
    public void testIsSunk() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        for (int i = 0; i < ship.getSize(); i++) {
            for (int j = 0; j < ship.getSize(); j++) {
                if (ship.isHit()) {
                    ship.setSunk();
                }
            }
        }
        assertTrue(ship.isSunk());
    }
    */
    @Test
    public void testIsShot() {
        Ship ship = new Ship(2, 2, 2, true, true, true, true);
        // No exception thrown
        assertFalse(ship.isShot());
    }

    @Test
    public void testSetPositionXAndY2() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        ship.setPositionXAndY(2,2);
        assertEquals(2,ship.getPositionX());
        assertEquals(2,ship.getPositionY());
    }

    // Test added in-class. Date: 29/04/2022
    // TODO: Erroneous test.
    @Test
    public void testToString() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        assertEquals("Ship: 2 2 2", ship.toString());

    }


    @Test
    public void testPlaceSubmarine() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        Field field = new Field(10,10);
        ship.placeShipGUI(2, 2, true, ship);
        assertEquals(2, ship.getPositionX());
        assertEquals(2, ship.getPositionY());
        assertEquals(2, ship.getSize());
    }

    @Test
    public void testGetCoordinates() {
       // we test the getCoordinates method of type List of coordinates
        Ship ship = new Ship(2,2,2, true, true, true, true);
        List<Coordinates> coordinates = ship.getCoordinates();
        assertNull(coordinates);
    }


    @Test
    public void testSetDirection() {
        Ship.setDirection(true);
        assertTrue(Ship.getDirection());
    }


    @Test
    public void testShipp() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        assertEquals(2, ship.getPositionX());
        assertEquals(2, ship.getPositionY());
        assertEquals(2, ship.getSize());
    }


    @Test
    public void testPlaceCarrier() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        Field field = new Field(10,10);
        ship.placeShipGUI(2, 2, true, ship);
        assertEquals(2, ship.getPositionX());
        assertEquals(2, ship.getPositionY());
        assertEquals(2, ship.getSize());
    }

    @Test
    public void testPlaceCruiser() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        Field field = new Field(10,10);
        ship.placeShipGUI(2, 2, true, ship);
        assertEquals(2, ship.getPositionX());
        assertEquals(2, ship.getPositionY());
        assertEquals(2, ship.getSize());
    }

    @Test
    public void testPlaceShipGUI() {
        Ship ship = new Ship(2,2,2, true, true, true, true);
        Field field = new Field(10,10);
        ship.placeShipGUI(2, 2, true, ship);
        assertEquals(2, ship.getPositionX());
        assertEquals(2, ship.getPositionY());
        assertEquals(2, ship.getSize());

    }

}
