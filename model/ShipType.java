package model;

/**
 * Enum class for ship types.
 * @author kelvin.likollari@usi.ch
 */
public enum ShipType {
    BATTLESHIP(5),
    CARRIER(4),
    CRUISER(3),
    DESTROYER(2),
    SUBMARINE(1)
    ;
    int length;

    ShipType(int length) {
        this.length = length;
    }

    /**
     * Returns the length of the ship type.
     * @return the length of the ship type.
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the type of ship with the given index.
     * @param length the length of the ship type.
     * @return returns the ship type.
     */
    public static ShipType getShipType(int length) {
        switch (length) {
            case 5:
                return ShipType.BATTLESHIP;
            case 4:
                return ShipType.CARRIER;
            case 3:
                return ShipType.CRUISER;
            case 2:
                return ShipType.DESTROYER;
            case 1:
                return ShipType.SUBMARINE;
            default:
                return null;
        }
    }

    /**
     * Returns the name of the ship type.
     * @return the name of the ship type.
     */
    public ShipType getShipType() {
        return this;
    }

}

