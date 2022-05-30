package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Game class is the main class of the game.
 * This class runs the actual Battleship game taking into consideration the game logic.
 *  @author kelvin.likollari@usi.ch| and ilker.kaymak@usi.ch
 */
public class Game {
    private int playersNumber;
    private static int x;
    private static int y;

    // Initializes the player and the AI (Computer)
    private static Player player; // made public static to be accessible in the main class in TUI
    private static Player player2; // the second player
    private static Ai ai;
    private static Ai ai2;

    private static Field playerField = new Field(); // player field
    private static Field aiField = new Field(); // ai field

    private static Field aiFieldForPlayer = new Field(); // ai field for player

    private static Field aiFieldForSecondAi = new Field(); // ai field for AI2

    private static Field playerFieldForPlayer = new Field(); // player field for player

    private static Field secondPlayerFieldForPlayer = new Field(); // second player field for player

    private static Field aiFieldForAi = new Field();

    private static Field secondPlayerFieldForAi = new Field(); // second player field for ai

    private final static String name = "Computer";
    private boolean turncounter; // if it is true, it is player's turn, else it is AI's turn
    private boolean isgameover; // if it is true, the game is over
    private boolean isgamewon; // if it is true, the game is won
    private boolean isgamelost; // if it is true, the game is lost

    //  The position of the ship on the board, that is, which cell is occupied by the ship.
    private Field fieldShips = new Field();
    // fieldShot contains information regarding the position (a cell) that has been shot.
    private Field fieldShot = new Field();
    private int shipsShot = 0;
    private Coordinates coordinates;
    // a list of integers holding the sizes of the ships
    private static List<Integer> shipSizes = new ArrayList<Integer>();
    private static long aiRoomsLeft = 5;
    private static long playerRoomsLeft = 5;

    private static long secondPlayerRoomsLeft = 5;

    private static long secondAiRoomsLeft = 5;
    private static final int FIELD_SIZE = 10;

    private static DisplayField display = new DisplayField(FIELD_SIZE, FIELD_SIZE);

    // to be incremented by 1 everytime a ship is hit
    private static int playerScore = 0;

    // the score of the second player
    private static int secondPlayerScore = 0;

    // to be incremented by 1 everytime a ship is hit
    private static int aiScore = 0;

    // the score of the second AI
    private static int secondAiScore = 0;

    /**
     * Empty constructor of the Game class.
     * @param scannerino is the scanner object that is used to read the input from the user.
     */
    public Game(Scanner scannerino) {

    }

    /**
     * Constructor of the Game class.
     */
    public Game() {
        // n is the number of players
        this.playersNumber = 1;
        player = new Player();
        ai = new Ai(name, playersNumber); // check line 23
        this.turncounter = true;
        this.isgameover = false;
        this.isgamewon = false;
        this.isgamelost = false;

        // we want to insert the ships at random positions
        fieldShips.placeShipRandomly();
        fieldShips.placeShipRandomly();
        fieldShips.placeShipRandomly();
        fieldShips.placeShipRandomly();
        fieldShips.placeShipRandomly();
        //Ship.placeShipsRandomly();

    }


    /**
     * THe following method updates the display of the game.
     * It is going to update the display of the player's field,
     * and the display of the AI's field.
     *
     * @param field1 is the player's field
     * @param field2 is the AI's field
     */
    public static void updateGameDisplay(Field field1, Field field2) {
        // update the display of the player's field
        String[][] playerFieldDisplay = field1.getField(); // get the player's field
        String[][] aiFieldDisplay = field2.getField(); // get the AI's field
        display.displayBoard(playerFieldDisplay, aiFieldDisplay); // print the player's field
        // displayField.printBoard(playerFieldDisplay); // print the player's field
    }

    /**
     * The following method is used to update the display of the game in pvp mode.
     * @param field1 is the player's field
     * @param field2 is the second player's field
     */
    public static void updateGameDisplayPVP(Field field1, Field field2) {
        // update the display of the player's field
        String[][] playerFieldDisplay = field1.getField(); // get the player's field
        String[][] aiFieldDisplay = field2.getField(); // get the AI's field
        display.displayBoard(playerFieldDisplay, aiFieldDisplay); // print the player's field
        // displayField.printBoard(playerFieldDisplay); // print the player's field
    }


    /**
     * This method is used as a helper method for the shipsizes.
     */
    public static void shipSizesHelpful() {
        // first we create a dictionary with the ship sizes
        int[] shipSizes = {5, 4, 3, 3, 2};
        for (int shipSize : shipSizes) {
            Game.shipSizes.add(shipSize);
        }
    }

    //    /**
    //     * This method is used as a helper method for the shipsizes.
    //      * It is a duplicate of the method above, just for the sake of the test.
    //
    //     */
    //    // TODO: It is a duplicate of the method above, just for the sake of the test.
    //    public static void shipSizesHelpful1() {
    //        // first we create a dictionary with the ship sizes
    //        int[] shipSizes = {5};
    //        for (int i = 0; i < shipSizes.length; i++) {
    //            Game.shipSizes.add(shipSizes[i]);
    //        }
    //    }





