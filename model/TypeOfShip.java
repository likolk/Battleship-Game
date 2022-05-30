package model;

/**
 * Interface for the type of ship.
 * @author kelvin.likollari@usi.ch
 */
public interface TypeOfShip {

    /**
     * Method that returns the type of ship.
     * @return A string that says the type of ship.
     */
    public String getTypeOfShip();

    /**
     * Method that returns a boolean value denoting whether the ship can be placed
     * in certain position or not.
     * @param x1 is the position in the X axis.
     * @param y1 is the position in the Y axis.
     * @param dir  is the direction of the ship.
     * @param field  is the field of the game.
     * @return true if the ship can be placed in the position, false otherwise.
     */
    public boolean canPlaceShipAt(int x1, int y1, boolean dir, Field field);

    /**
     * Method that returns a boolean value denoting whether the ship can be placed
     * in certain position or not.
     * @param x1 is the position in the X axis.
     * @param y1 is the position in the Y axis.
     * @param dir  is the direction of the ship.
     * @param ship is the ship that is being placed.
     * @return true if the ship can be placed in the position, false otherwise.
     */
    public boolean canPlaceShipAt(int x1, int y1, boolean dir, Ship ship);
}
