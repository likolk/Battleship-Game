package gui;

import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.CYAN;
import static java.awt.Color.GREEN;
import static java.awt.Color.ORANGE;
import static java.awt.Color.PINK;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.YELLOW;
import static java.lang.String.valueOf;
import static javax.swing.BorderFactory.createDashedBorder;
import static model.Field.hideCheatMode;
import static model.Field.isOccupiedByShip;
import static model.Game.setPlayerShipsManually;

import model.Field;
import model.Game;
import model.GamePlayers;
import model.ResettedGrid;
import model.Ship;

import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;



/**
 * The Graphical User Interface of the BattleShip game is going to include the 2
 * fields of the game, the board of the player and the board of the opponent.
 * The board of the player is going to be a grid of 10x10 squares. The board of
 * the opponent is going to be a grid of 10x10 squares.
 * The player is going to be able to place his ships on the board of the player.
 * The player is going to be able to attack the board of the opponent.
 * We will also have a button to start the game, a button to reset the game,
 * a button to quit the game and a button to show the rules of the game.
 * @author kelvin.likollari@usi.ch
 * @author ilker.kaymak@usi.ch
 */
public class Main extends JFrame implements ActionListener {

    // sizes of the window
    private static int frameSizeX = 1920;
    private static int frameSizeY = 1080;
    JFrame frame;
    private JPanel panel;
    private static ActionListener ButtonListener;

    private static Ship[][] ships;
    private static int totalNumberOfMoves = 0; // total number of moves

    private static JLabel totalMoves;
    private GridBagLayout grid;
    private static JButton[][] cellButtons = new JButton[10][10];

    private static int score;
    private static int sunkShips;

    private static int s1;
    private static int s2;

    private static GridBagConstraints constraints;
    private static Game g = new Game();
    private static GamePlayers player = new GamePlayers();
    private static GamePlayers opponent = new GamePlayers();

    private static int numberOfClicks = 0;

    //private JButton toggleCheat; // button to toggle cheat mode
    //private int toggleNum = 0; // toggle number

