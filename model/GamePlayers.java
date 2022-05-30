package model;

import java.util.Random;

/**
 * This class represents the players of the game.
 * We have two players: the human player and the computer player.
 * This class will be used in order for the player and the AI to inherit from it.
 * @author kelvin.likollari@usi.ch
 */

// SUPERCLASS GamePlayers.
public class GamePlayers {

    /**
     * The name of the player.
     */
    private String name;
    private GamePlayers player;

    private static Random random = new Random();

    /**
     * The score of the player.
     */
    private int score = 0;

    private Field field;

    protected String symbol;

    protected int fieldLength = 10;
    protected static final String RESET_COLOR = "R";
    protected static final String BLUE_COLOR = "B";


    /**
     * The constructor of the GamePlayers class.
     * @param name  The name of the player.
     * @param score The score of the player.
     * @param field The field of the game.
     *
     */
    public GamePlayers(String name, int score, Field field) {
        this.name = name;
        this.score = score;
        this.field = field;
    }

    /**
     * Empty constructor.
     * Empty constructors are often used in order to create objects of a class.
     */
    public GamePlayers() {
        // empty constructor used for initialization purposes.

    }

    /**
     * Constructor for the game players.
     * @param fieldLength The length of the field.
     */
    public GamePlayers(int fieldLength) {
        this.fieldLength = fieldLength;
    }

    /**
     * Getter method for the name of the player.
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the score of the player.
     * @return The score of the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter method for the name of the player.
     * @param name The name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for the score of the player.
     * @param score The score of the player.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * This method will be used in order to increase the score of the player.
     */
    public void increaseScore() {
        score++;
    }

    /**
     * This method will be used in order to decrease the score of the player.
     */
    public void decreaseScore() {
        score--;
    }

    /**
     * This method will be used in order to reset the score of the player.
     */
    public void resetScore() {
        score = 0;
    }

    /**
     * This method will be used in order to print the score of the player.
     * @return The score of the player.
     */
    //public String toString() {
    //return "Score: " + score;
    //}

    /**
     * Method checking if the game player is alive.
     * @return True if the player is alive, false otherwise.
     */
    public boolean isAlive() {
        return true;
    }

    /**
     * Method that returns the Grid.
     * @return The grid of the game.
     */
    public Field getField() {
        return field;
    }

    /**
     * This method will be used in order to decide whether a shot is valid or not, no matter
     * by whom the shot is made.
     * @param shot     The shot that is made.
     * @param opponent The opponent of the player.
     * @return True if the shot is valid, false otherwise.
     */
    public boolean validShot(int[] shot, GamePlayers opponent) {
        // TODO: How to Decide if a shot was valid
        // if you shot a cell in the field (be in a 0-9 range
        // if you shot a cell that is not already shot.
        // if you hit a cell that is has already been hit, print "You already shot there"
        return true;
    }

    /**
     * Getter method used to get a game player's symbol.
     * @return The symbol of the game player.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Setter method used to set a game player's symbol.
     * @param symbol The symbol of the game player.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *The following method generates a  randomX coordinate.
     * @return The randomX coordinate.
     */
    public int generateRandomXCoordinate() {
        return random.nextInt(fieldLength);
    }

    /**
     * The following method generates a random X coordinate for the second player.
     * @return The randomX coordinate.
     */
    public int generateRandomXCoordinateForSecondPlayer() {
        return random.nextInt(fieldLength);
    }

    /**
     * The following method generates a random Y coordinate for the second player.
     * @return The randomY coordinate.
     */
    public int generateRandomYCoordinateForSecondPlayer() {
        return random.nextInt(fieldLength);
    }

    /**
     * The following method generates a random X coordinate for the second ai.
     * @return The random X coordinate.
     */
    public int generateRandomXCoordinateForSecondAI() {
        return random.nextInt(fieldLength);
    }

    /**
     * The following method generates a random Y coordinate for the second ai.
     * @return The random Y coordinate.
     */
    public int generateRandomYCoordinateForSecondAI() {
        return random.nextInt(fieldLength);
    }



    /**
     * The following method generates a randomY coordinate.
     * @return The randomY coordinate.
     */
    public int generateRandomYCoordinate() {
        return random.nextInt(fieldLength);
    }

    //    /**
    //     * The following method generates a random Move.
    //     * @return The random Move as a coordinate array.
    //     */
    //    public int[] generateMove() {
    //        int[] move = new int[2];
    //        move[0] = generateRandomXCoordinate();
    //        move[1] = generateRandomYCoordinate();
    //        return move;
    //    }


    /**
     * The following method generates a random direction for the AI.
     * @return The random direction for the AI.
     */
    public String generateRandomDirectionForAi() {
        int randomNumber = random.nextInt(100); // generate a random number between 0 and 1
        if (randomNumber <= 50) { // if the random number is 0
            return "v"; // return V
        }
        return "h"; // return H
    }

    /**
     * The following method generates a random direction for the second player.
     * @return The random direction for the second player.
     */
    public String generateRandomDirectionForSecondPlayer() {
        int randomNumber = random.nextInt(100); // generate a random number between 0 and 1
        if (randomNumber <= 50) { // if the random number is 0
            return "v"; // return Vs
        }
        return "h"; // return H
    }

    /**
     * The following method generates a random direction for the second ai.
     * @return The random direction for the second ai.
     */
    public String generateRandomDirectionForSecondAI() {
        int randomNumber = random.nextInt(100); // generate a random number between 0 and 1
        if (randomNumber <= 50) { // if the random number is 0
            return "v"; // return Vs
        }
        return "h"; // return H
    }


    /**
     * getPlayer is a method that returns the player.
     * @return The player.
     */
    public GamePlayers getPlayer() {
        return player;
    }
}
