package model;

import static model.Field.FIELD_SIZE;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;



/**
 * The second player in the game.
 * Note(!) The computer opponent (AI class) is a totally different class.
 * Player subclass that inherits from GamePlayers.
 * @author kelvin.likollari@usi.ch and ilker.kaymak@usi.ch
 */
public class Player extends GamePlayers {

    private String name;
    private int score = 0; // initially the score is 0.
    private int playernumber;

    private final int shipsnumber = 5;

    public static final String BLUE_COLOR = "B";

    /**
     * Player constructor.
     * @param symbol The symbol of the player.
     * @param fieldLength The length of the field.
     */
    public Player(String symbol, int fieldLength) {
        super(fieldLength);
        this.setSymbol(symbol);
    }

    /**
     * Empty Constructor for the Player class.
     * Empty constructors are used to create objects without initializing their fields.
     */
    public Player() {
        // dummy constructor so that the game.java constructor works.
    }

    /**
     * Dummy constructor to help for testing purposes.
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the player.
     * @return The name of the player as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player number.
     * @return The player number
     */
    public int getPlayerNumber() {
        return playernumber;
    }


    /**
     * Returns the score of the player.
     * @return The score of the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the player.
     * @param points The points to be added to the score
     */
    public void setScore(int points) {
        score += points;
    }

    /**
     * Returns the name of the player as a string.
     * @return The name of the player as a string representation.
     */
    public String toString() {
        return name;
    }


    /**
     * This method is used to get the number of ships of the player.
     * @return The number of ships of the player.
     */
    public int getShips() {
        return shipsnumber;
    }


    /**
     * This method is used to set the player's/ai's name.
     * @param player The name of the player/ai
     */
    public void setName(String player) {
        this.name = player;
    }


    /**
     * This method gets the symbol of the player.
     * @return The symbol of the player.
     */
    public String getSymbol() {
        return this.BLUE_COLOR + this.symbol + this.RESET_COLOR;
    }


    /**
     * Method tha signifies that the player has won the game.
     */
    public void wonTheGame() {
        System.out.println("VVVVVVVV           VVVVVVVVIIIIIIIIII      CCCCCCCCCCCCCTTTTTTTTTTTTTTTTTTTTTTT     OOOOOOOOO     RRRRRRRRRRRRRRRRR   YYYYYYY       YYYYYYY !!!");
        System.out.println("V::::::V           V::::::VI::::::::I   CCC::::::::::::CT:::::::::::::::::::::T   OO:::::::::OO   R::::::::::::::::R  Y:::::Y       Y:::::Y!!:!!");
        System.out.println("V::::::V           V::::::VI::::::::I CC:::::::::::::::CT:::::::::::::::::::::T OO:::::::::::::OO R::::::RRRRRR:::::R Y:::::Y       Y:::::Y!:::!");
        System.out.println("V::::::V           V::::::VII::::::IIC:::::CCCCCCCC::::CT:::::TT:::::::TT:::::TO:::::::OOO:::::::ORR:::::R     R:::::RY::::::Y     Y::::::Y!:::!");
        System.out.println("V:::::V           V:::::V   I::::I C:::::C       CCCCCCTTTTTT  T:::::T  TTTTTTO::::::O   O::::::O  R::::R     R:::::RYYY:::::Y   Y:::::YYY!:::!");
        System.out.println("V:::::V         V:::::V    I::::IC:::::C                      T:::::T        O:::::O     O:::::O  R::::R     R:::::R   Y:::::Y Y:::::Y   !:::!");
        System.out.println("V:::::V       V:::::V     I::::IC:::::C                      T:::::T        O:::::O     O:::::O  R::::RRRRRR:::::R     Y:::::Y:::::Y    !:::!");
        System.out.println("V:::::V     V:::::V      I::::IC:::::C                      T:::::T        O:::::O     O:::::O  R:::::::::::::RR       Y:::::::::Y     !:::!");
        System.out.println("V:::::V   V:::::V       I::::IC:::::C                      T:::::T        O:::::O     O:::::O  R::::RRRRRR:::::R       Y:::::::Y      !:::!");
        System.out.println("V:::::V V:::::V        I::::IC:::::C                      T:::::T        O:::::O     O:::::O  R::::R     R:::::R       Y:::::Y       !:::!");
        System.out.println("V:::::V:::::V         I::::IC:::::C                      T:::::T        O:::::O     O:::::O  R::::R     R:::::R       Y:::::Y       !!:!!");
        System.out.println("V:::::::::V          I::::I C:::::C       CCCCCC        T:::::T        O::::::O   O::::::O  R::::R     R:::::R       Y:::::Y        !!! ");
        System.out.println("V:::::::V         II::::::IIC:::::CCCCCCCC::::C      TT:::::::TT      O:::::::OOO:::::::ORR:::::R     R:::::R       Y:::::Y");
        System.out.println("V:::::V          I::::::::I CC:::::::::::::::C      T:::::::::T       OO:::::::::::::OO R::::::R     R:::::R    YYYY:::::YYYY     !!!");
        System.out.println("V:::V           I::::::::I   CCC::::::::::::C      T:::::::::T         OO:::::::::OO   R::::::R     R:::::R    Y:::::::::::Y    !!:!!");
        System.out.println("VVV            IIIIIIIIII      CCCCCCCCCCCCC      TTTTTTTTTTT           OOOOOOOOO     RRRRRRRR     RRRRRRR    YYYYYYYYYYYYY     !!!");
        System.exit(0);

    }

