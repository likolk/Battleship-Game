package model;

/**
 * Class Cruiser represents a type of ship in the game.
 * @author kelvin.likollari@usi.ch and ilker.kaymak@usi.ch
 */
public class Cruiser extends Ship {
    
    /**
     * Constructor of class Cruiser.
     * @param size is the size of a Cruiser.
     * @param positionX is the position in the X axis.
     * @param positionY is the position in the Y axis.
     * @param isshot represents whether the ship has been shot or not.
     * @param issunk represents whether the ship has been sunk or not.
     * @param isHidden represent whether the ship is hidden or not.
     * @param isHit represent wheter the ship has been hit or not.
     */
    public Cruiser(int size, int positionX, int positionY, boolean isshot, boolean issunk, boolean isHidden, boolean isHit) {
        super(size, positionX, positionY, isshot, issunk, isHidden, isHit);
    }
    
    /**
     * Constructor of class Cruiser..
     * @param identifier is used to identify a Cruiser.
     */
    public Cruiser(int identifier) {
        super(3, identifier);
    }

    /**
     * Method that returns the type of ship, that is Cruiser in this case.
     * @return A string that says the type of ship.
     */
    public String getShipType() {
        return "cruiser";
    }

}
