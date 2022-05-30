package model;


/**
 * Class Coordinates which is used to store the coordinates of a ship.
 * @author kelvin.likollari@usi.ch
 */
public class Coordinates
{
    private int x1; // x coordinate
    private int y1; // y coordinate

    /**
     * Constructor of Coordinates' class.
     * @param x1 represents the x-axis coordinate
     * @param y1 represents the y-axis coordinate
     */
    public Coordinates(int x1, int y1)
    {
        this.x1 = x1;
        this.y1 = y1;
    }

    /**
     * Method to get the x coordinate.
     * @return the x coordinate
     */
    public int getX()
    {
        return x1;
    }

    /**
     * Method to get the y coordinate.
     * @return the y coordinate
     */
    public int getY()
    {
        return y1;
    }

    /**
     * Method to set the x coordinate.
     * @param x1 the x coordinate
     */
    public void setX(int x1)
    {
        this.x1 = x1;
    }

    /**
     * Method to set the y coordinate.
     * @param y1 the y coordinate
     */
    public void setY(int y1)
    {
        this.y1 = y1;
    }

    /**
     * Method to get the distance between two coordinates.
     * @param other the other coordinates
     * @return the distance
     */
    public double getDistance(Coordinates other)
    {
        return Math.sqrt(Math.pow(other.x1 - x1, 2) + Math.pow(other.y1 - y1, 2));
    }

    /**
     * Method to check whether 2 coordinates are equal.
     * @param other the other coordinates.
     * @return true if the coordinates are equal, false otherwise
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        if (other == this)
        {
            return true;
        }
        if (!(other instanceof Coordinates))
        {
            return false;
        }
        Coordinates otherCoordinates = (Coordinates) other;
        return x1 == otherCoordinates.x1 && y1 == otherCoordinates.y1;
    }

    /**
     * This method resets the coordinates to 0,0.
     */
    public void resetCoordinates() {
        this.x1 = 0;
        this.y1 = 0;
    }

    /**
     * HashCode class.
     */
    @Override
    public int hashCode()
    {
        return x1 * y1;
    }

    /**
     * The following method returns a string representation of the coordinates.
     * @return the string representation of the coordinates
     */
    @Override
    public String toString()
    {
        return "(" + x1 + "," + y1 + ")";
    }

}
