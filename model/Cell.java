package model;

/**
 * This class represents a cell in the Field (Board) of the Battleship game.
 * Considering that we have a 10x10 grid, we are supposed to have 100 cells, numbered from 0 to 99.
 * @author kelvin.likollari@usi.ch
 */

public class Cell {
    private boolean isOccupied = false; // true if the cell is occupied by a ship
    private boolean isHit = false; // true if the cell has been hit by a shot
    private int cellNumber; // the cell number (0-99)
    private String symbol = "Χ"; // the symbol to be displayed in the cell TODO: Initialize it to something
    private String hitSymbol = RED_COLOR + "X" + RESET_COLOR; // the hit symbol. TODO: Initialize it to something
    private String missSymbol = GREEN_COLOR + "O" + RESET_COLOR; // the miss symbol. TODO: Initialize it to something
    private static final String RESET_COLOR = "\u001B[0m";
    private static final String RED_COLOR = "\u001B[31m";
    private static final String GREEN_COLOR = "\u001B[32m";

    /**
     * Constructor of the class Cell.
     * @param cellNumber the cell number (0-99)
     */
    public Cell(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    /**
     * Empty constructor of the class Cell.
     * Empty constructors in Java are used to create objects without initializing their attributes.
     */
    public Cell() {
        super();
    }

    /**
     * Getter for the cell number.
     * @return the cell number (0-99)
     */
    public int getCellNumber() {
        return cellNumber;
    }

    /**
     * Getter for the isOccupied attribute.
     * @return true if the cell is occupied by a ship
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Setter for the isOccupied attribute.
     * @param isOccupied true if the cell is occupied by a ship
     */
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    /**
     * Getter for the isHit attribute.
     * @return true if the cell has been hit by a shot
     */
    public boolean isHit() {
        return isHit;
    }

    /**
     * Setter for the isHit attribute.
     */
    public void setHit() {
        this.isHit = true;
        this.symbol = hitSymbol;
    }

    /**
     * Set that the cell is not occupied by a ship.
     */
    public void setMissed() {
        this.isHit = true;
        this.symbol = missSymbol;
    }

    /**
     * Set the symbol of a player/ai.
     * @param symbol the symbol to be set.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Getter for the symbol.
     * @return the symbol as a string
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * ToString method for the class Cell.
     * @return the symbol of the cell as a string.
     */
    @Override
    public String toString() {
        return symbol;
    }

    /**
     * boolean method returning true if a cell is occupied by a ship.
     * @return true if the cell is occupied by a ship, false otherwise
     */
    public boolean isOccupiedByShip() {
        return this.isOccupied;
    }

    /**
     * Method that sets a cell to be occupied by a ship.
     * @param symbol the symbol to set the cell.
     */
    public void setOccupiedByShip(String symbol) {
        this.isOccupied = true;
        this.setSymbol(symbol);

    }
}
