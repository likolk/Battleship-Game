package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Field class containing the information of the grids on which the game is played.
 * We have 2 types of grids: one for the player and one for the computer.
 * This is a 10x10 grid, containing 5 ships of different sizes.
 * @author kelvin.likollari@usi.ch
 */
public class Field {
    public static final int FIELD_SIZE = 10;
    private boolean[][] arrayfield = new boolean[FIELD_SIZE][FIELD_SIZE];
    private static int toggleNum = 0; // toggle number
    /**
     * Cells field denoting the 100 cells of the grid.
     */
    private static final Cell[][] cells = new Cell[10][10];
    /**
     * Ship field containing the ships of the game.
     */
    private static final Ship[][] SHIPS_PRESENT = new Ship[10][10];

    private static final JButton[][] CELL_BUTTONS = new JButton[10][10];

    /**
     * Constructor for objects of class Field.
     */
    public Field() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }


    /**
     * Constructor created explicitly for testing purposes.
     *
     * @param iindex the i value of the arrayField.
     * @param jindex the j value of the arrayField.
     */
    public Field(int iindex, int jindex) {

        // Array is stored directly, so we use Arrays.copyOf()
        // this.arrayfield = new boolean[iindex][jindex];
        for (int i = 0; i < iindex; i++) {
            this.arrayfield[i] = Arrays.copyOf(arrayfield[i], jindex);
        }

    }

    /**
     * Method to set the value of the arrayField.
     *
     * @param arrayfield the arrayField to set.
     */
    public void setArrayField(boolean[][] arrayfield) {
        // The user-supplied array 'arrayfield' is stored directly.
        // so we wrap it in an array of the same type.
        this.arrayfield = Arrays.copyOf(arrayfield, arrayfield.length);
    }

    /**
     * Method to set the value of the arrayField.
     * Method created explicitly for testing purposes. TODO: Might have to be removed.
     *
     * @param arrayfield the arrayField to set.
     */
    public void setArrayFieldV2(Field arrayfield) {
        this.arrayfield = arrayfield.getArrayField();
    }

    /**
     * Method to get the value of the arrayField.
     * @return arrayField the arrayField.
     */
    public boolean[][] getArrayField() {
        // Returning 'arrayfield' may expose an internal array so we copy it.
        return Arrays.copyOf(arrayfield, arrayfield.length);
    }

    /**
     * Method to set the value of a specific cell in the arrayField.
     * @param x1    the x coordinate of the cell
     * @param y1    the y coordinate of the cell
     * @param value the value to set
     */
    public void setCellValue(int x1, int y1, boolean value) {
        this.arrayfield[x1][y1] = value;
    }

    /**
     * Method to get the value of a specific cell in the arrayField.
     * @param x1 the x coordinate of the cell
     * @param y1 the y coordinate of the cell
     * @return value of the cell
     */
    public boolean getCellValue(final int x1, final int y1) {
        return this.arrayfield[x1][y1];
    }

    /**
     * This method is used to know the content of a cell in the 2D array.
     *
     * @param x1 the x coordinate of the cell.
     * @param y1 the y coordinate of the cell.
     * @return boolean true if the cell is occupied, false otherwise.
     */
    public boolean getCell(final int x1, final int y1) {
        return this.arrayfield[x1][y1];
    }


    /**
     * Method to check if the arrayField is full.
     *
     * @return boolean true if the arrayField is full, false otherwise
     */
    public boolean isFull() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!(this.arrayfield[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to check if the arrayField is empty.
     *
     * @return boolean true if the arrayField is empty, false otherwise
     */
    public boolean isEmpty() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.arrayfield[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to check if the arrayField is valid.
     *
     * @return boolean true if the arrayField is valid, false otherwise.
     */
    public boolean isValid() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.arrayfield[i][j]) {
                    // TODO: Check if this is correct.
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to get the field (board) of the Battleship game.
     * @return the field (board) of the Battleship game.
     */
    public String[][] getField() {
        // produces a null pointer exception if the arrayfield is not initialized
        String[][] field = new String[10][10];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = cells[i][j].getSymbol();
            }
        }
        return field;
    }

    // ----------------------- SHOOT METHODS --------------------------------


    /**
     * This method is used to check whether the player has hit a cell
     * that has already been hit before.
     * Also, we print a corresponding message to the player.
     *
     * @param x1 the x coordinate of the cell.
     * @param y1 the y coordinate of the cell.
     */

    // was boolean, changed to void
    public void shootGrid(final int x1, final int y1) {
        if (arrayfield[y1][x1]) {
            System.out.println("You already shot in position " + x1 + "," + y1 + ".");
        } else {
            setCellTrue(x1, y1);
            //cells[x1][y1].setSymbol("X");
        }
    }

    /**
     * This method shoots at a cell.
     *
     * @param x1 the x coordinate of the cell.
     * @param y1 the y coordinate of the cell.
     * @return true if you hit a ship, false in any other case.
     */
    public boolean shootAtCell(final int x1, final int y1) {
        boolean hasShot = false; // boolean to check if the cell has been shot - in the beginning it is false.
        if (getCell(x1, y1)) {
            removeShip(x1, y1);
            System.out.println("You hit a ship!");
            hasShot = true;
        } else {
            System.out.println("You missed!");
        }

        checkWhetherFieldEmpty();
        return hasShot;
    }

    /**
     * Method that checks if the player has sunk all ships.
     */
    public void checkWhetherFieldEmpty() {
        if (checkEmptyField()) {
            System.out.println("You sank all the ships! You have won the game, Congratulations!");
        }
    }

    // ----------------------- SHOOT METHODS ----

    /**
     * This method sets the cell given to true.
     *
     * @param x1 the x coordinate of the cell.
     * @param y1 the y coordinate of the cell.
     */
    public void setCellTrue(final int x1, final int y1) {
        this.arrayfield[y1][x1] = true;
    }


    /**
     * This method removes a ship from the Field.
     *
     * @param x1 the x coordinate of the ship.
     * @param y1 the y coordinate of the ship.
     */
    public void removeShip(final int x1, final int y1) {
        this.arrayfield[x1][y1] = false;
    }


    /**
     * Check whether the coordinates are valid.
     *
     * @param x1 the x coordinate of the cell.
     * @param y1 the y coordinate of the cell.
     * @return true if the coordinates are valid, false otherwise.
     */
    public boolean isValidCoordinate(final int x1, final int y1) {
        return x1 >= 0 && x1 < 10 && y1 >= 0 && y1 < 10;
    }

    /**
     * This method checks whether the ship placement is valid (i.e the ship placement is in bounds
     * and does not overlap with other ships).
     * @param x1        the x coordinate of the cell.
     * @param y1        the y coordinate of the cell.
     * @param direction the direction of the ship.
     * @param length    the length of the ship.
     * @return true if the ship placement is valid, false otherwise.
     */
    public boolean checkCorrectPlacement(final int x1, final int y1, final int direction, final int length) {
        // if the ship is horizontal, points to the right,
        // and length is bigger than 10, the ship is not in bounds.
        return (direction != 0 || x1 + length <= 10)
                // if the ship is vertical, points to the bottom,
                // and length is bigger than 10, the ship is not in bounds.
                && (direction != 1 || y1 + length <= 10)
                // if the ship is horizontal, points to the left,
                // and length is bigger than 10, the ship is not in bounds.
                && (direction != 2 || x1 - length >= 0)
                // if the ship is vertical, points to the top,
                // and length is bigger than 10, the ship is not in bounds.
                && (direction != 3 || y1 - length >= 0);
    }

    /**
     * This method is used to check whether there is any ship placed in some cells of the field.
     * @return boolean true if there is a ship in the field, false otherwise.
     */
    public boolean checkEmptyField() {
        boolean checkEmptyField = false; // boolean to check if there is a ship in the field.
        for (int x = 0; x < 10; x++) { // check if there is a ship in the cell - x axis
            for (int y = 0; y < 10; y++) { // check if there is a ship in the cell - y axis
                checkEmptyField = checkEmptyField || arrayfield[y][x];
            }
        }
        return !checkEmptyField; // return true if there is no ship in the field, false otherwise.
    }

    /**
     * This method checks whether a ship can be placed in the given position.
     * If the ship can be placed, the ship is placed in the field.
     * If the ship cannot be placed, the method returns false.
     * If the ship can be placed, the method returns true.
     *
     * @param x1        the x coordinate of the ship.
     * @param y1        the y coordinate of the ship.
     * @param direction the direction of the ship.
     * @param length    the length of the ship.
     * @return boolean true if the ship can be placed, false otherwise.
     */
    public boolean canPlaceShip(final int x1, final int y1, final int direction, final int length) {
        if (!isValidCoordinate(x1, y1)) {
            System.out.println("Illegal coordinates. The coordinates must be between 0 and 9.");
            return false;
        } else if (!checkCorrectPlacement(x1, y1, direction, length)) {
            System.out.println("Illegal placement. The ship cannot be placed in this position.");
            return false;
        } else if (getCell(x1, y1)) {
            System.out.println("Illegal placement. The ship cannot be placed in this position "
                    +
                    "since there is already a ship here at position (" + x1 + ", " + y1 + ").");
            return false;
        } else {
            // placeShip(x1, y1, direction, length);
            return true;
        }
    }

    /**
     * This method checks whether a shot can
     * be performed in a given position.
     *
     * @param x1 the x coordinate of the shot.
     * @param y1 the y coordinate of the shot.
     * @return boolean true if the shot can be performed, false otherwise.
     */
    public boolean isValidMoveV2(int x1, int y1) {
        if (x1 < 0 || x1 > 9 || y1 < 0 || y1 > 9) {
            return false;
        } else if (cells[x1][y1].isHit()) {
            System.out.println("You have already hit this cell.");
            return false;
        }
        return true;
    }

    /**
     * This method marks a cell of the field as hit.
     *
     * @param x1 the x coordinate of the shot.
     * @param y1 the y coordinate of the shot.
     */
    public void setHit(int x1, int y1) {
        cells[x1][y1].setHit();
    }

    /**
     * This method marks a cell of the field after a shot as missed.
     *
     * @param x1 the x coordinate of the shot.
     * @param y1 the y coordinate of the shot.
     */
    public void setMissed(int x1, int y1) {
        cells[x1][y1].setMissed();
    }


    /**
     * The following method check whether a ship can be placed in a given position.
     *
     * @param x1         the x coordinate of the ship.
     * @param y1         the y coordinate of the ship.
     * @param size       the size of the ship.
     * @param direction  the direction of the ship.
     * @param horizontal boolean true if the ship is horizontal, false otherwise.
     * @return boolean true if the ship can be placed, false otherwise.
     */
    public boolean isValidPlacementForShip(int x1, int y1, int size, String direction, boolean horizontal) {
        if (x1 < 0 || x1 > 9 || y1 < 0 || y1 > 9) {
            return false;
            // we position the literal first in string comparisons
        } else if ("v".equals(direction)) { // vertical
            if (x1 + size - 1 >= 10) {
                if (horizontal) { // if horizontal is true
                    System.out.println("The ship can't be placed in this position "
                            +
                            "as it is outside the bounds.");
                }
                return false;
            } else {
                for (int i = x1; i < x1 + size; i++) {
                    if (cells[i][y1].isOccupiedByShip()) {
                        if (horizontal) { // if horizontal is true
                            System.out.println("The ship cannot be placed in this position "
                                    +
                                    "as it is overlapping with another ship.");
                        }
                        return false;
                    }
                }
            }

        } else if ("h".equals(direction)) { // horizontal direction
            if (y1 + size - 1 >= 10) {
                if (horizontal) {
                    // the ship goes out of the bounds
                    System.out.println("The ship cannot be placed in this position "
                            +
                            "as it is outside the bounds.");
                }
                return false;
            } else {
                for (int i = y1; i < y1 + size; i++) {
                    if (cells[x1][i].isOccupiedByShip()) {
                        if (horizontal) {
                            // the ship overlaps with another ship
                            System.out.println("The ship cannot be placed in this position "
                                    +
                                    "as it is overlapping with another ship.");
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }


    /**
     * The following method sets ships of various sizes 2 to 5 in the field.
     *
     * @param x1        the x coordinate of where the ship is placed.
     * @param y1        the y coordinate of where the ship is placed.
     * @param direction the direction of the ship.
     * @param size      the size of the ship.
     * @param symbol    the symbol of the ship.
     */
    public void setShipOfDifferentSize(int x1, int y1, String direction, int size, String symbol) {

        if ("v".equals(direction)) { // vertical
            for (int i = 0; i < size; i++) {
                cells[x1 + i][y1].setOccupiedByShip(symbol);
            }
        } else if ("h".equals(direction)) { // horizontal
            for (int j = 0; j < size; j++) {
                cells[x1][y1 + j].setOccupiedByShip(symbol);
            }
        }
    }

    /**
     * The following method checks whether a shot is valid or not.
     *
     * @param x1 x coordinate of the shot.
     * @param y1 y coordinate of the shot.
     * @return true if the shot is valid, false otherwise.
     */
    public boolean checkWhetherHitWasSuccessful(int x1, int y1) {
        // if the cell is occupied by a ship and not hit yet
        return cells[x1][y1].isOccupiedByShip() && !cells[x1][y1].isHit();
    }

    /**
     * The following method checks the direction of where to place the ship.
     *
     * @param x1        x coordinate of the ship.
     * @param y1        y coordinate of the ship.
     * @param direction direction of the ship.
     * @param size      size of the ship.
     * @param symbol    symbol of the ship.
     */
    public void directionOnWhereToSetShip(int x1, int y1, String direction, int size, String symbol) {
        if ("v".equals(direction)) { // vertical
            //
            for (int j = 0; j < size; j++) {
                cells[x1 + j][y1].setOccupiedByShip(symbol);
            }
        } else if ("h".equals(direction)) { // horizontal
            for (int k = 0; k < size; k++) {
                cells[x1][y1 + k].setOccupiedByShip(symbol);
            }
        }
    }

    /**
     * Method that places a ship randomly.
     */
    public void placeShipRandomly() {
        // we want to place only 5 ships in the field

        Random random = new Random();
        for (int i = 1; i < 5; i++) {
            final int x = random.nextInt(10); // x coordinate
            final int y = random.nextInt(10); // y coordinate
            final int dir = random.nextInt(4); // direction
            // generate a random length number for the ship in the range from 2 to 5
            final int len = random.nextInt(2);
            // final int len = arrayListOfShips.get(i).getShipLength();
            // the above line this produces array index out of bounds exception
            if (canPlaceShip(x, y, dir, len)) {
                setCellTrue(x, y);
                insertShipAtValidCoords(x, y, dir, len);
            } else {
                final int xTemp = random.nextInt(10);
                final int yTemp = random.nextInt(10);
                final int d2 = random.nextInt(4);
                final int lenTemp = random.nextInt(2);
                if (canPlaceShip(xTemp, yTemp, d2, lenTemp)) {
                    setCellTrue(xTemp, yTemp);
                    insertShipAtValidCoords(xTemp, yTemp, d2, lenTemp);
                }
            }
        }
    }


    /**
     * The following method inserts a ship at a valid position.
     * @param xx        x coordinate of the ship.
     * @param yy        y coordinate of the ship.
     * @param direction direction of the ship.
     * @param len      size of the ship.
     */
    private void insertShipAtValidCoords(int xx, int yy, int direction, int len) {
        if (direction == 0) { // if vertical
            int x1 = xx; // x coordinate of the ship
            int length = len; // length of the ship
            while (length > 1) { // while the length of the ship is greater than 1
                x1++; // increment x coordinate
                setCellTrue(x1, yy);// set the cell to true
                length--; // decrement the length of the ship
            }
        } else if (direction == 1) { // if horizontal
            int y1 = yy; // y coordinate of the ship
            int length = len; // length of the ship
            while (length > 1) { // while the length of the ship is greater than 1
                y1++; // increment y coordinate
                setCellTrue(xx, y1); // set the cell to true
                length--; // decrement the length of the ship
            }
        } else if (direction == 2) { // if diagonal down
            int x1 = xx; // x coordinate of the ship
            int length = len; // length of the ship
            while (length > 1) { // while the length of the ship is greater than 1
                x1--; // increment x coordinate
                setCellTrue(x1, yy); // set the cell to true
                length--; // decrement the length of the ship
            }
        } else {
            int y1 = yy; // y coordinate of the ship
            int length = len; // length of the ship
            while (length > 1) { // while the length of the ship is greater than 1
                y1--; // increment y coordinate
                setCellTrue(xx, y1); // set the cell to true
                length--; // decrement the length of the ship

            }
        }
    }

    /**
     * Method that enables cheat mode.
     */
    public static void toggleCheatMode() {
        if (toggleNum % 2 == 0) {
            revealShips();
        } else {
            hideCheatMode();
        }
        toggleNum++;
    }

    /**
     * Method that hides the ship.
     */
    public static void hideCheatMode() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (cells[i][j].isOccupiedByShip()) {
                    cells[i][j].setOccupiedByShip("X");
                }
            }
        }
    }

    /**
     * Method that reveals the ships on the grid.
     */
    public static void revealShips() {
        String path = "/Users/cuenc/Documents/PF2-Project/src/gui/Images/click-me.jpg";
        ImageIcon pict = new ImageIcon(Field.class.getClassLoader().getResource(path));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (isOccupiedByShip(i, j)) {
                    CELL_BUTTONS[i][j].setIcon(pict);
                }
            }
        }
    }

    /**
     * Method that checks if a cell is occupied by a ship.
     * @param index1 represents the coordinate on the x axis.
     * @param index2 represents the coordinate on the y axis.
     * @return boolean that represents whether the cell is occupied or not.
     */
    public static boolean isOccupiedByShip(int index1, int index2) {
        return !SHIPS_PRESENT[index1][index2].getTypeOfShip().equals("empty");
    }
}