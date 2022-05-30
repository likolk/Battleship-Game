package model;

/**
 * This class was created mainly for the purpose of testing the "restart" functionality.
 * It inherits from the Ship class.
 * @author kelvin.likollari@usi.ch
 */
public class ResettedGrid extends Ship {
    /**
     * Constructor for objects of class ResettedGrid.
     * @param size is the size of the ship.
     * @param positionX is the position in the X axis.
     * @param positionY is the position in the Y axis.
     * @param isshot represents whether the ship has been shot or not.
     * @param issunk represents whether the ship has been sunk or not.
     * @param isHidden represent whether the ship is hidden or not.
     * @param isHit represent whether the ship has been hit or not.
     */
    public ResettedGrid(int size, int positionX, int positionY, boolean isshot, boolean issunk, boolean isHidden, boolean isHit) {
        super(size, positionX, positionY, isshot, issunk, isHidden, isHit);

    }

    /**
     * Constructor for objects of class ResettedGrid.
     * @param identifier is used to identify a ship.
     */
    public ResettedGrid(int identifier) {
        super(1, identifier);
    }

    /**
     * Method that returns the type of ship.
     * @return A string that says the type of ship.
     */
    public String getShipType() {
        return "empty";
    }

}
