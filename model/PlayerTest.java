package model;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * The test class PlayerTest.
 *
 * @author kelvin.likollari@usi.ch
 */
public class PlayerTest
{
    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
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
    public void testGetName()
    {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        assertEquals("( ͡° ͜ʖ ͡°)", player.getName());
    }

    @Test
    public void testGetPlayerNumber()
    {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        assertEquals(0, player.getPlayerNumber());
    }

    @Test
    public void testGetScore()
    {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        assertEquals(0, player.getScore());
    }

    @Test
    public void testGetScore2()
    {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        player.setScore(1);
        assertEquals(1, player.getScore());
    }

    @Test
    public void testGetScore3()
    {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        player.setScore(1);
        player.setScore(2);
        assertEquals(3, player.getScore());
    }

    @Test
    public void testGetScore4()
    {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        player.setScore(1);
        player.setScore(2);
        player.setScore(3);
        player.setScore(4);
        player.setScore(5);
        assertEquals(15, player.getScore());
    }

    @Test
    public void testGetScore5()
    {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        player.setScore(1);
        player.setScore(2);
        player.setScore(3);
        player.setScore(4);
        player.setScore(5);
        player.setScore(6);
        assertEquals(21, player.getScore());
    }

    // tostring
    @Test
    public void testToString()
    {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        assertEquals("( ͡° ͜ʖ ͡°)", player.toString());
    }

    @Test
    public void testGetShips() {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        assertEquals(5, player.getShips());
    }

    @Test
    public void testGetSymbol() {
        Player player = new Player("( ͡° ͜ʖ ͡°)");
        player.setSymbol("O");
        assertEquals("BOR", player.getSymbol());
    }



//    @Test
//    public void testGenerateRandomPlayerXCoordinate3() {
//        Player player = new Player("( ͡° ͜ʖ ͡°)");
//        assertEquals(0, player.generateRandomPlayerXCoordinate());
//    }

    // I CANNOT MAKE THE METHODS THAT TAKE USER INPUT WORK.









}
