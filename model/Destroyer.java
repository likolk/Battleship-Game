package model;

/**
 * Class Destroyer represents a type of ship in the game.
 * @author kelvin.likollari@usi.ch and ilker.kaymak@usi.ch.
 */
public class Destroyer extends Ship {
    
    /**
     * Constructor of class Destroyer.
     * @param size is the size of a Destroyer.
     * @param positionX is the position in the X axis.
     * @param positionY is the position in the Y axis.
     * @param isshot represents whether the ship has been shot or not.
     * @param issunk represents whether the ship has been sunk or not.
     * @param isHidden represent whether the ship is hidden or not.
     * @param isHit represent wheter the ship has been hit or not.
     */
    public Destroyer(int size, int positionX, int positionY, boolean isshot, boolean issunk, boolean isHidden, boolean isHit) {
        super(size, positionX, positionY, isshot, issunk, isHidden, isHit);
    }
    
    /**
     * Constructor of class Destroyer.
     * @param identifier is used to identify a Destroyer.
     */
    public Destroyer(int identifier) {
        super(2, identifier);
    }

    /**
     * Method that returns the type of ship, that is Destroyer in this case.
     * @return A string that says the type of ship.
     */
    public String getShipType() {
        return "destroyer";
    }

}
