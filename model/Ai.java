package model;


import static model.Field.FIELD_SIZE; // this should be before any other import and separated by a blank line

import java.util.Random;



/**
 * AI class used to represent the opponent of the game, which in this case is the computer itself.
 * This is the class AI that inherits from GamePlayer.
 * @author kelvin.likollari@usi.ch and ilker.kaymak@usi.ch
 */
public class Ai extends GamePlayers
{

    private int aiscore = 0;
    private static final String AI_NAME = "Mr. Computer  ( ͡° ͜ʖ ͡°)";

    private static final int AI_SHIPS_NUMBER = 5;

    /**
     * Constructor for objects of class Ai.
     * @param name the name of the Ai.
     * @param fieldLength the length of the field.
     */
    public Ai(String name, int fieldLength)
    {
        super(fieldLength);
        String symbol = generateRandomSymbol(name);
        this.setSymbol(symbol); // from GamePlayer class
    }

    /**
     * Constructor added for line 13 of model/main.java to be able to create an Ai object.
     */
    public Ai() {
        super();
    }

    /**
     * The following method generates a random symbol for the Ai.
     * @param name the name of the Ai.
     * @return the random symbol for the Ai.
      */
    public String generateRandomSymbol(String name) {
        String symbol = "";
        Random rand = new Random();
        int random = rand.nextInt(2);
        if (random == 0) {
            symbol = "X";
        } else {
            symbol = "O";
        }
        return symbol;
    }

    /**
     * This method is used to set the score of the Ai.
     * @return the score of the Ai.
     */
    public int getAiScore()
    {
        return aiscore;
    }

    /**
     * This method is used to set the name of the Ai.
     * @return the name of the Ai.
     */
    public String getAiName() {
        return AI_NAME;
    }


    /**
     * This method is used to get the number of ships of the ai.
     * @return The number of ships of the ai.
     */
    public int getShips() {
        return AI_SHIPS_NUMBER;
    }

    /**
     * Method that generates a random X coordinate
     * for the AI.
     * @return the random X coordinate.
     */
    public int generateRandomAiXCoordinate() {
        Random random = new Random();
        return random.nextInt(FIELD_SIZE);
    }

    /**
     * Method that generates a random Y coordinate for the AI.
     * @return the random Y coordinate.
     */
    public int generateRandomAiYCoordinate() {
        Random random = new Random();
        return random.nextInt(FIELD_SIZE);
    }


    /**
     * Method that generates a random move for the AI.
     * @return the random move (i.e. its coordinates).
     */
    public int[] generateAiMove() {
        int[] randomMove = new int[2]; // an array with two elements, x and y coordinates
        randomMove[0] = generateRandomAiXCoordinate(); // set x coordinate randomly
        randomMove[1] = generateRandomAiYCoordinate(); // set y coordinate randomly
        return randomMove;
    }

    /**
     * Method that generates a random move for the second AI (the AI that replaces the player,
     * so that now we have an AI vs AI game).
     * @return the random move (i.e. its coordinates).
     */
    public int[] generateAiMoveForSecondAi() {
        int[] randomMove = new int[2]; // an array with two elements, x and y coordinates
        randomMove[0] = generateRandomSecondAiXCoordinate(); // set x coordinate randomly
        randomMove[1] = generateRandomSecondAiYCoordinate(); // set y coordinate randomly
        return randomMove;
    }
    
    /**
     * Method that generates a random x coordinate for the AI.
     * @return An int representing the x coordinate.
     */
    public int generateRandomSecondAiXCoordinate() {
        Random random = new Random();
        return random.nextInt(FIELD_SIZE);
    }
    
    /**
     * Method that generates a random y coordinate for the AI.
     * @return An int representing the y coordinate.
     */
    public int generateRandomSecondAiYCoordinate() {
        Random random = new Random();
        return random.nextInt(FIELD_SIZE);
    }

    /**
     * Method signifying that the AI has won the game.
     */
    public void wonTheGameAI() {
        System.out.println(
                "░░░░░░░░░░░░▄▄▄▄░░░░░░░░░░░░░░░░░░░░░░░▄▄▄▄▄\n"
                        +
                        "░░░█░░░░▄▀█▀▀▄░░▀▀▀▄░░░░▐█░░░░░░░░░▄▀█▀▀▄░░░▀█▄\n"
                        +
                        "░░█░░░░▀░▐▌( ͡° ͜ʖ ͡°)▐▌░░░▀░░░▐█░░░░░░░░▀░▐▌( ͡° ͜ʖ ͡°)▐▌░░█▀\n"
                        +
                        "░▐▌░░░░░░░▀▄▄▀░░░░░░░░░░▐█▄▄░░░░░░░░░▀▄▄▀░░░░░▐▌\n"
                        +
                        "░█░░░░░░░░░░░░░░░░░░░░░░░░░▀█░░░░░░░░░░░░░░░░░░█\n"
                        +
                        "▐█░░░░░░░░░░░░░░░░░░░░░░░░░░█▌░░░░░░░░░░░░░░░░░█\n"
                        +
                        "▐█░░░░░░░░░░░░░░░░░░░░░░░░░░█▌░░░░░░░░░░░░░░░░░█\n"
                        +
                        "░█░░░░░░░░░░░░░░░░░░░░█▄░░░▄█░░░░░░░░░░░░░░░░░░█\n"
                        +
                        "░▐▌░░░░░░░░░░░░░░░░░░░░▀███▀░░░░░░░░░░░░░░░░░░▐▌\n"
                        +
                        "░░█░░░░░░░░░░░░░░░░░▀▄░░░░░░░░░░▄▀░░░░░░░░░░░░█\n"
                        +
                        "░░░█░░░░░░░░░░░░░░░░░░▀▄▄▄▄▄▄▄▀▀░░░░░░░░░░░░░█\n"
                        +
                        "░░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█\n"
                        +
                        "░░░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█\n"
                        +
                        "░░░░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█\n"
                        +
                        "░░░░░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█\n"
                        +
                        "░░░░░░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█\n"
                        +
                               "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█\n"
                        +
                        "░░░░░░░░░░░░░░░░░░░░░░░░░█\n"
                        + "░░░░░░░░░░░░░░░░░░░░░░░░░█\n"
        );
    }
}