    /**
     * This method is used for the welcoming instructions shown to the user.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void welcomingInstructions(Scanner scannerino) {
        String welcome10 = "Everything clear? (y/n)";
        String welcome11 = "Let's start playing then!";
        // an array on which we will store the instructions needed for the yes/no question
        String[] instructions = {welcome10, welcome11};
        // a loop that will run until the user answers yes to the question
        int idx = 0;
        do {
            System.out.println(instructions[idx]);
            String answer = scannerino.nextLine();
            if ("y".equals(answer)
                    || "yes".equals(answer)
                    || "Y".equals(answer)
                    || "YES".equals(answer)
                    || "Yes".equals(answer)) {
                idx++;
                System.out.println(instructions[idx]);
                break;
            } else if ("ex".equals(answer)
                    || "exit".equals(answer)
                    || "EXIT".equals(answer)
                    || "Exit".equals(answer)) {
                break;
            } else {
                System.out.println("Your answer was not recognized. Please try again.");

            }
        }
        while (true);
    }

    /**
     * This method asks the player to set the ships manually or randomly,
     * and then set the ships accordingly.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void setPlayerShips(Scanner scannerino) {
        while (true) {
            // typing yes will set the ships manually, typing no will set the ships randomly
            System.out.println("Would you like to set your ships manually or randomly?"
                    +
                    "\nType 'y' or 'Y' for manual placement "
                    +
                    "or 'n' or 'N' for random.");
            String answer = scannerino.nextLine();
            if ("y".equals(answer)
                    || "Y".equals(answer)) { // if the player wants to set the ships manually
                setPlayerShipsManually(scannerino);
                break;
            } else if ("n".equals(answer)
                    || "N".equals(answer)) { // if the player wants to set the ships randomly
                System.out.println("You have chosen to set your ships randomly.");
                placeShipRandomlyV2(playerFieldForPlayer, player);
                break;
            } else {
                System.out.println("Your answer was not recognized");
            }
        }
    }

    /**
     * This method is used to set the SECOND PLAYER's ships automatically.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void setSecondPlayerShips(Scanner scannerino) {
        while (true) {
            // typing yes will set the ships manually, typing no will set the ships randomly
            System.out.println("Hey Player 2, would you like to set your ships manually or randomly?"
                    +
                    "\nType 'y' or 'Y' for manual placement "
                    +
                    "or 'n' or 'N' for random.");
            String answer = scannerino.nextLine();
            if ("y".equals(answer)
                    || "Y".equals(answer)) { // if the player wants to set the ships manually
                setSecondPlayerShipsManually(scannerino);
                break;
            } else if ("n".equals(answer)
                    ||("N").equals(answer)) { // if the player wants to set the ships randomly
                System.out.println("You have chosen to set your ships randomly.");
                placeShipRandomlyPVP(secondPlayerFieldForPlayer, player2);
                break;
            } else {
                System.out.println("Your answer was not recognized");
            }
        }
    }

    /**
     * This method is used to set the ships manually.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void setPlayerShipsManually(Scanner scannerino) {
        int x1;
        int y1;
        String direction;
        boolean isValid;
        String str = "Please enter a ship of length ";
        for (int size : shipSizes) {
            System.out.println(str + size + ".");
            isValid = false;
            while (isValid == false) {
                x1 = player.inWhichRowToPutShip(scannerino);
                y1 = player.inWhichColToPutShip(scannerino);
                direction = player.whichDirectionToPutShip(scannerino);

                if (playerFieldForPlayer.isValidPlacementForShip(x1, y1, size, direction, true)) {
                    playerFieldForPlayer.setShipOfDifferentSize(x1, y1, direction, size, player.getSymbol());
                    updateGameDisplay(playerFieldForPlayer, aiFieldForPlayer);
                    break;
                }
            }
        }
    }

    /**
     * Method that sets the player ship on the field automatically.
     * @param x1 the x coordinate
     * @param y1 the y coordinate
     */
    public static void setPlayerShipsManually(int x1, int y1) {
        if (playerFieldForPlayer.isValidMoveV2(x1, y1)) { // If the move is valid.
            if (playerFieldForPlayer.checkWhetherHitWasSuccessful(x1, y1)) { // If the move is a hit.
                playerScore++; // Increase the player's score.
                System.out.println("Ship Hit! Congratulations!");
                System.out.println("Current Score: " + playerScore);
                aiRoomsLeft--; // Decrease the number of rooms left for the ai.
                aiFieldForPlayer.setHit(x1, y1);  // Set the hit on the player's field.
                aiFieldForAi.setHit(x1, y1); // Set the hit on the ai's field.
            } else { // If the move is a miss.
                System.out.println("Ship Missed! Try again!");
                aiFieldForPlayer.setMissed(x1, y1); // Set the missed on the player's field.
                aiFieldForAi.setMissed(x1, y1); // Set the missed on the ai's field.
            }
        }
    }

