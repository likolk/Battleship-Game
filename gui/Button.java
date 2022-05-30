package gui;

import javax.swing.JButton;

/**
 * Button subclass that extends JButton.
 * @author kelvin.likollari@usi.ch
 * @author ilker.kaymak@usi.ch
 */
public class Button extends JButton {

    private int xx;
    private int yy;

    /**
     * Constructor for objects of class Button.
     * @param x1 represents the x-axis coordinate
     * @param y1 represents the y-axis coordinate
     */
    public Button(int x1, int y1) {
        super();
        this.xx = x1;
        this.yy = y1;
    }

    /**
     * This method gets the x and y coordinates of the button.
     * @return the x and y coordinates of the button as an array of integers.
     */
    public int[] getValues() {
        return new int[]{this.xx, this.yy};
    }
}
