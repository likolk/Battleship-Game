package model;

/**
 * Class Carrier represents a type of ship in the game.
 * @author kelvin.likollari@usi.ch
 */

public class Carrier extends Ship {
    
    /**
     * Constructor of class Carrier.
     * @param size is the size of a Carrier.
     * @param positionX is the position in the X axis.
     * @param positionY is the position in the Y axis.
     * @param isshot represents whether the ship has been shot or not.
     * @param issunk represents whether the ship has been sunk or not.
     * @param isHidden represent whether the ship is hidden or not.
     * @param isHit represent wheter the ship has been hit or not.
     */
    public Carrier(int size, int positionX, int positionY, boolean isshot, boolean issunk, boolean isHidden, boolean isHit) {
        super(size, positionX, positionY, isshot, issunk, isHidden, isHit);
    }
    
    /**
     * Constructor of class Carrier.
     * @param identifier is used to identify a Carrier.
     */
    public Carrier(int identifier) {
        super(5, identifier);
    }

    /**
     * Method that returns the type of ship, that is Carrier in this case.
     * @return A string that says the type of ship.
     */
    public String getShipType() {
        return "carrier";
    }

}