    /**
     * This method is used to set the SECOND PLAYER's ships manually.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void setSecondPlayerShipsManually(Scanner scannerino) {
        int xx;
        int yy;
        String direction;
        boolean isValid;
        String str = "Please enter a ship of length ";
        for (int size : shipSizes) {
            System.out.println(str + size + ".");
            isValid = false;
            while (isValid == false) {
                xx = player.inWhichRowToPutShip(scannerino);
                yy = player.inWhichColToPutShip(scannerino);
                direction = player.whichDirectionToPutShip(scannerino);
                if (secondPlayerFieldForPlayer.isValidPlacementForShip(xx, yy, size, direction, true)) {
                    secondPlayerFieldForPlayer.setShipOfDifferentSize(xx, yy, direction, size, player.getSymbol());
                    updateGameDisplay(playerFieldForPlayer, secondPlayerFieldForPlayer);
                    break;
                }
            }
        }
    }


    /**
     * This method places ships randomly on the field.
     * @param field       the field on which the ships will be placed.
     * @param gamePlayers the game players to place the ship on.
     */
    public static void placeShipRandomlyV2(Field field, GamePlayers gamePlayers) {
        boolean isFree; // If the ship can be placed.
        for (int size : shipSizes) { // Loop through the ships.
            isFree = false; // The ship is not placed.
            while (isFree == false) { // While the ship is not placed.
                int rx = gamePlayers.generateRandomXCoordinate(); // Generate a random x coordinate.
                int ry = gamePlayers.generateRandomYCoordinate(); // Generate a random y coordinate.
                String direction = gamePlayers.generateRandomDirectionForAi(); // Randomly choose a direction.


                if (field.isValidPlacementForShip(rx, ry, size, direction, false)) { // If the ship can be placed.
                    field.directionOnWhereToSetShip(rx, ry, direction, size, ai.getSymbol()); // Set the ship.
                    // isFree = true; // The ship is placed.
                    break; // Break the loop.
                }
            }
        }
    }

    /**
     * Method that places ships randomly on the field in pvp mode.
     * @param field      the field on which the ships will be placed
     * @param gamePlayers the game players to place the ship on
     */
    public static void placeShipRandomlyPVP(Field field, GamePlayers gamePlayers) {
        boolean isFree; // If the ship can be placed.
        for (int size : shipSizes) { // Loop through the ships.
            isFree = false; // The ship is not placed.
            while (isFree == false) { // While the ship is not placed.
                if (gamePlayers == null) {
                    System.out.println("debug");
                }
                int rx = gamePlayers.generateRandomXCoordinateForSecondPlayer(); // Generate a random y coord
                int ry = gamePlayers.generateRandomYCoordinateForSecondPlayer(); // Generate a random y coordinate.
                String direction = gamePlayers.generateRandomDirectionForSecondPlayer(); // Randomly choose a direction.

                if (field.isValidPlacementForShip(rx, ry, size, direction, false)) { // If the ship can be placed.
                    field.directionOnWhereToSetShip(rx, ry, direction, size, player.getSymbol()); // Set the ship.
                    // isFree = true; // The ship is placed.
                    break; // Break the loop.
                }
            }
        }
    }

    /**
     * This method is used to place the ships randomly on the field for the second (left) ai.
     * @param field the field on which the ships will be placed.
     * @param gamePlayers the game players to place the ship on.
     */
    public static void placeShipRandomlySecondAi(Field field, GamePlayers gamePlayers) {
        boolean isFree; // If the ship can be placed.
        for (int size : shipSizes) { // Loop through the ships.
            isFree = false; // The ship is not placed.
            while (isFree == false) { // While the ship is not placed.
                int rx = gamePlayers.generateRandomXCoordinateForSecondAI(); // Generate a random x coordinate.
                int ry = gamePlayers.generateRandomYCoordinateForSecondAI(); // Generate a random y coordinate.
                String direction = gamePlayers.generateRandomDirectionForSecondAI(); // Randomly choose a direction.


                if (field.isValidPlacementForShip(rx, ry, size, direction, false)) { // If the ship can be placed.
                    field.directionOnWhereToSetShip(rx, ry, direction, size, ai2.getSymbol()); // Set the ship.
                    // isFree = true; // The ship is placed.
                    break; // Break the loop.
                }
            }
        }
    }


    /**
     * This method leaves the floor to the ai to set the ships.
     */
    public static void setAiShips() {
        placeShipRandomlyV2(aiFieldForAi, ai);
    }

    /**
     * This method leaves the floor to the second ai to set the ships.
     */
    public static void setSecondAiShips() {
        placeShipRandomlySecondAi(aiFieldForSecondAi, ai2);
    }