    /**
     * The main method used to start the application.
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new MetalLookAndFeel()); // used on macs to change the color of a button after
                // clicking it
                Main main = new Main(); // create the main class
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                main.setVisible(true); // make the main class visible
            } catch (ClassNotFoundException
                     | InstantiationException
                     | IllegalAccessException
                     | UnsupportedLookAndFeelException exception) {
                exception.printStackTrace(); // print the exception
            }
        });
    }

    /**
     * Main constructor used to create the main class.
     */
    public Main() {
        grid = new GridBagLayout();
        constraints = new GridBagConstraints();
        ships = new Ship[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ships[i][j] = new ResettedGrid(0);
            }
        }
        final JFrame frame = new JFrame("Battleship: Call of Ships - Water Wars");
        JLabel title = new JLabel("Battleship 2022");
        title.setFont(new Font("Comfortaa", Font.BOLD, 50));
        title.setForeground(BLACK);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBackground(GREEN);
        title.setPreferredSize(new Dimension(200, 200));
        title.requestFocus();
        title.revalidate();

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(10, 10, 1, 1));
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                constraints.gridx = x + 1;
                constraints.gridy = y + 1;
                final Button button = new Button(x, y);
                cellButtons[x][y] = button;
                cellButtons[x][y].setBackground(CYAN);
                cellButtons[x][y].setEnabled(true);
                cellButtons[x][y].addActionListener(ButtonListener);
                cellButtons[x][y].setActionCommand(valueOf(x) + valueOf(y));
                cellButtons[x][y].setPreferredSize(new Dimension(30, 30));
                cellButtons[x][y].setOpaque(true);
                cellButtons[x][y].setFocusable(true);
                cellButtons[x][y].setBackground(CYAN);
                cellButtons[x][y].setForeground(BLACK);
                cellButtons[x][y].setFont(new Font("Comfortaa", Font.BOLD, 20));
                cellButtons[x][y].setHorizontalAlignment(JButton.CENTER);
                cellButtons[x][y].setVerticalAlignment(JButton.CENTER);
                panel2.add(cellButtons[x][y]);
                cellButtons[x][y].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        final int[] a = button.getValues();
                        if (g.shoot(a[1], a[0])) {
                            // change the color of the cell we shot
                            // using an event listener
                            getCell();
                            Object source = event.getSource();
                            if (source instanceof Component) {
                                Button but = (Button) source;
                                ((Component) source).setBackground(GREEN);
                                s1++;
                            }
                        } else if (button.getBackground() != GREEN) { // if the button is not black
                            button.setBackground(YELLOW);
                        }
                    }
                });
                panel2.add(cellButtons[x][y]);
            }
        }
        panel2.setBackground(PINK);
        panel2.setBorder(createDashedBorder(ORANGE));
        panel2.setBackground(YELLOW);

        // Add the grid panel to the frame
        JPanel panel22 = new JPanel();
        GridLayout layoutt = new GridLayout(10, 10, 1, 1);
        layoutt.setHgap(2); // horizontal gap between columns
        layoutt.setVgap(2); // vertical gap between rows
        panel22.setLayout(layoutt);
        panel22.setBorder(new LineBorder(GREEN, 1));
        panel22.setBackground(ORANGE);

        JTextField textField = new JTextField();
        textField.setText("Player 1");
        textField.setEditable(false);
        textField.setFont(new Font("Comfortaa", Font.BOLD, 20));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBorder(new LineBorder(BLACK, 4));
        textField.setBackground(WHITE);
        textField.setVisible(true);
        textField.revalidate();

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException exception) {
            throw new RuntimeException(exception);
        }
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Button[][] target = new Button[10][10];
                final Button button = new Button(x, y);
                target[y][x] = button;
                button.setBackground(BLUE);
                target[y][x].setBackground(CYAN);
                target[y][x].setForeground(CYAN);
                target[y][x].addActionListener(new ActionListener() {
                    public void actionPerformed(final ActionEvent event) {
                        final int[] a = button.getValues(); // get the values of the button
                        if (g.shoot(a[1], a[0])) {
                            // change the color of the cell we shot
                            // using an event listener
                            getCell();
                            Object source = event.getSource();
                            if (source instanceof Component) {
                                Button butt = (Button) source;
                                ((Component) source).setBackground(RED);
                                s2++;
                            }
                        } else if (button.getBackground() != RED) { // if the button is not black
                            button.setBackground(ORANGE);
                        }
                    }
                });
                panel22.add(target[y][x]); // add the button to the panel
            }
        }


        panel22.setBackground(PINK);
        panel22.setBorder(createDashedBorder(ORANGE));
        panel22.setBackground(CYAN);
        panel22.setLayout(layoutt);

        JPanel panel3 = new JPanel();
        JButton restart = new JButton("Restart");

        restart.setFont(new Font("Comfortaa", Font.PLAIN, 30));
        restart.setBackground(PINK);
        restart.setForeground(BLACK);

        JButton quit = new JButton("Quit");
        quit.setFont(new Font("Comfortaa", Font.PLAIN, 30));
        quit.setBackground(CYAN);
        quit.setForeground(RED);

        JButton rules = new JButton("Rules");
        rules.setFont(new Font("Comfortaa", Font.PLAIN, 30));
        rules.setBackground(BLACK);
        rules.setForeground(ORANGE);
        rules.addMouseListener((new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rules.setBackground(BLACK);
                rules.setForeground(PINK);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                rules.setForeground(BLACK);
                rules.setBackground(GREEN);
            }
        }));

        JButton placeShip = new JButton("Place Ship");
        placeShip.setFont(new Font("Comfortaa", Font.PLAIN, 30));
        placeShip.setBackground(BLACK);
        placeShip.setForeground(WHITE);

        JButton toggleCheat = new JButton("Toggle Cheat Mode");
        toggleCheat.setFont(new Font("Comfortaa", Font.BOLD, 30));
        toggleCheat.setForeground(GREEN);
        toggleCheat.setBackground(BLACK);
        toggleCheat.addMouseListener((new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toggleCheat.setBackground(BLACK);
                toggleCheat.setForeground(YELLOW);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                toggleCheat.setForeground(BLACK);
                toggleCheat.setBackground(GREEN);
            }
        }));
        panel3.add(restart);
        panel3.add(quit);
        panel3.add(rules);
        panel3.add(placeShip);
        panel3.add(toggleCheat);
        panel3.setBackground(RED);
        panel3.setPreferredSize(new Dimension(20, 60));

        JPanel panel4 = new JPanel();
        panel4.setBackground(WHITE);
        panel4.setFont(new Font("Comfortaa", Font.PLAIN, 20));
        panel4.setForeground(BLACK);

        totalMoves = new JLabel("Total Moves: 0");
        totalMoves.setFont(new Font("Comfortaa", Font.BOLD, 30));
        totalMoves.setForeground(BLACK);
        totalMoves.setBackground(GREEN);
        totalMoves.setOpaque(true);
        totalMoves.setBorder(new LineBorder(ORANGE, 1));
        totalMoves.setVisible(true);
        panel4.add(totalMoves);


        JLabel label = new JLabel();

        JPanel panel8 = new JPanel();
        panel8.setLayout(new FlowLayout());
        panel8.setBorder(new LineBorder(ORANGE, 1));
        panel8.setBackground(YELLOW);
        panel8.setVisible(true);


        panel4.add(label);
        panel4.add(panel8);


        panel2.setPreferredSize(new Dimension(720, 900));
        panel22.setPreferredSize(new Dimension(720, 900));

        frame.add(title, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.EAST);
        frame.add(panel22, BorderLayout.WEST);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.add(panel4, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(new Dimension(1920, 1080));
        frame.setVisible(true);


        restart.addActionListener(e -> {
            restartGame(1);
            totalNumberOfMoves = 0;
            totalMoves.setText("Total Moves: " + totalNumberOfMoves);
            // and also place ships randomly
            //Game.placeShipRandomly();
            Ship.placeShipsRandomly();
        });

        restart.addMouseListener(new java.awt.event.MouseAdapter() {
            /**
             * Invoked when the mouse button is hovering over the button.
             *
             * @param evt the event to be processed
             */
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restart.setBackground(ORANGE);
                restart.setForeground(GREEN);
            }

            /**
             * Invoked when the mouse button is no longer hovering over the button.
             *
             * @param evt the event to be processed
             */
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restart.setForeground(BLACK);
                restart.setBackground(CYAN);
            }
        });

        quit.addActionListener(e -> quitGame(1));

        rules.addActionListener(e -> {
            JFrame rulesFrame = new JFrame("Rules");

            JPanel rulesPanel = new JPanel();
            rulesPanel.setBackground(PINK);
            rulesPanel.setBorder(new LineBorder(YELLOW, 2));
            rulesPanel.setFont(new Font("Comfortaa", Font.BOLD, 20));
            rulesPanel.setForeground(GREEN);
            rulesPanel.setLayout(new GridLayout(0, 1));
            // we will display the rules in a new window in html format
            // and each rule will be in a separate dot line
            JLabel rulesLabel = new JLabel("<html><body><p>Welcome to Battleship: Call"
                    + "of Ships © Kelvin Likollari & Ilker Kaymak</p>"
                    + "<li>The main objective of the game is to sink all the enemy ships.</li>"
                    + "<li>The player who sinks all the enemy ships first wins the game.</li>"
                    + "<li>The player can place his ships on the grid by clicking on the grid.</li>"
                    + "<li>The player can also click on the grid to shoot at the enemy ships.</li>"
                    + "<li>The player can also click on the grid to mark the enemy ships.</li>"
                    + "<li>Every time the player hits a ship, his score will increase by 1.</li>"
                    + "<li>Every time the player misses a ship, his score will decrease by 1.</li>"
                    + "<li>The person who has the highest score at the end of the game wins.</li>"
                    + "<li>Every person has 5 lives.</li>"
                    + "<li>Every time the player's ship gets hit, his lives' count will decrease by 1.</li>"
            );
            rulesLabel.setFont(new Font("Comfortaa", Font.BOLD, 25));
            rulesLabel.setForeground(BLUE);
            rulesLabel.setBackground(YELLOW);
            // We also need to add a button to close this popup window
            JButton button = new JButton("Click here to return to the game");
            button.addActionListener(e1 -> rulesFrame.dispose());
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(RED);
                    button.setForeground(GREEN);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setForeground(RED);
                    button.setBackground(GREEN);
                }
            });

            // set the button's size
            button.setPreferredSize(new Dimension(100, 100));
            // set the button's font
            button.setFont(new Font("Comfortaa", Font.BOLD, 20));
            // set the button's color
            button.setBackground(YELLOW);
            // set the button's foreground color
            button.setForeground(ORANGE);

            // we want to add the text before the button
            rulesPanel.add(rulesLabel);
            rulesPanel.add(button);
            rulesFrame.add(rulesPanel);
            rulesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rulesFrame.pack();
            rulesFrame.setSize(new Dimension(1000, 1000));
            rulesFrame.setVisible(true);
        });

        // clicking on "Place Ship" will place the ships on the grid
        // we will also add an event listener to the placeShip button
        placeShip.addActionListener(event -> {
            // simply call the method that will place the ships
            // with respect to the mouse click
            placeShip();
            // actionPerformedd(e);
            int x1 = MouseInfo.getPointerInfo().getLocation().x;
            int y1 = MouseInfo.getPointerInfo().getLocation().y;

            // TODO: Fix the method below providing direction too (horizontal or vertical)
            placeShip();

        });

        // the direction of the ship will be determined by the
        // mouse click
        // if it is a left click, the ship will be placed vertically
        // if it is a right click, the ship will be placed horizontally
        // we will also add an event listener to the placeShip button
        // TODO: Fix the method below
        placeShip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                super.mouseClicked(event);
                if (event.getButton() == MouseEvent.BUTTON1) {
                    // if the left button is clicked, the ship will be placed vertically
                    // we will also add an event listener to the placeShip button
                    placeShip();
                } else if (event.getButton() == MouseEvent.BUTTON3) {
                    // if the right button is clicked, the ship will be placed horizontally
                    // we will also add an event listener to the placeShip button
                    placeShip();
                }
            }
        });

        placeShip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                placeShip.setBackground(ORANGE);
                placeShip.setForeground(BLACK);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                placeShip.setForeground(BLACK);
                placeShip.setBackground(CYAN);
            }
        });
        placeShip();
        ButtonListener = (ActionEvent event) -> {
            if (event.getActionCommand().equals("cheat")) {
                if (event.getActionCommand().equals("cheat")) {
                    Field.toggleCheatMode();
                }
            } else {
                // get the x and y coordinates of the mouse click
                int x2 = MouseInfo.getPointerInfo().getLocation().x;
                int y2 = MouseInfo.getPointerInfo().getLocation().y;
                // increment the total moves
                totalNumberOfMoves++;
                // update the total moves label
                totalMoves.setText("Total Moves: " + totalNumberOfMoves);

                String lastTurn;
                while (true) {
                    if (isOccupiedByShip(x2, y2)) {
                        lastTurn = "First Player";
                        // if the user clicks on a ship, the ship will be sunk
                        // and the score will be increased by 1
                        // we will also add an event listener to the placeShip button
                        setHitWithIcon(x2, y2);
                        if (checkWhetherShipIsSunk(x2, y2)) {
                            sunkShips++;

                            if (ships[x2][y2].getTypeOfShip() == "Carrier") {
                                score += 10;
                                JOptionPane.showMessageDialog(null, "You sunk the Carrier!");
                            } else if (ships[x2][y2].getTypeOfShip() == "Battleship") {
                                score += 8;
                                JOptionPane.showMessageDialog(null, "You sunk the Battleship!");

                            } else if (ships[x2][y2].getTypeOfShip() == "Cruiser") {
                                score += 6;
                                JOptionPane.showMessageDialog(null, "You sunk the Cruiser!");
                            } else if (ships[x2][y2].getTypeOfShip() == "Submarine") {
                                score += 4;
                                JOptionPane.showMessageDialog(null, "You sunk the Submarine!");
                            } else if (ships[x2][y2].getTypeOfShip() == "Destroyer") {
                                score += 2;
                                JOptionPane.showMessageDialog(null, "You sunk the Destroyer!");
                            }
                        }
                        playGameWithTurns(x2, y2);
                        // if game over
                        if (isGameOver(lastTurn)) {
                            JOptionPane.showMessageDialog(null, "Player 1 has won the game!");
                            System.exit(0);
                        }
                        lastTurn = "Second Player";
                        // if the user clicks on a ship, the ship will be sunk
                        // and the score will be increased by 1
                        // we will also add an event listener to the placeShip button
                        setHitWithIcon(x2, y2);
                        if (checkWhetherShipIsSunk(x2, y2)) {
                            sunkShips++;

                            if (ships[x2][y2].getTypeOfShip() == "Carrier") {
                                score += 10;
                                JOptionPane.showMessageDialog(null, "You sunk the Carrier!");
                            } else if (ships[x2][y2].getTypeOfShip() == "Battleship") {
                                score += 8;
                                JOptionPane.showMessageDialog(null, "You sunk the Battleship!");

                            } else if (ships[x2][y2].getTypeOfShip() == "Cruiser") {
                                score += 6;
                                JOptionPane.showMessageDialog(null, "You sunk the Cruiser!");
                            } else if (ships[x2][y2].getTypeOfShip() == "Submarine") {
                                score += 4;
                                JOptionPane.showMessageDialog(null, "You sunk the Submarine!");
                            } else if (ships[x2][y2].getTypeOfShip() == "Destroyer") {
                                score += 2;
                                JOptionPane.showMessageDialog(null, "You sunk the Destroyer!");
                            }
                        }
                        playGameWithTurns(x2, y2);
                        // if game over
                        if (isGameOver(lastTurn)) {
                            JOptionPane.showMessageDialog(null, "Player 2 has won the game!");
                            System.exit(0);
                        }
                    } else {
                        // you missed
                        setMissWithIcon(x2, y2);
                    }
                }
            }
        };
        declareWinnerGUI();
    }

    /**
     * This method will place the ship in the grid.
     */
    public static void placeShip() {
        int x3 = MouseInfo.getPointerInfo().getLocation().x;
        int y3 = MouseInfo.getPointerInfo().getLocation().y;
        // we will use the x and y coordinates of the mouse to place the ships
        setPlayerShipsManually(x3, y3);
    }

    /**
     * This method restarts the game.
     *
     * @param mode the mode of the game, should be an integer
     */
    public static void restartGame(int mode) {
        if (mode == 1) {
            // ask the user whether he truly wants to restart the game
            int restart = JOptionPane.showConfirmDialog(null, "Are you sure you want to restart the game?", "Restart Game", JOptionPane.YES_NO_OPTION);
            if (restart == JOptionPane.YES_OPTION) {
                // if yes, we will reset the game
                //                hideCheatMode();
                //                for (int i = 0; i < 10; i++) {
                //                    for (int j = 0; j < 10; j++) {
                //                        // we will reset the grid
                //                        ships[i][j] = new ResettedGrid(0);
                //                        if (!cellButtons[i][j].isEnabled()) {
                //                            cellButtons[i][j].setEnabled(true);
                //                            cellButtons[i][j].setBackground(Color.CYAN);
                //                        }
                //                    }
                //                }
                //                totalNumberOfMoves = 0;
                //                totalMoves.setText("Total Moves: " + totalNumberOfMoves);
                //                sunkShips = 0;
                //                score = 0;
                //                // todo: specify player 1 and player 2 score. + Add more things to reset
                restartGameLoops(1);
            } else { // else if the user does not want to restart the game
                // we will do nothing
                System.out.println("You chose not to restart the game");
            }
        } else if (mode == 2) {
            restartGameLoops(2);
        }
    }

    /**
     * Helper function to avoid CPD.
     *
     * @param mode the mode of the game, should be an integer
     */
    public static void restartGameLoops(int mode) {
        hideCheatMode();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // we will reset the grid
                ships[i][j] = new ResettedGrid(0);
                if (!cellButtons[i][j].isEnabled()) {
                    cellButtons[i][j].setEnabled(true);
                    cellButtons[i][j].setBackground(Color.CYAN);
                }
            }
        }
        totalNumberOfMoves = 0;
        totalMoves.setText("Total Moves: " + totalNumberOfMoves);
        sunkShips = 0;
        score = 0;
    }


    /**
     * This method will quit the game.
     *
     * @param mode the mode of the game, should be an integer
     */
    public static void quitGame(int mode) {
        if (mode == 1) {
            int playerResponse = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the game?", "Quit Game", JOptionPane.YES_NO_OPTION);
            if (playerResponse == JOptionPane.YES_OPTION) {
                // quit the game
                System.exit(0);
            } else if (playerResponse == JOptionPane.NO_OPTION) {
                // do nothing
            }
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param event the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton btn = (JButton) event.getSource();
        System.out.println("clicked column " + btn.getClientProperty("column")
                + ", row " + btn.getClientProperty("row"));
    }

    /**
     * Dummy method used to change the color of a grid cell clicked.
     * (Simulation of the shot of the player)
     *
     * @return the color of the cell clicked
     */
    protected static JPanel getCell() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        panel.setPreferredSize(new Dimension(20, 20));
        panel.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent event) {
                panel.setBackground(Color.RED);
                panel.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
                panel.setPreferredSize(new Dimension(1000, 1000));
                panel.setVisible(true);
            }
        });

        return panel;
    }

    /**
     * This method will set the ship manually with an image.
     *
     * @param x1 the x coordinate of the mouse
     * @param y1 the y coordinate of the mouse
     */
    private static void setHitWithIcon(int x1, int y1) {
        String pathToImage = "/Users/cuenc/Documents/PF2-Project/src/gui/Images/tick.png";
        ImageIcon pict = new ImageIcon(Main.class.getClassLoader().getResource(pathToImage));
        cellButtons[x1][y1].setDisabledIcon(pict);
        cellButtons[x1][y1].setEnabled(false);
        numberOfClicks++;
    }

    /**
     * This method will set the ship manually with an image.
     *
     * @param x2 the x coordinate of the mouse
     * @param y2 the y coordinate of the mouse
     */
    public static void setMissWithIcon(int x2, int y2) {
        String pathToImage = "/Users/cuenc/Documents/PF2-Project/src/gui/Images/x.png";
        ImageIcon pict = new ImageIcon(Main.class.getClassLoader().getResource(pathToImage));
        cellButtons[x2][y2].setDisabledIcon(pict);
        cellButtons[x2][y2].setEnabled(false);
        numberOfClicks++;
    }

    /**
     * This method will check whether the game is over or not.
     *
     * @param lastTurn the player who had last turn of the game
     * @return true if the game is over, false if not
     */
    public static boolean isGameOver(String lastTurn) {
        if (sunkShips >= 10 && lastTurn.equals("Player 1")) {
            JOptionPane.showMessageDialog(null, "Player 1 has won the game!");
            return true;
        } else if (sunkShips >= 10 && lastTurn.equals("Player 2")) {
            JOptionPane.showMessageDialog(null, "Player 2 has won the game!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will check whether the ship is sunk or not.
     *
     * @param x4 the x coordinate of the ship
     * @param y4 the y coordinate of the ship
     * @return true if the ship is sunk, false if not
     */
    public static boolean checkWhetherShipIsSunk(int x4, int y4) {
        int row;
        int column;
        int count = 0;

        if (ships[x4][y4].getTypeOfShip() == "Carrier") {
            return true;
        } else {
            for (int i = 0; i < ships[x4][y4].getEachShipCoordinates().size(); i += 2) {
                row = ships[x4][y4].getEachShipCoordinates().get(i);
                column = ships[x4][4].getEachShipCoordinates().get(i + 1);

                if (!cellButtons[row][column].isEnabled()) {
                    count++;
                }
            }
            switch (ships[x4][y4].getTypeOfShip()) {
                case "Carrier":
                    if (count == 5) {
                        return true;
                    } else {
                        return false;
                    }
                case "Battleship":
                    if (count == 4) {
                        return true;
                    } else {
                        return false;
                    }
                case "Cruiser":
                case "Submarine":
                    if (count == 3) {
                        return true;
                    } else {
                        return false;
                    }
                case "Destroyer":
                    if (count == 2) {
                        return true;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
    }

    /**
     * This method plays the game with turns.
     *
     * @param xx the x coordinate of the mouse
     * @param yy the y coordinate of the mouse
     */
    public void playGameWithTurns(int xx, int yy) {
        setHitWithIcon(xx, yy);
        if (checkWhetherShipIsSunk(xx, yy)) {
            sunkShips++;

            if (ships[xx][yy].getTypeOfShip() == "Carrier") {
                score += 10;
                JOptionPane.showMessageDialog(null, "You sunk the Carrier!");
            } else if (ships[xx][yy].getTypeOfShip() == "Battleship") {
                score += 8;
                JOptionPane.showMessageDialog(null, "You sunk the Battleship!");

            } else if (ships[xx][yy].getTypeOfShip() == "Cruiser") {
                score += 6;
                JOptionPane.showMessageDialog(null, "You sunk the Cruiser!");
            } else if (ships[xx][yy].getTypeOfShip() == "Submarine") {
                score += 4;
                JOptionPane.showMessageDialog(null, "You sunk the Submarine!");
            } else if (ships[xx][yy].getTypeOfShip() == "Destroyer") {
                score += 2;
                JOptionPane.showMessageDialog(null, "You sunk the Destroyer!");
            }
        }
    }

    /**
     * Method that shows the winner of the game.
     */
    public void declareWinnerGUI() {
        if (s1 > s2) {
            JOptionPane.showMessageDialog(null, "Player 1 has won the game!");
            //closeJOptionPane();
        } else if (s1 < s2) {
            JOptionPane.showMessageDialog(null, "Player 2 has won the game!");
            //closeJOptionPane();
        } else {
            //closeJOptionPane();
            JOptionPane.showMessageDialog(null, "The Game has not started yet, you both start tied");
        }
    }

    // we want the joptionpane to be able to be closed automatically after 5 seconds
    //    public static void closeJOptionPane() {
    //        final JLabel label = new JLabel();
    //        int timerDelay = 3000;
    //        new Timer(timerDelay, new ActionListener() {
    //            int timeLeft = 3;
    //
    //            @Override
    //            public void actionPerformed(ActionEvent e) {
    //                if (timeLeft > 0) {
    //                    label.setText("\"The Game has not started yet, you both start tied\"");
    //                    timeLeft--;
    //                } else {
    //                    ((Timer) e.getSource()).stop();
    //                    Window win = SwingUtilities.getWindowAncestor(label);
    //                    win.setVisible(false);
    //                }
    //            }
    //        }) {{
    //            setInitialDelay(0);
    //        }}.start();
    //
    //        JOptionPane.showMessageDialog(null, label);
    //    }
}