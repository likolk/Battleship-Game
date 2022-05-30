package model;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * The test class GamePlayersTest.
 *
 * @author kelvin.likollari@usi.ch
 */
public class GamePlayersTest
{
    /**
     * Default constructor for test class GamePlayersTest
     */
    public GamePlayersTest()
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
    public void testGamePlayers()
    {
        GamePlayers gp = new GamePlayers();
        assertNotNull(gp);
    }

    @Test
    public void testGetName()
    {
        GamePlayers gp = new GamePlayers();
        assertEquals(null, gp.getName());
    }

    @Test
    public void testGetName2()
    {
        GamePlayers gp = new GamePlayers();
        gp.setName("John");
        assertEquals("John", gp.getName());
    }

    @Test
    public void testGetScore()
    {
        GamePlayers gp = new GamePlayers();
        assertEquals(0, gp.getScore());
    }

    @Test
    public void testGetScore2()
    {
        GamePlayers gp = new GamePlayers();
        gp.setScore(10);
        assertEquals(10, gp.getScore());
    }


    @Test
    public void testGetScore3()
    {
        GamePlayers gp = new GamePlayers();
        gp.setScore(10);
        gp.setScore(20);
        assertEquals(20, gp.getScore());
    }

    @Test
    public void setName()
    {
        GamePlayers gp = new GamePlayers();
        gp.setName("John");
        assertEquals("John", gp.getName());
    }

    @Test
    public void setName2()
    {
        GamePlayers gp = new GamePlayers();
        gp.setName(null);
        assertEquals(null, gp.getName());
    }

    @Test
    public void setScore()
    {
        GamePlayers gp = new GamePlayers();
        gp.setScore(10);
        assertEquals(10, gp.getScore());
    }

    @Test
    public void setScore2()
    {
        GamePlayers gp = new GamePlayers();
        gp.setScore(-10);
        assertEquals(-10, gp.getScore());
    }

    @Test
    public void setScore3()
    {
        GamePlayers gp = new GamePlayers();
        gp.setScore(10);
        gp.setScore(20);
        assertEquals(20, gp.getScore());
    }

    @Test
    public void testIncreaseScore() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.increaseScore();
        assertEquals(11, gp.getScore());
    }

    @Test
    public void testIncreaseScore2() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.increaseScore();
        gp.increaseScore();
        assertEquals(12, gp.getScore());
    }

    @Test
    public void testIncreaseScore3() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.increaseScore();
        gp.increaseScore();
        gp.increaseScore();
        assertEquals(13, gp.getScore());
    }

    // decrease score

    @Test
    public void testDecreaseScore() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.decreaseScore();
        assertEquals(9, gp.getScore());
    }

    @Test
    public void testDecreaseScore2() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.decreaseScore();
        gp.decreaseScore();
        assertEquals(8, gp.getScore());
    }

    @Test
    public void testDecreaseAndIncreaseScore() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.decreaseScore();
        gp.increaseScore();
        assertEquals(10, gp.getScore());

    }

    @Test
    public void testDecreaseAndIncreaseScore2() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.decreaseScore();
        gp.increaseScore();
        gp.increaseScore();
        assertEquals(11, gp.getScore());
    }

    @Test
    public void testDecreaseAndIncreaseScore3() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        for (int i = 0; i < 10; i++) {
            gp.decreaseScore();
        }
        assertEquals(0, gp.getScore());
    }


    @Test
    public void testResetScore() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.resetScore();
        assertEquals(0, gp.getScore());
    }

    @Test
    public void testResetScore2() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.resetScore();
        gp.increaseScore();
        assertEquals(1, gp.getScore());
    }

    @Test
    public void testResetScore3() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        gp.resetScore();
        gp.decreaseScore();
        assertEquals(-1, gp.getScore());
    }

    @Test
    public void testResetScore4() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        for (int i = 0; i < 10; i++) {
            gp.decreaseScore();
        }
        gp.decreaseScore(); // -1
        gp.resetScore();
        assertEquals(0, gp.getScore());
    }

    @Test
    public void testResetScore5() {
        GamePlayers gp = new GamePlayers();
        // set the score to some value
        gp.setScore(10);
        for (int i = 0; i < 10; i++) {
            gp.decreaseScore();

        }
        gp.decreaseScore(); // -1
        gp.resetScore();
        gp.increaseScore();
        assertEquals(1, gp.getScore());
    }

    @Test
    public void testGetSymbol() {
        GamePlayers gp = new GamePlayers();
        assertEquals(null, gp.getSymbol());
    }

    @Test
    public void testSetSymbol() {
        GamePlayers gp = new GamePlayers();
        gp.setSymbol("O");
        assertEquals("O", gp.getSymbol());
    }

    @Test
    public void testGetName5() {
        GamePlayers gp = new GamePlayers();
        assertEquals(null, gp.getName()); // by default, the name is empty
    }

    @Test
    public void testGetSymbol2() {
        GamePlayers gp = new GamePlayers();
        gp.setSymbol("O");
        assertEquals("O", gp.getSymbol());
    }

    @Test
    public void testGetName6() {
        GamePlayers gp = new GamePlayers();
        gp.setName("John");
        assertEquals("John", gp.getName());
    }

    @Test
    public void testGetSymbol3() {
        GamePlayers gp = new GamePlayers();
        gp.setSymbol("");
        assertEquals("", gp.getSymbol());
    }

    @Test
    public void testIsAlive() {
        GamePlayers gp = new GamePlayers();
        assertTrue(gp.isAlive());
    }

    @Test
    public void testGetPlayer() {
        GamePlayers gp = new GamePlayers();
        assertNull(gp.getPlayer());
    }

    @Test
    public void testGetField() {
        GamePlayers gp = new GamePlayers();
        assertNull(gp.getField());
    }

    @Test
    public void testGenerateRandomXCoordinate() {
        GamePlayers gp = new GamePlayers();
        assertTrue(gp.generateRandomXCoordinate() >= 0 && gp.generateRandomXCoordinate() <= 9);
    }

    @Test
    public void testGenerateRandomYCoordinate() {
        GamePlayers gp = new GamePlayers();
        assertTrue(gp.generateRandomYCoordinate() >= 0 && gp.generateRandomYCoordinate() <= 9);
    }

    @Test
    public void testGenerateRandomYCoordinateForSecondPlayer() {
        GamePlayers gp = new GamePlayers();
        assertTrue(gp.generateRandomYCoordinateForSecondPlayer() >= 0 && gp.generateRandomYCoordinateForSecondPlayer() <= 9);
    }

    @Test
    public void testGenerateRandomXCoordinateForSecondPlayer() {
        GamePlayers gp = new GamePlayers();
        assertTrue(gp.generateRandomXCoordinateForSecondPlayer() >= 0 && gp.generateRandomXCoordinateForSecondPlayer() <= 9);
    }

    @Test
    public void testgenerateRandomXCoordinateForSecondAI() {
        GamePlayers gp = new GamePlayers();
        assertTrue(gp.generateRandomXCoordinateForSecondAI() >= 0 && gp.generateRandomXCoordinateForSecondAI() <= 9);
    }

    @Test
    public void testgenerateRandomYCoordinateForSecondAI() {
        GamePlayers gp = new GamePlayers();
        assertTrue(gp.generateRandomYCoordinateForSecondAI() >= 0 && gp.generateRandomYCoordinateForSecondAI() <= 9);
    }

    @Test
    public void testGetPlayer2() {
        GamePlayers gp = new GamePlayers();
        assertNull(gp.getPlayer());
    }
















}