    /**
     * Main method called in the TUI used to start the game.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void startGamePvsAI(Scanner scannerino) {
        // check who's turn it is
        String turn; // The turn.
        while (true) { // While the game is not over.
            // if it's the player's turn
            turn = "Player"; // The turn is the player.
            // then the player has to make a move
            playerTurnToMakeAMove(scannerino); // The player makes a move.
            // makePlayerMove();
            // update the field after the player makes a move
            updateGameDisplay(playerFieldForPlayer, aiFieldForPlayer); // Update the game display after the player makes a move.
            // check if the player has won
            checkWhoWonTheGame();// If the player has won the game.

            //turn = "Second Player"; // The turn is the second player.
            //then the second player has to make a move
            //secondPlayerTurnToMakeAMove(scannerino); // The second player
            //makeSecondPlayerMove();
            //update the field after the second player makes a move
            //updateGameDisplay(playerFieldForPlayer, secondPlayerFieldForPlayer); // Update the game display after the second player makes a move.
            //check if the second player has won
            //if (checkWhoWonTheGame() == true) { // If the second player has won the game.
            //break;
            //}

            //turn = "Second AI";  // The turn is the second AI.
            //then the second AI has to make a move
            //secondAiTurnToMakeAMove(); // The second AI makes a move.
            // update the field after the second AI makes a move
            //updateGameDisplay(aiFieldForAi, secondAiFieldForSecondAi); // Update the game display after the second AI makes a move.
            //check if the second AI has won
            //if (checkWhoWonTheGame() == true) { // If the second AI has won the game.
            //break;
            //}

            //if it's the ai's turn
            turn = "AI"; // The turn is the ai.
            //then the ai has to make a move and update the field
            aiTurnToMakeAMove(); // The ai makes a move.
            //makeAIMove(); // The ai makes a move
            //update the field after the ai makes a move
            updateGameDisplay(playerFieldForPlayer, aiFieldForPlayer); // Update the game display after the ai makes a move.
            //check if the ai has won
            if (checkWhoWonTheGame()) { // If the ai has won the game.
                break;
            }
        }
        declareWinner(turn); // Declare the winner.
    }


    /**
     * Main method called in the TUI to start game pvp.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void startGamePVP(Scanner scannerino) {
        // check who's turn it is
        String turn; // The turn.
        // If the second player has won the game.
        do { // While the game is not over.
            // if it's the player's turn
            turn = "Player"; // The turn is the player.
            // then the player has to make a move
            playerTurnToMakeAMove(scannerino); // The player makes a move.
            // makePlayerMove();
            // update the field after the player makes a move
            updateGameDisplay(playerFieldForPlayer, secondPlayerFieldForPlayer); // Update the game display after the player makes a move.
            // check if the player has won
            checkWhoWonTheGame();// If the player has won the game.

            // if it's the second player's turn
            turn = "Second Player"; // The turn is the second player.
            // then the second player has to make a move
            secondPlayerTurnToMakeAMove(scannerino); // The second player
            // makeSecondPlayerMove();
            // update the field after the second player makes a move
            updateGameDisplay(playerFieldForPlayer, secondPlayerFieldForPlayer); // Update the game display after the second player makes a move.
            // check if the second player has won
        } while (!checkWhoWonTheGame());
        declareWinner(turn); // Declare the winner.
    }

    /**
     * Method used to start game ai vs ai.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void startGameAIvsAI(Scanner scannerino) {
        String turn; // The turn.
        // If the game is over.
        do { // While the game is not over.
            // if it's the second's ai's turn, i.e. the ai who replaces the player
            turn = "Second AI"; // The turn is the second ai.
            // then the second ai has to make a move
            secondAiTurnToMakeAMove(); // The second ai makes a move.
            // makeSecondAIMove();
            // update the field after the second ai makes a move
            // TODO: There must be mistake below
            updateGameDisplay(aiFieldForSecondAi, aiFieldForAi); // Update the game display after the second ai makes a move.
            // check if the second AI has won
            checkWhoWonTheGame();// If the second ai has won the game.

            // if it's the ai's turn,
            turn = "AI"; // The turn is the ai.
            // then the ai has to make a move
            aiTurnToMakeAMove(); // The ai makes a move.
            // makeAIMove();
            // update the field after the ai makes a move
            updateGameDisplay(aiFieldForSecondAi, aiFieldForAi); // Update the game display after the ai makes a move.
            // check if the ai has won
            checkWhoWonTheGame();// If the ai has won the game.

        } while (!checkIfTheGameIsOverAIvsAI());
        declareWinner(turn); // Declare the winner.
    }

    /**
     * Method used to check whether the ai vs ai game is over or not.
     * @return true if the game is over, false otherwise.
     */
    public static boolean checkIfTheGameIsOverAIvsAI() {
        // If the game is over.
        return secondAiRoomsLeft == 0 || aiRoomsLeft == 0;
    }


