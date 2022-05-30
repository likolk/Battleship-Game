package model;



import static model.Field.FIELD_SIZE;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * The test class AiTest.
 * @author kelvin.likollari@usi.ch
 */
public class AiTest
{
    /**
     * Default constructor for test class AiTest
     */
    public AiTest()
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
    public void testGetAiScore()
    {
        Ai ai = new Ai();
        assertEquals(0, ai.getAiScore());
    }

    // TODO: Fix this test - Ask Diego.
    @Test
    public void testGetAiName() {
        Ai ai = new Ai();
        assertEquals("Mr. Computer  ( ͡° ͜ʖ ͡°)", ai.getAiName());
    }

    @Test
    public void testGetShips() {
        Ai ai = new Ai();
        assertEquals(5, ai.getShips());
    }

//    @Test
//    public void testWonTheGameAi() {
//        Ai ai = new Ai();
//        ai.wonTheGameAI();
//        assertEquals(1, ai.getAiScore());
//    }

//    @Test
//    public void testGenerateRandomSecondAiXCoordinate() {
//        Ai ai = new Ai();
//        Random random = new Random();
//        int randomNumber = random.nextInt(FIELD_SIZE);
//        assertEquals(randomNumber, ai.generateRandomSecondAiXCoordinate());
//    }
//
//    @Test
//    public void testGenerateRandomSecondAiYCoordinate() {
//        Ai ai = new Ai();
//        Random random = new Random();
//        int randomNumber = random.nextInt(10);
//        assertEquals(randomNumber, ai.generateRandomSecondAiYCoordinate());
//    }

//    @Test
//    public void testGenerateAiMove() {
//        Ai ai = new Ai();
//        Random random = new Random();
//        int[] x = new int[random.nextInt(10)];
//        int[] y = new int[random.nextInt(10)];
//        assertEquals(x, ai.generateAiMove());
//        assertEquals(y, ai.generateAiMove());
//    }
//
//    @Test
//    public void testGenerateAiMoveForSecondAi() {
//        Ai ai2 = new Ai();
//        Random random = new Random();
//        int[] x = new int[random.nextInt(10)];
//        int[] y = new int[random.nextInt(10)];
//        assertEquals(x, ai2.generateAiMove());
//        assertEquals(y, ai2.generateAiMove());
//    }






}
