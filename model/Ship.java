package model;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * The ship class is used to represent a ship in the Battleship game.
 * This ship class holds information of the ship's data.
 * Size is the number of squares the ship occupies.
 * @author kelvin.likollari@usi.ch
 */
public class Ship implements TypeOfShip {
    private int size = 5;
    private static int positionX;
    private static int positionY;

    private static Ship[][] ships = new Ship[10][10];

    // direction
    private static boolean direction;
    private List<Coordinates> coordinates;
    private boolean issunk;
    private boolean isshot = false;
    private boolean isHit = false;
    private boolean isHidden;
    private int shipIdentifier;
    static ArrayList<Integer> shipCoordinates = new ArrayList<Integer>();


    /**
     * Constructor for the ship class.
     *
     * @param size      The size of the ship.
     *                  The size of the ship is the number of squares the ship occupies.
     * @param positionX The x position of the ship.
     *                  The x position of the ship is the x coordinate of the ship's first square.
     * @param positionY The y position of the ship.
     *                  The y position of the ship is the y coordinate of the ship's first square.
     * @param isshot    Whether the ship is shot or not.
     * @param issunk    Whether the ship is sunk or not.
     * @param isHidden  Whether the ship is hidden or not.
     * @param isHit     Whether the ship is hit or not.
     */
    public Ship(int size, int positionX, int positionY, boolean isshot, boolean issunk, boolean isHidden, boolean isHit) {
        this.size = size;
        this.positionX = positionX;
        this.positionY = positionY;
        this.isshot = isshot;
        this.issunk = issunk;
        this.isHit = false;
        this.isHidden = true;
    }
    