    /**
     * This method declares the winner of the game.
     * @param lastTurn the turn of the last player.
     */
    public static void declareWinner(String lastTurn) {
        try {
            switch (lastTurn) {
                case "player":
                    Thread.sleep(3000);
                    System.out.println("Finally, a real person has won the game.");
                    player.wonTheGame(); // The player won the game.


                    break;
                case "ai":
                    System.out.println("Wow");
                    Thread.sleep(1000);
                    System.out.println("The computer has");
                    System.out.println("won the game.");
                    ai.wonTheGameAI();
                    break;
                case "Second Player":
                    System.out.println("Person 2 has won the game.");
                    Thread.sleep(1000);
                    System.out.println("Person 1 has lost the game.");
                    player2.wonTheGame();
                    break;
                case "Second AI":
                    System.out.println("Second AI has won the game.");
                    Thread.sleep(1000);
                    System.out.println("First AI has lost the game.");
                    ai2.wonTheGameAI();
                    break;
            }

        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }


    /**
     * This method asks the player to make a move.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void playerTurnToMakeAMove(Scanner scannerino) {
        int x1; // the x coordinate
        int y1; // the y coordinate
        boolean isValid = false; // if the move is valid
        try { // try to get the coordinates
            while (isValid == false) { // while the move is not valid
                x1 = player.shootPlayerRow(scannerino); // get the x coordinate
                y1 = player.shootPlayerCol(scannerino); // get the y coordinate
                if (aiFieldForAi.isValidMoveV2(x1, y1)) { // If the move of the ai is valid.
                    if (aiFieldForAi.checkWhetherHitWasSuccessful(x1, y1)) { // If the move of the ai is a hit.
                        playerScore++; // Increase the player's score.
                        System.out.println("Ship Hit! Congratulations!");
                        System.out.println("Current Score: " + playerScore);
                        aiRoomsLeft--; // Decrease the number of rooms left for the ai.
                        aiFieldForPlayer.setHit(x1, y1);  // Set the hit on the player's field.
                        aiFieldForAi.setHit(x1, y1); // Set the hit on the ai's field.
                    } else { // If the move of the ai is a miss.
                        System.out.println("Ship Missed! Try again!");
                        aiFieldForPlayer.setMissed(x1, y1); // Set the missed on the player's field.
                        aiFieldForAi.setMissed(x1, y1); // Set the missed on the ai's field.
                    }
                    isValid = true; // The move is valid.
                }
            }
        } catch (Exception ex) { // if the move is not valid
            System.out.println(ex.getMessage()); // print the error message
        }
    }




    /**
     * This method asks the ai to make a move.
     */
    public static void aiTurnToMakeAMove() {
        try {  // try to make a move
            int x1;  // x coordinate
            int y1; // y coordinate
            boolean isValid = false; // whether the move is valid. Default is false.
            int[] move; // the move
            while (isValid == false) {
                move = ai.generateAiMove(); // get the move
                x1 = move[0]; // x coordinate
                y1 = move[1]; // y coordinate
                if (playerFieldForPlayer.isValidMoveV2(x1, y1)) { // If the move of the player is valid.
                    if (playerFieldForPlayer.checkWhetherHitWasSuccessful(x1, y1)) { // If the move of the player is a hit.
                        String str = String.format("The Machine has hit your ship at row %d, column %d.\n", x1, y1);
                        System.out.println(str);
                        aiScore++; // Increase the ai's score.
                        System.out.println("Current Score: " + aiScore);
                        secondAiRoomsLeft--; // Decrease the number of rooms left.
                        aiFieldForSecondAi.setHit(x1, y1); // Set the hit in the ai's field.
                        aiFieldForSecondAi.setHit(x1, y1); // Set the hit in the player's field.
                    } else { // If the move of the player is a miss.
                        String str = String.format("The Machine's attack at row %d, column %d has been a miss.\n", x1, y1);
                        System.out.println(str);

                        aiFieldForSecondAi.setMissed(x1, y1); // Set the miss in the player's field.
                        aiFieldForAi.setMissed(x1, y1); // Set the miss in the ai's field.
                    }
                    isValid = true; // The move is valid.
                }
            }
        } catch (Exception ex) { // if the move is not valid.
            System.out.println(ex.getMessage()); // Print the error message.
        }
    }


    /**
     * This method asks the machine to make a move.
     */
    public static void makeAIMove() {
        try {
            Thread.sleep(1000);
            boolean hit = false;
            int x1;
            int y1;
            int[] move;
            while (hit) {
                move = ai.generateAiMove();
                x1 = move[0];
                y1 = move[1];
                // if valid move
                if (playerField.isValidMoveV2(x1, y1)) {
                    if (playerField.checkWhetherHitWasSuccessful(x1, y1)) {
                        System.out.println("AI hit a ship!");
                        Thread.sleep(1000);
                        System.out.println("Your ship was hit at position " + x1 + "," + y1 + ".");
                        Thread.sleep(1000);
                        aiRoomsLeft--;
                        playerField.setHit(x1, y1); // update the player field
                        aiField.setHit(x1, y1); // update the AI field
                    } else {
                        System.out.println("AI missed!");
                        Thread.sleep(1000);
                        System.out.println("Your ship was not hit at position " + x + "," + y + ".");
                        playerField.setMissed(x1, y1); // update the player field
                        aiField.setMissed(x1, y1); // update the AI field
                    }
                    hit = true;
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * This method asks the player to make a move.
     */
    public static void makePlayerMove() {
        try {
            Thread.sleep(1000);
            boolean hit = false;
            int x1;
            int y1;
            int[] move;
            while (hit) {
                move = player.generateRandomPlayerMove();
                x1 = move[0];
                y1 = move[1];
                // if valid move
                if (aiField.isValidMoveV2(x1, y1)) {
                    if (aiField.checkWhetherHitWasSuccessful(x1, y1)) {
                        System.out.println("You hit a ship!");
                        Thread.sleep(1000);
                        System.out.println("AI's ship was hit at position " + x1 + "," + y1 + ".");
                        Thread.sleep(1000);
                        playerRoomsLeft--;
                        aiField.setHit(x1, y1); // update the AI field
                        playerField.setHit(x1, y1); // update the player field
                    } else {
                        System.out.println("You missed!");
                        Thread.sleep(2000);
                        System.out.println("AI's ship was not hit at position " + x + "," + y + ".");
                        aiField.setMissed(x1, y1); // update the AI field
                        playerField.setMissed(x1, y1); // update the player field
                    }
                    hit = true;
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method asks the player what symbol he wants to use for the Ai ships.
     * @param symbol the symbol the player wants to use
     */
    public static void getAiShipSymbol(String symbol) {
        ai = new Ai(symbol, FIELD_SIZE);
    }

    /**
     * This method asks the player what symbol he wants to use for the Ai ships.
     * @param scannerino the scanner that is used to get the input.
     */
    public static void getAiShipSymbol(Scanner scannerino) {
        String input;
        boolean validInput = false;
        while (validInput == false) {
            System.out.println("What symbol do you want to use for your ships?");
            input = scannerino.nextLine();
            if (input.length() != 1) {
                System.out.println("Please enter a single character input.");
                continue;
            } else {
                ai = new Ai(input, FIELD_SIZE);
                validInput = true;
                break;
            }
        }
    }

    /**
     * This method gets the player's symbol.
     * @param scannerino the scanner that is used to get the input.
     */
    public static void getPlayerShipSymbol(Scanner scannerino) {
        String input;
        boolean validInput = false;
        while (validInput == false) {
            System.out.println("What symbol do you want to use for your ships?");
            input = scannerino.nextLine();
            if (input.length() != 1) {
                System.out.println("Please enter a single character input.");
                continue;
            } else {
                player = new Player(input, FIELD_SIZE);
                validInput = true;
                break;
            }
        }
    }

    /**
     * This method gets the second's player symbol.
     * @param scannerino the scanner that is used to get the input.
     */
    public static void getSecondPlayerShipSymbol(Scanner scannerino) {
        String input;
        boolean validInput = false;
        while (validInput == false) {
            System.out.println("What symbol do you want to use for your ships?");
            input = scannerino.nextLine();
            if (input.length() != 1) {
                System.out.println("Please enter a single character input.");
                continue;
            } else {
                player2 = new Player(input, FIELD_SIZE);
                validInput = true;
                break;
            }
        }
    }


    /**
     * This method asks the player what symbol he wants to use for the second Ai ship.
     * @param scannerino the scanner that is used to get the input.
     */
    public static void getSecondAiShipSymbol(Scanner scannerino) {
        String input;
        boolean validInput = false;
        while (validInput == false) {
            System.out.println("What symbol do you want to use for your ships?");
            input = scannerino.nextLine();
            if (input.length() != 1) {
                System.out.println("Please enter a single character input.");
                continue;
            } else {
                ai2 = new Ai(input, FIELD_SIZE);
                validInput = true;
                break;
            }
        }
    }

    /**
     * Get symbol of the second AI player.
     * In this case, the second AI player is the one that is going to replace the player that was doing the move first.
     * @param symbol the symbol of the second AI player.
     */
    public static void getSecondAiShipSymbol(String symbol) {
        ai2 = new Ai(symbol, FIELD_SIZE);
    }



    /**
     * Method that checks who won the game.
     * @return a boolean that is true if the player won the game.
     */
    public static boolean checkWhoWonTheGame() {
        // Or if the AI has no more rooms left.
        if (playerRoomsLeft == 0) {
            System.out.println("You lost!");
            return true;
        }
        // Or if the player has no more rooms left.
        if (aiRoomsLeft == 0) {
            System.out.println("You won!");
            return true;
        }

        // if the second player has no more rooms left.
        if (secondPlayerRoomsLeft == 0) {
            System.out.println("Hey Player 2! You lost!");
            return true;
        }

        // if the second AI has no more rooms left.
        if (secondPlayerRoomsLeft == 0) {
            System.out.println("Hey AI 1! You lost!");
            return true;
        }

        return false;
    }

    /**
     * This method prints the highest score.
     * @param scannerino the scanner that is used to get the input.
     */
    public static void printHighestScore(Scanner scannerino) {
        if (playerScore > aiScore) {
            System.out.println("You won the game with a score of "
                    + playerScore
                    + " to " + aiScore
                    + ".");
        } else if (playerScore < aiScore) {
            System.out.println("You lost the game with a score of "
                    + playerScore
                    + " to " + aiScore
                    + ".");
        } else if (playerScore > secondPlayerScore) {
            System.out.println("Player 1 won the game "
                    + "with a score of "
                    + playerScore
                    + " to " + secondPlayerScore
                    + ".");
        } else if (playerScore < secondPlayerScore) {
            System.out.println("Player 2 won the game with a score of "
                    + playerScore
                    + " to "
                    + secondPlayerScore
                    + ".");
        } else if (aiScore > secondAiScore) {
            System.out.println("AI 1 won the game with a score of "
                    + aiScore
                    + " to " + secondAiScore
                    + ".");
        } else if (aiScore < secondAiScore) {
            System.out.println("AI 2 won the game with a score of "
                    + aiScore
                    + " to " + secondAiScore
                    + ".");
        } else {
            System.out.println("It's a draw!");
        }
    }

    /**
     * The following method adds a second player instead of the AI.
     * @param scannerino the scanner that is used to get the input.
     */
    public static void secondPlayerTurnToMakeAMove(Scanner scannerino) {
        int x2; // the x coordinate
        int y2; // the y coordinate
        boolean isValid = false; // if the move is valid
        try { // try to get the coordinates
            while (isValid) { // while the move is not valid
                x2 = player.shootPlayerRow(scannerino); // get the x coordinate
                y2 = player.shootPlayerCol(scannerino); // get the y coordinate
                if (secondPlayerFieldForPlayer.isValidMoveV2(x2, y2)) { // If the move of the ai is valid.
                    if (secondPlayerFieldForPlayer.checkWhetherHitWasSuccessful(x2, y2)) { // If the move of the ai is a hit.
                        secondPlayerScore++; // Increase the second player's score.
                        System.out.println("The second Player has hit a ship! Congratulations!");
                        System.out.println("Current Score: " + secondPlayerScore);
                        secondPlayerRoomsLeft--; // Decrease the number of rooms left for the ai.
                        secondPlayerFieldForPlayer.setHit(x2, y2);  // Set the hit on the player's field.
                        secondPlayerFieldForPlayer.setHit(x2, y2); // Set the hit on the second player's field.
                    } else { // If the move of the second player is a miss.
                        System.out.println("Hey 2nd player, Ship Missed! Try again!");
                        secondPlayerFieldForPlayer.setMissed(x2, y2); // Set the missed on the player's field.
                        secondPlayerFieldForPlayer.setMissed(x2, y2); // Set the missed on the ai's field.
                    }
                    isValid = true; // The move is valid.
                }
            }
        } catch (Exception ex) { // if the move is not valid
            System.out.println(ex.getMessage()); // print the error message
        }
    }

    /**
     * The following method implements an AI based game between 2 computers.
     */
    public static void secondAiTurnToMakeAMove() {
        try {  // try to make a move
            int x3;  // x coordinate
            int y3; // y coordinate
            boolean isValid = false; // whether the move is valid. Default is false.
            int[] move; // the move
            while (isValid) {
                move = ai2.generateAiMoveForSecondAi(); // get the move
                x3 = move[0]; // x coordinate
                y3 = move[1]; // y coordinate
                if (aiFieldForSecondAi.isValidMoveV2(x3, y3)) { // If the move of the second ai is valid.
                    if (aiFieldForSecondAi.checkWhetherHitWasSuccessful(x3, y3)) { // If the move of the player is a hit.
                        String str = String.format("Machine 2 has hit a ship at row %d, column %d.\n", x3, y3);
                        System.out.println(str);
                        secondAiScore++; // Increase the seconds ai's score.
                        System.out.println("Current Score: " + secondAiScore);
                        secondAiRoomsLeft--; // Decrease the number of rooms left.
                        aiFieldForSecondAi.setHit(x3, y3); // Set the hit in the first ai's field.
                        aiFieldForAi.setHit(x3, y3); // Set the hit in the player's field.
                    } else { // If the move of the player is a miss.
                        String str = String.format("The Machine's attack at row %d, column %d has been a miss.\n", x3, y3);
                        System.out.println(str);

                        aiFieldForSecondAi.setMissed(x3, y3); // Set the miss in the player's field.
                        secondPlayerFieldForAi.setMissed(x3, y3); // Set the miss in the ai's field.
                    }
                    isValid = true; // The move is valid.
                } else { // If the move of the second ai is not valid.
                    System.out.println("The Machine's attack at row " + x3 + ", column " + y3 + " is invalid. Try again.");
                }
            }
        } catch (Exception ex) { // if the move is not valid.
            System.out.println(ex.getMessage()); // Print the error message.
        }

    }

    /**
     * Main method called in the TUI used to start the game.
     * @param scannerino the scanner object that is used to get the user input.
     */
    public static void startGameTest(Scanner scannerino) {
        // check who's turn it is
        String turn; // The turn.
        while (true) { // While the game is not over.
            // do an if condition taking users input and deciding which of the 3
            // game modes we will play: ai vs ai, player vs ai, player vs player
            // and then call the appropriate method to play the game.
            Scanner scanner = new Scanner(System.in);
            System.out.println("What game mode do you want to play?\n"
                    + "1. Player vs Player\n"
                    + "2. Player vs AI\n"
                    + "3. AI vs AI\n"
                    + "4. Exit\n");
            int gameMode = scanner.nextInt();

            if (gameMode == 1) {
                System.out.println("You have chosen to play Player vs Player.\n");
                turn = "Player"; // The turn is the player.
                // then the player1 has to make a move
                playerTurnToMakeAMove(scannerino); // The player makes a move.
                // makePlayerMove();
                // update the field after the player makes a move
                updateGameDisplay(playerFieldForPlayer, secondPlayerFieldForPlayer); // Update the game display after the player makes a move.
                // check if the player has won
                checkWhoWonTheGame();// If the player has won the game.
                // second player has to make a move
                turn = "Second Player"; // The turn is the player.
                secondPlayerTurnToMakeAMove(scannerino); // The second player makes a move.
                // makeSecondPlayerMove();
                // update the field after the second player makes a move
                updateGameDisplay(playerFieldForPlayer, secondPlayerFieldForPlayer); // Update the game display after the second player makes a move.
                // check if the second player has won
                if (checkWhoWonTheGame()) { // If the second player has won the game.
                    break;
                }
            } else if (gameMode == 2) {
                System.out.println("You have chosen to play Player vs AI.\n");
                turn = "Player"; // The turn is the player.
                // then the player1 has to make a move
                playerTurnToMakeAMove(scannerino); // The player makes a move.
                // makePlayerMove();
                // update the field after the player makes a move
                updateGameDisplay(playerFieldForPlayer, aiFieldForPlayer); // Update the game display after the player makes a move.
                // check if the player has won
                checkWhoWonTheGame();// If the player has won the game.
// then the second player has to make a move
                // where the second player is the AI
                turn = "AI"; // The turn is the AI.
                aiTurnToMakeAMove(); // The AI makes a move.
                // update the field after the AI makes a move
                updateGameDisplay(playerFieldForPlayer, aiFieldForPlayer); // Update the game display after the AI makes a move.
                // check if the AI has won
                if (checkWhoWonTheGame()) { // If the AI has won the game.
                    break;
                }

            } else if (gameMode == 3) {
                System.out.println("You have chosen to play AI vs AI.\n");
                turn = "Second AI"; // The turn is the AI.
                // then the second ai (the ai that replaced the player) has to make a move
                secondAiTurnToMakeAMove(); // The second AI makes a move.
                // update the field after the second ai makes a move
                updateGameDisplay(aiFieldForSecondAi, aiFieldForAi); // Update the game display after the second AI makes a move.
                // check if the second ai has won
                checkWhoWonTheGame();// If the second AI has won the game.
                // then the first ai (the ai that replaced the second ai) has to make a move
                turn = "Second AI"; // The turn is the second AI.
                aiTurnToMakeAMove(); // The first AI makes a move.
                // update the field after the first ai makes a move
                updateGameDisplay(aiFieldForSecondAi, aiFieldForAi); // Update the game display after the first AI
                // makes a move., aiFieldForPlayer); // Update the game display after
                // the first AI makes a move.

                // check if the first ai has won
                if (checkWhoWonTheGame()) { // If the first AI has won the game.
                    break;
                }

            } else if (gameMode == 4) {
                // you chose to exit the game
                System.out.println("You have chosen to exit the game.\n");
            }  // else do nothing

        }
        declareWinner(turn); // Declare the winner.
    }


    // ---------- The methods below are not currently used -----------------------------------

    /**
     * This method is used to change the turn of the player/AI.
     * @return true if the turn is changed, false if the turn is not changed
     */
    public boolean changeTurn() {
        return this.turncounter = !turncounter;
    }

    /**
     * This method is used to check if the game is over.
     * @return true if the game is over, false if the game is not over
     */
    // this checks if the game is over
    public boolean isGameOver() {
        return isgameover;
    }

    /**
     * This method is used to check if the game is won.
     * @return true if the game is won, false if the game is not won
     */
    public boolean isGameWon() {
        return isgamewon;
    }

    /**
     * This method is used to check if the game is lost.
     *
     * @return true if the game is lost, false if the game is not lost
     */
    public boolean isGameLost() {
        return isgamelost;
    }

    /**
     * This method is used to return the player's score.
     *
     * @return the player's score.
     */
    public int getScore() {
        return player.getScore();
    }

    /**
     * This method is used to return the AI's score.
     *
     * @return the AI's score.
     */
    public int getAiScore() {
        return ai.getAiScore();
    }

    /**
     * This method is used to return the player's name.
     * @return the player's name.
     */
    public String getPlayerName() {
        return player.getName();
    }

    /**
     * This method is used to return the AI's name.
     * @return the AI's name.
     */
    public String getAiName() {
        return ai.getAiName();
    }

    /**
     * This method is used to set the player's name.
     * @param player the player's name.
     */
    public void setPlayerName(String player) {
        Game.player.setName(player);
    }

    /**
     * The following method is used to shoot.
     * It checks if the shot is valid with respect to the board coordinates.
     * If the shot is valid, it checks if the shot is a hit or a miss.
     * This method is used in the TUI.
     * @param x1 the x coordinate of the shot.
     * @param y1 the y coordinate of the shot.
     * @return true if the shot is a hit, false if the shot is a miss.
     */
    public boolean shoot(final int x1, final int y1) {
        boolean result = false; // this is the default value of the boolean
        if (x1 < 0 || x1 > 9 || y1 < 0 || y1 > 9) { // checks if the shot is valid, which is not.
            System.out.println("Invalid coordinates.");
        } else { // if the shot is valid
            fieldShot.shootGrid(x1, y1); // this is the shot
            if (fieldShips.shootAtCell(x1, y1)) { // if the shot, shot at a cell is a hit
                // increment the number of shots
                this.shipsShot++;
                result = true; // the shot is a hit
            }
        }
        return result; // return true if the shot is a hit, false if the shot is a miss.
    }


    /**
     * This method returns the x coordinate.
     *
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * This method set the x coordinate.
     * @param x1 the x coordinate.
     */
    public void setX(int x1) {
        x = x1;
    }

    /**
     * This method returns the y coordinate.
     * @return the y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * This method sets the y coordinate.
     * @param y1 the y coordinate.
     */
    public void setY(int y1) {
        y = y1;
    }
}