    /**
     * Method that lets the player shoot a row.
     * @param scannerino the scanner that will be used to get the input from the user
     * @return the row that the player wants to shoot as an integer
     */
    public int shootPlayerRow(Scanner scannerino) {
        int row = 0; // row number
        int col = 0; // column number
        boolean valid = false; // boolean to check if the input is valid
        // the input is valid if the input is a number between 0 and 9
        while (valid == false) { // while the input is not valid
            // print the message to the user
            System.out.println("Enter the row number you want to attack: ");
            if (scannerino.hasNextInt()) { // if the input is an integer
                int input = scannerino.nextInt(); // get the input
                if (input < 0 || input >= this.fieldLength) { // if the input is not between 0 and 9
                    System.out.println("Invalid input. Please enter a number between 0 and 9.");
                } else { // if the input is between 0 and 9
                    row = input; // set the row number
                    valid = true; // set the boolean to true
                }
            } else if (scannerino.hasNextLine()) { // if the input is a string
                scannerino.nextLine(); // get the input
                int bufferLength = 0; // buffer length
                try { // try to get the length of the input
                    bufferLength = System.in.available(); // checks if the system.in buffer is empty
                    // TODO: Fix empty catch block
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if (bufferLength > 0) { // if the input is not empty
                    scannerino.nextLine(); // get the input
                }
                // print the message to the user
                System.out.println("Invalid input. Please enter a number between 0 and 9.");
            }
        }
        return row;
    }

    /**
     * Method that lets the player shoot a column.
     * @param scannerino the scanner that will be used to get the input from the user
     * @return the column that the player wants to shoot as an integer
     */
    // similar to above, now attack the column instead
    public int shootPlayerCol(Scanner scannerino) {
        int row = 0; // row number
        int col = 0; // column number
        boolean valid = false; // boolean to check if the input is valid
        // the input is valid if the input is a number between 0 and 9
        while (valid == false) { // while the input is not valid
            // print the message to the user
            System.out.println("Enter the column number you want to attack: ");
            if (scannerino.hasNextInt()) { // if the input is an integer
                int input = scannerino.nextInt(); // get the input
                if (input < 0 || input >= this.fieldLength) { // if the input is not between 0 and 9
                    System.out.println("Invalid input. Please enter a number between 0 and 9.");
                } else { // if the input is between 0 and 9
                    col = input; // set the row number
                    valid = true; // set the boolean to true
                }
            } else if (scannerino.hasNextLine()) { // if the input is a string
                scannerino.nextLine(); // get the input
                int bufferLength = 0; // buffer length
                try { // try to get the length of the input
                    bufferLength = System.in.available(); // checks if the system.in buffer is empty
                } catch (IOException ex) { // if something goes wrong
                    ex.printStackTrace(); // print the stack trace
                }
                if (bufferLength > 0) { // if the input is not empty
                    scannerino.nextLine(); // get the input}
                    // print the message to the user
                    System.out.println("Invalid input. Please enter a number between 0 and 9.");
                }
            }
        }
        return col;
    }

    /**
     * Method that asks the user in which row shall the ship be placed.
     * @param scannerino the scanner that will be used to get the input from the user
     * @return the row number where the ship shall be placed as an integer
     */
    // WHERE DOES THE PLAYER WANT TO PUT THEIR SHIP (row)
    public int inWhichRowToPutShip(Scanner scannerino) {
        int row = 0; // row number
        int col = 0; // column number
        boolean valid = false; // boolean to check if the input is valid
        // the input is valid if the input is a number between 0 and 9
        while (valid == false) { // while the input is not valid
            // print the message to the user
            System.out.println("Enter the row number you want to place your ship: ");
            if (scannerino.hasNextInt()) { // if the input is an integer
                int input = scannerino.nextInt(); // get the input
                if (input < 0 || input > this.fieldLength - 1) { // if the input is not between 0 and 9
                    System.out.println("Invalid input.");
                    continue;
                } // if the input is between 0 and 9
                row = input; // set the row number
                valid = true; // set the boolean to true
            } else if (scannerino.hasNextLine()) { // if the input is a string
                scannerino.nextLine(); // get the input
                int bufferLength = 0; // buffer length
                try { // try to get the length of the input
                    bufferLength = System.in.available(); // checks if the system.in buffer is empty
                } catch (IOException ex) { // if something goes wrong
                    ex.printStackTrace(); // print the stack trace
                }
                if (bufferLength > 0) { // if the input is not empty
                    scannerino.nextLine(); // get the input
                }
                // print the message to the user
                System.out.println("Invalid input.");
            }
        }
        return row;
    }

    /**
     * Method that asks the user in which column shall the ship be placed.
     * @param scannerino the scanner that will be used to get the input from the user
     * @return the column number where the ship shall be placed as an integer
     */
    public int inWhichRowToPutShipForSecondPlayer(Scanner scannerino) {
        int row = 0; // row number
        int col = 0; // column number
        boolean valid = false; // boolean to check if the input is valid
        // the input is valid if the input is a number between 0 and 9
        while (valid == false) { // while the input is not valid
            // print the message to the user
            System.out.println("Enter the row number you want to place your ship: ");
            if (scannerino.hasNextInt()) { // if the input is an integer
                int input = scannerino.nextInt(); // get the input
                if (input < 0 || input > this.fieldLength - 1) { // if the input is not between 0 and 9
                    System.out.println("Invalid input.");
                    continue;
                } // if the input is between 0 and 9
                row = input; // set the row number
                valid = true; // set the boolean to true
            } else if (scannerino.hasNextLine()) { // if the input is a string
                scannerino.nextLine(); // get the input
                int bufferLength = 0; // buffer length
                try { // try to get the length of the input
                    bufferLength = System.in.available(); // checks if the system.in buffer is empty
                } catch (IOException ex) { // if something goes wrong
                    ex.printStackTrace(); // print the stack trace
                }
                if (bufferLength > 0) { // if the input is not empty
                    scannerino.nextLine(); // get the input
                }
                // print the message to the user
                System.out.println("Invalid input.");
            }
        }
        return row;
    }

    /**
     * Method that asks the user in which column shall the ship be placed.
     * @param scannerino the scanner that will be used to get the input from the user
     * @return the column number where the ship shall be placed as an integer
     */
    // WHERE DOES THE PLAYER WANT TO PUT THEIR SHIP (column)
    public int inWhichColToPutShip(Scanner scannerino) {
        int row = 0; // row number
        int col = 0; // column number
        boolean valid = false; // boolean to check if the input is valid
        // the input is valid if the input is a number between 0 and 9
        while (valid == false) { // while the input is not valid
            // print the message to the user
            System.out.println("Enter the column number you want to place your ship: ");
            if (scannerino.hasNextInt()) { // if the input is an integer
                int input = scannerino.nextInt(); // get the input
                if (input < 0 || input > this.fieldLength - 1) { // if the input is not between 0 and 9
                    System.out.println("Invalid input.");
                }
                col = input; // set the row number
                valid = true; // set the boolean to true
            } else if (scannerino.hasNextLine()) { // if the input is a string
                scannerino.nextLine(); // get the input
                int bufferLength = 0; // buffer length
                try { // try to get the length of the input
                    bufferLength = System.in.available(); // checks if the system.in buffer is empty
                } catch (IOException ex) { // if something goes wrong
                    ex.printStackTrace(); // print the stack trace
                }
                if (bufferLength > 0) { // if the input is not empty
                    scannerino.nextLine(); // get the input
                }
                // print the message to the user
                System.out.println("Invalid input.");
            }
        }
        return col;
    }

    /**
     * Method that asks the user in which column shall the ship be placed.
     * @param scannerino the scanner that will be used to get the input from the user
     * @return the column number where the ship shall be placed as an integer
     */
    public int inWhichColToPutShipForSecondPlayer(Scanner scannerino) {
        int row = 0; // row number
        int col = 0; // column number
        boolean valid = false; // boolean to check if the input is valid
        // the input is valid if the input is a number between 0 and 9
        while (valid == false) { // while the input is not valid
            // print the message to the user
            System.out.println("Enter the column number you want to place your ship: ");
            if (scannerino.hasNextInt()) { // if the input is an integer
                int input = scannerino.nextInt(); // get the input
                if (input < 0 || input > this.fieldLength - 1) { // if the input is not between 0 and 9
                    System.out.println("Invalid input.");
                }
                col = input; // set the row number
                valid = true; // set the boolean to true
            } else if (scannerino.hasNextLine()) { // if the input is a string
                scannerino.nextLine(); // get the input
                int bufferLength = 0; // buffer length
                try { // try to get the length of the input
                    bufferLength = System.in.available(); // checks if the system.in buffer is empty
                } catch (IOException ex) { // if something goes wrong
                    ex.printStackTrace(); // print the stack trace
                }
                if (bufferLength > 0) { // if the input is not empty
                    scannerino.nextLine(); // get the input
                }
                // print the message to the user
                System.out.println("Invalid input.");
            }
        }
        return col;
    }

    /**
     * Method that after having placed the ships, asks for the user to specify the direction of the ship.
     * @param scannerino the scanner that will be used to get the input from the user
     * @return the direction of the ship as a string
     */
    public String whichDirectionToPutShip(Scanner scannerino) {
        String direction;
        while (true) {
            if (scannerino.hasNextLine()) { // if the input is a string
                scannerino.nextLine(); // get the input
                int bufferLength = 0; // buffer length
                try { // try to get the length of the input
                    bufferLength = System.in.available(); // checks if the system.in buffer is empty
                } catch (IOException ex) { // if something goes wrong
                    ex.printStackTrace(); // print the stack trace
                }
                if (bufferLength > 0) { // if the input is not empty
                    scannerino.nextLine(); // get the input
                }
            }
            // print the message to the user
            System.out.println("Enter the direction you want to place your ship: ");
            // Thread.sleep(1000); // wait 1 second
            System.out.println("(H)orizontally or (V)ertically? ");
            // Thread.sleep(1000); // wait 1 second
            if (scannerino.hasNextLine()) { // if the input is a string
                String input = scannerino.nextLine(); // get the input
                if (input.equals("H") || input.equals("h")) { // if the input is H or h
                    direction = input; // set the direction to input
                    break; // break the loop
                } else if (input.equals("V") || input.equals("v")) { // if the input is V or v
                    direction = input; // set the direction to input
                    break; // break the loop
                } else { // if the input is not H or h or V or v
                    System.out.println("Invalid input " + input + ".");
                }
            }
        }
        return direction;
    }

    /**
     * Method that asks the user in which direction shall the ship point to.
     * @param scannerino the scanner that will be used to get the input from the user
     * @return the direction where the ship shall point as a string.
     */
    public String whichDirectionToPutShipForSecondPlayer(Scanner scannerino) {
        String direction;
        while (true) {
            if (scannerino.hasNextLine()) { // if the input is a string
                scannerino.nextLine(); // get the input
                int bufferLength = 0; // buffer length
                try { // try to get the length of the input
                    bufferLength = System.in.available(); // checks if the system.in buffer is empty
                } catch (IOException ex) { // if something goes wrong
                    ex.printStackTrace(); // print the stack trace
                }
                if (bufferLength > 0) { // if the input is not empty
                    scannerino.nextLine(); // get the input
                }
            }
            // print the message to the user
            System.out.println("Enter the direction you want to place your ship: ");
            // Thread.sleep(1000); // wait 1 second
            System.out.println("(H)orizontally or (V)ertically? ");
            // Thread.sleep(1000); // wait 1 second
            if (scannerino.hasNextLine()) { // if the input is a string
                String input = scannerino.nextLine(); // get the input
                if (input.equals("H") || input.equals("h")) { // if the input is H or h
                    direction = input; // set the direction to input
                    break; // break the loop
                } else if (input.equals("V") || input.equals("v")) { // if the input is V or v
                    direction = input; // set the direction to input
                    break; // break the loop
                } else { // if the input is not H or h or V or v
                    System.out.println("Invalid input " + input + ".");
                }
            }
        }
        return direction;
    }

    /**
     * Method that generates a random X coordinate for the player's ship.
     * @return the random X coordinate
     */
    public int generateRandomPlayerXCoordinate() {
        Random random = new Random();
        return random.nextInt(FIELD_SIZE);
    }

    /**
     * Method that generates a random Y coordinate for the player's ship.
     * @return the random Y coordinate
     */
    public int generateRandomPlayerYCoordinate() {
        Random random = new Random();
        return random.nextInt(FIELD_SIZE);
    }


    /**
     * Method that generates a random player move.
     * @return the random player move as a 2D array containing the X and Y coordinates.
     */
    // generate random move for the AI
    public int[] generateRandomPlayerMove() {
        int[] randomMove = new int[2]; // an array with two elements, x and y coordinates
        randomMove[0] = generateRandomPlayerXCoordinate(); // set x coordinate randomly
        randomMove[1] = generateRandomPlayerYCoordinate(); // set y coordinate randomly
        return randomMove;
    }




}