    /**
     * Constructor of the Ship class.
     * 
     * @param positionX int that represents the position on the X axis.
     * @param positionY int that represents the position on the Y axis.
     * @param len int that represents the length of the ship.
     */
    public Ship(int positionX, int positionY,int len) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = len;
    }



    /**
     * Constructor for the ship class.
     * @param len The length of the ship.
     */
    public Ship(int len) {
        if (len > 0 && len < 6) {
            this.size = len;
        } else {
            System.out.println("length must be an integer between 1 and 5");
        }
    }

    /**
     * Constructor for the ship class.
     * @param len The length of the ship.
     * @param siz  The ship's identifier.
     */
    public Ship(int len, int siz) {
        size = len;
        shipIdentifier = siz;
    }

    public static boolean getDirection() {
        return direction;
    }


    /**
     * Returns the size of the ship.
     * @return The size of the ship.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the x position of the ship.
     *
     * @return The x position of the ship.
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Returns the y position of the ship.
     *
     * @return The y position of the ship.
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Returns the coordinates of the ship.
     *
     * @return The coordinates of the ship.
     */
    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the size of the ship.
     *
     * @param size The size of the ship.
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Sets the x position of the ship.
     *
     * @param positionX The x position of the ship.
     */
    public static void setPositionX(int positionX) {
        Ship.positionX = positionX;
    }

    /**
     * Sets the y position of the ship.
     *
     * @param positionY The y position of the ship.
     */
    public static void setPositionY(int positionY) {
        Ship.positionY = positionY;
    }

    /**
     * Sets the position X and Y of the ship.
     * @param positionX The x position of the ship.
     * @param positionY The y position of the ship.
     */
    public void setPositionXAndY(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * Sets the coordinates of the ship.
     * @param coordinates The coordinates of the ship.
     */
    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets the coordinates of the ship.
     * @param x1 The x coordinate of the ship.
     * @param y1 The y coordinate of the ship.
     */
    public static void setCoordinatesOfEachShip(int x1, int y1) {
        shipCoordinates.add(x1);
        shipCoordinates.add(y1);
    }

    /**
     * Gets the coordinates of the ship stored in the shipCoordinates arraylist.
     * @return The coordinates of the ship stored in the shipCoordinates arraylist.
     */
    public ArrayList<Integer> getEachShipCoordinates() {
        return shipCoordinates;
    }

    /**
     * Sets ships at coordinates.
     * @param x1 The x coordinate of the ship.
     * @param y1 The y coordinate of the ship.
     * @param type The type of the ship.
     */
    public static void setShipsAtCoordinates(int x1, int y1, Ship type) {
        if (x1 >= 0 && x1 < 10 && y1 >= 0 && y1 < 10) {
            ships[x1][y1] = type;
        } else {
            System.out.println("x and y:" + x1 + y1);
            throw new IllegalArgumentException("x and y must be between 0 and 9");
        }
    }

    /**
     * Returns the ship's data as a string.
     * @return The ship's data as a string.
     */
    public String toString() {
        // print the data of the ship as a string
        return "Ship: " + size + " " + positionX + " " + positionY;
    }

    /**
     * Checks if the ship is sunk.
     * @return True if the ship is sunk, false otherwise.
     */
    public boolean isSunk() {
        return false;

    }

    /**
     * Checks if the ship is hit/shot.
     * @return True if the ship is hit/shot, false otherwise.
     */
    public boolean isShot() {
        return isSunk();
    }

    /**
     * Sets the direction of the ship.
     * @param direction The direction of the ship.
     */
    public static void setDirection(boolean direction) {
        Ship.direction = direction;
    }



    /**
     * Gets the type of the ship.
     * @return The type of the ship.
     */
    @Override
    public String getTypeOfShip() {
        return null;
    }

    /**
     * Checks whether we can place the ship at the given coordinates.
     * @param x1 The x coordinate of the ship.
     * @param y1 The y coordinate of the ship.
     * @param dir The direction of the ship.
     * @param field The field of the ship.
     * @return True if we can place the ship, false otherwise.
     */
    @Override
    public boolean canPlaceShipAt(int x1, int y1, boolean dir, Field field) {
        return false;
    }

    /**
     * Checks whether we can place the ship at the given coordinates.
     * @param x1 The x coordinate of the ship.
     * @param y1 The y coordinate of the ship.
     * @param dir The direction of the ship.
     * @param ship The ship.
     * @return True if we can place the ship, false otherwise.
     */
    @Override
    public boolean canPlaceShipAt(int x1, int y1, boolean dir, Ship ship) {
        return false;
    }

    /**
     * Placeship method used for the gui.
     * @param x2 The x coordinate of the ship.
     * @param y2 The y coordinate of the ship.
     * @param dir The direction of the ship.
     * @param field The field of the ship.
     */
    public void placeShipGUI(int x2, int y2, boolean dir, Ship field) { // 26.05.2022 : Mistake here
        Ship.setPositionX(x2);
        Ship.setPositionY(y2);
        Ship.setDirection(dir);
        if (dir) {
            for (int i = 0; i < size; i++) {
                field.setShipsAtCoordinates(x2, y2 - i, this);
                setCoordinatesOfEachShip(x2, y2 - i);
            }
        } else {
            for (int i = 0; i < size; i++) {
                field.setShipsAtCoordinates(x2 - i, y2, this);
                setCoordinatesOfEachShip(x2 - i, y2);
            }
        }
    }

    /**
     * Placeship randomly method used for the gui to place the ships randomly.
     */
    public static void placeShipsRandomly() {
        Battleship bs = new Battleship(1);
        // check whether we are allowed to place the ships in the grid
        int[] shipCoordinates = checkWhetherShipCanBePlacedInGrid(bs,4);
        System.out.println("The coordinates of the ship are: " + Arrays.toString(shipCoordinates));
        int xx = 0;
        if (Objects.isNull(shipCoordinates)) {
            return;
        }
        if (shipCoordinates != null) {
            xx = shipCoordinates[0];
        }
        int yy = 0;
        if (shipCoordinates != null) {
            yy = shipCoordinates[1];
        }
        boolean dir = true;
        if (shipCoordinates != null) {
            if (shipCoordinates[2] == 0) {
                dir = false;
            } else {
                dir = true;
            }
        }
        System.out.println("restarting game, with x: "
                + xx
                + " and y: "
                + yy + " and dir: "
                + dir);
        bs.placeShipGUI(xx, yy, dir, bs);
        placeDestroyer();
        placeSubmarine();
        placeBattleship();
        placeCarrier();
        placeCruiser();

    }


    /**
     * Method that places the destroyer ship.
     */
    public static void placeDestroyer() {
        for (int i = 0; i < 2; i++) {
            Destroyer destroyer = new Destroyer(i + 1);
            int[] shipCoordinates = checkWhetherShipCanBePlacedInGrid(destroyer, 2);
            int x1 = shipCoordinates[0];
            int y1 = shipCoordinates[1];
            boolean dir = true;
            if (shipCoordinates[2] == 0) {
                dir = false;
            } else {
                dir = true;
            }
            destroyer.placeShipGUI(x1, y1, dir, destroyer);
        }
    }


    /**
     * Method that places the submarine ship.
     */
    public static void placeSubmarine() {
        for (int i = 0; i < 3; i++) {
            Submarine submarine = new Submarine(i + 1);
            int[] shipCoordinates = checkWhetherShipCanBePlacedInGrid(submarine, 3);
            int x1 = shipCoordinates[0];
            int y1 = shipCoordinates[1];
            boolean dir = true;
            if (shipCoordinates[2] == 0) {
                dir = false;
            } else {
                dir = true;
            }
            submarine.placeShipGUI(x1, y1, dir, submarine);
        }
    }

    /**
     * Method that places the battleship ship.
     */
    public static void placeBattleship() {
        for (int i = 0; i < 4; i++) {
            Battleship battleship = new Battleship(i + 1);
            int[] shipCoordinates = checkWhetherShipCanBePlacedInGrid(battleship, 4);
            int x1 = shipCoordinates[0];
            int y1 = shipCoordinates[1];
            boolean dir = true;
            if (shipCoordinates[2] == 0) {
                dir = false;
            } else {
                dir = true;
            }
            battleship.placeShipGUI(x1, y1, dir, battleship);
        }
    }

    /**
     * Method that places the carrier ship.
     */
    public static void placeCarrier() {
        for (int i = 0; i < 5; i++) {
            Carrier carrier = new Carrier(i + 1);
            int[] shipCoordinates = checkWhetherShipCanBePlacedInGrid(carrier, 5);
            int x1 = shipCoordinates[0];
            int y1 = shipCoordinates[1];
            boolean dir = true;
            if (shipCoordinates[2] == 0) {
                dir = false;
            } else {
                dir = true;
            }
            carrier.placeShipGUI(x1, y1, dir, carrier);
        }
    }

    /**
     * Method that places the cruiser ship.
     */
    public static void placeCruiser() {
        for (int i = 0; i < 3; i++) {
            Cruiser cruiser = new Cruiser(i + 1);
            int[] shipCoordinates = checkWhetherShipCanBePlacedInGrid(cruiser, 3);
            int x1 = shipCoordinates[0];
            int y1 = shipCoordinates[1];
            boolean dir = true;
            if (shipCoordinates[2] == 0) {
                dir = false;
            } else {
                dir = true;
            }
            cruiser.placeShipGUI(x1, y1, dir, cruiser);
        }
    }

    /**
     * Method that checks whether the ship can be placed in the grid.
     * @param ship The ship that is being placed.
     * @param len The length of the ship.
     * @return The coordinates of the ship.
     */
    public static int[] checkWhetherShipCanBePlacedInGrid(Ship ship, int len) {
        SecureRandom random = new SecureRandom();
        int[] coordinates = new int[2];
        int xrand = random.nextInt(10 - len + 1) + len - 1;
        int yrand = random.nextInt(10 - len + 1) + len - 1;
        System.out.println("1. x: " + xrand + " y: " + yrand);
        boolean dir;
        if (random.nextInt(10) > 4) { // if the number is greater than 4, then the ship is placed vertically
            dir = true;
        } else {
            dir = false;
        }
        int dirr = 0;
        while (!ship.canPlaceShipAt(xrand, yrand, dir, ship)) {
            xrand = random.nextInt(10 - len + 1) + len - 1;
            yrand = random.nextInt(10 - len + 1) + len - 1;
            if (xrand + yrand + dirr % 2 == 0) {
                dir = true;
            } else {
                dir = false;
            }
            System.out.println("2. x: " + xrand + " y: " + yrand);
            dirr++;
            if (dirr > 100) {
                System.out.println("Could not place ship");
                return null;
            }

        }
        int[] returnCoordinates = {xrand, yrand, 0};
        System.out.println("3. x: " + xrand + " y: " + yrand);
        if (dir) {
            returnCoordinates[2] = 1;
        }
        return returnCoordinates;
    }

}