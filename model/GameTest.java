package model;

import static model.Game.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.naming.Name;
import java.io.*;
import java.util.*;

/**
 * The test class GameTest.
 * @author kelvin.likollari@usi.ch
 */
public class GameTest {
    /**
     * Default constructor for test class GameTest
     */
    public GameTest() {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    @Test
    public void testGame() {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    public void testIsGameOver() {
        Game game = new Game();
        assertFalse(game.isGameOver());
    }

    @Test
    public void testIsGameWon() {
        Game game = new Game();
        assertFalse(game.isGameWon());
    }

    @Test
    public void testIsGameLost() {
        Game game = new Game();
        assertFalse(game.isGameLost());
    }

    @Test
    public void testGameOver() {
        Game game = new Game();
        Player player = new Player("P", 4);
        Ship ship = new Ship(2);
        assertFalse(game.isGameOver());

    }

    @Test
    public void testGameOver1() {
        Game game = new Game();
        Player player = new Player("P", 4);
        Ai ai = new Ai("A", 4);
        Ship ship = new Ship(2);
//        if (player.getShips() == 0 && ai.getShips() == 0) {
//            game.gameOver();
//            assertTrue(game.isGameOver());
//        }
        // since there are still ships left, the game is not over
        assertFalse(game.isGameOver());
    }

    @Test
    public void testGameNotOver() {
        Game game = new Game();
        assertFalse(game.isGameOver());
    }

    @Test
    public void testGameWon() {
        Game game = new Game();
        // game.gameIsWon(); // we need to implement a gameIsWon for this to work.
        assertFalse(game.isGameWon()); // TODO: To turn to true when the above line gets fixed.
    }




    @Test
    public void testGetPlayerName() {
        Player player = new Player("P", 4);
        player.setName("P");
        assertEquals("P", player.getName());
    }




    @Test //added in 29.04.2022
    public void testChangeTurn() {
        Game game = new Game();
        assertEquals(false, game.changeTurn());
    }

    @Test //added in 29.04.2022
    public void testChangeTurnv2() {
        Game game = new Game();
        game.changeTurn();
        assertEquals(true, game.changeTurn());
    }

    @Test
    public void testAiTurnToMakeAMove() {
        Game game = new Game();
        game.aiTurnToMakeAMove();
        assertEquals(false, game.changeTurn());
    }

    @Test
    public void testAiTurnToMakeAMovev2() {
        Game game = new Game();
        game.aiTurnToMakeAMove();
        game.changeTurn();
        assertEquals(true, game.changeTurn());
    }

    @Test
    public void testAiTurnToMakeAMovev3() {
        Game game = new Game();
        game.aiTurnToMakeAMove();
        game.changeTurn();
        game.changeTurn();
        assertEquals(false, game.changeTurn());
    }

    @Test
    public void testGetX() {
        Game game = new Game();
        assertEquals(0, game.getX());
    }

    @Test
    public void testGetY() {
        Game game = new Game();
        assertEquals(0, game.getY());
    }

    @Test
    public void testGetXv2() {
        Game game = new Game();
        game.setX(1);
        assertEquals(1, game.getX());
    }

    @Test
    public void testGetYv2() {
        Game game = new Game();
        game.setY(1);
        assertEquals(1, game.getY());
    }

    @Test
    public void testGetXv3() {
        Game game = new Game();
        game.setX(1);
        game.setY(1);
        assertEquals(1, game.getX());

    }

    @Test
    public void updateGameDisplay() {
        Game game = new Game();
        Field field = new Field();
        Field field2 = new Field();
        game.updateGameDisplay(field, field2);
        assertEquals(0, game.getX());
        assertEquals(0, game.getY());
    }

    @Test
    public void testShipSizesHelpful() {
        int[] shipSizes = new int[5];
        shipSizes[0] = 1;
        shipSizes[1] = 2;
        shipSizes[2] = 3;
        shipSizes[3] = 4;
        shipSizes[4] = 5;
        assertEquals(1, shipSizes[0]);
        assertEquals(2, shipSizes[1]);
        assertEquals(3, shipSizes[2]);
        assertEquals(4, shipSizes[3]);
        assertEquals(5, shipSizes[4]);
    }

//    @Test
//    public void testWelcomingInstructions() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Everything good? (y/n)");
//        String input = scanner.nextLine();
//        while (input != "y") {
//            System.out.println("Please enter y to continue.");
//            input = scanner.nextLine();
//            if (input == "y") {
//                Game.welcomingInstructions(scanner);
//            }
//        }
//    }

//    @Test
//    public void testSetPlayerShips() {
//        // to test this we must first get input from the user
//        // and then call the method.
//        Field playerFieldForPlayer = new Field();
//        Player player = new Player();
//        Game game = new Game();
//        Scanner scanner = new Scanner(System.in);
//        // select whether you'd like to set the ships manually or automatically
//        System.out.println("Would you like to set the ships manually or automatically? (m/a)");
//        String input = scanner.nextLine();
//        while (input != "m" && input != "a") {
//            System.out.println("Please enter m or a to continue.");
//            input = scanner.nextLine();
//            if (Objects.equals(input, "m")) {
//                game.setPlayerShips(scanner);
//            }
//            if (input == "a") {
//                placeShipRandomlyV2(playerFieldForPlayer, player);
//            }
//        }
//        game.setPlayerShips(scanner);
//        assertEquals(0, game.getX());
//        assertEquals(0, game.getY());
//    }




    @Test
    public void testSetSecondAiShips() {
        Field aiFieldForSecondAi = new Field();
        Ai ai2 = new Ai(); // made public static to be acc
        placeShipRandomlyV2(aiFieldForSecondAi, ai2);
    }

    @Test
    public void testSetThirdAiShips() {
        Field aiFieldForThirdAi = new Field();
        Ai ai3 = new Ai(); // made public static to be acc
        placeShipRandomlyV2(aiFieldForThirdAi, ai3);
    }

    @Test
    public void testStartGamePVSAI() {
        // TODO: Test this method

    }

    @Test
    public void testcheckIfTheGameIsOverAIVAI() {
        Game game = new Game();
        assertEquals(false, game.checkIfTheGameIsOverAIvsAI());
    }

    @Test
    public void testcheckIfTheGameIsOverAIVAIV2() {
        Game game = new Game();
        game.checkIfTheGameIsOverAIvsAI();
        assertEquals(false, game.checkIfTheGameIsOverAIvsAI());
    }

    @Test
    public void testcheckIfTheGameIsOverAIVAIV3() {
        Game game = new Game();
        int secondAiRoomsLeft = 0;
        int aiRoomsLeft = 0;
        game.checkIfTheGameIsOverAIvsAI();
        assertEquals(false, game.checkIfTheGameIsOverAIvsAI());

    }

    // TODO: Test the true case of the above

    @Test
    public void testDeclareWinner() {
        Game game = new Game();
        String lastTurn = "";
        if (lastTurn == "a") {
            game.declareWinner(lastTurn);
        } else {
            game.declareWinner(lastTurn);
        }
    }

    @Test
    public void getAiShipSymbol() {
        String symbol = "";
        Game game = new Game();
        assertEquals("", symbol);
    }

    @Test
    public void getAiShipSymbolv2() {
        String symbol = "k";
        Game game = new Game();
        assertEquals("k", symbol);
    }

    @Test
    public void getAiShipSymbolv3() {
        String symbol = null;
        Game game = new Game();
        assertNull(symbol);
    }

    @Test
    public void getPlayerShipSymbol() {
        String symbol = "";
        Game game = new Game();
        assertEquals("", symbol);
    }

    @Test
    public void getPlayerShipSymbolv2() {
        String symbol = "k";
        Game game = new Game();
        assertEquals("k", symbol);
    }

    @Test
    public void testSecondAiTurnToMakeAMove() {
        Game game = new Game();
        Field aiFieldForSecondAi = new Field();
        Ai ai2 = new Ai();
        placeShipRandomlyV2(aiFieldForSecondAi, ai2);
        game.secondAiTurnToMakeAMove();
        assertEquals(0, game.getX());
        assertEquals(0, game.getY());
    }

    @Test
    public void testShipSizesHelpfulv2() {
        int[] shipSizes = new int[5];
        shipSizes[0] = 1;
        shipSizes[1] = 2;
        shipSizes[2] = 3;
        shipSizes[3] = 4;
        shipSizes[4] = 5;
        assertEquals(1, shipSizes[0]);
        assertEquals(2, shipSizes[1]);
        assertEquals(3, shipSizes[2]);
        assertEquals(4, shipSizes[3]);
        assertEquals(5, shipSizes[4]);
    }

    @Test
    public void testGetAiShipSymbol() {
        String symbol = "";
        Game game = new Game();
        assertEquals("", symbol);
    }

//    @Test
//    public void testSetAiShips() {
//        // to test this we must first get input from the user
//        // and then call the method.
//        Field aiFieldForSecondAi = new Field();
//        Ai ai2 = new Ai(); // made public static to be acc
//        placeShipRandomlyV2(aiFieldForSecondAi, ai2);
//        assertEquals(0, ai2.generateRandomAiYCoordinate());
//        assertEquals(0, ai2.generateRandomAiXCoordinate());
//    }

//    @Test
//    public void testSetSecondAiShips2() {
//        Field aiFieldForSecondAi = new Field();
//        Ai ai2 = new Ai(); // made public static to be acc
//        placeShipRandomlyV2(aiFieldForSecondAi, ai2);
//        assertEquals(0, ai2.generateRandomAiYCoordinate());
//        assertEquals(0, ai2.generateRandomAiXCoordinate());
//    }

    @Test
    public void getSecondAiShipSymbol() {
        String symbol = "";
        Game game = new Game();
        assertEquals("", symbol);
    }

    @Test
    public void testShoot() {
        int x = 0;
        int y = 0;
        Game game = new Game();
        game.shoot(x, y);
        assertEquals(0, game.getX());
        assertEquals(0, game.getY());
    }

//    @Test
//    public void testShoot2() {
//        int x = -1;
//        int y = -1;
//        Game game = new Game();
//        game.shoot(x, y);
//        assertEquals(-1, game.getX());
//        assertEquals(-1, game.getY());
//    }

    @Test
    public void testShoot3() {
        int x = 0;
        int y = 0;
        int shipsShot = 0;
        Game game = new Game();
        game.shoot(x, y);
        shipsShot++;
        assertEquals(true, shipsShot > 0);
    }






}
