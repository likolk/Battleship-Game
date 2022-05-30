package gui;

// Commented the ones below because i'm given error: Too many static imports may lead to messy code
// if we remove the *
import static java.awt.Color.BLACK;
import static java.awt.Color.MAGENTA;
import static java.awt.Color.PINK;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;



/**
 * This class is the welcome screen for the game.
 * @author kelvin.likollari@usi.ch
 */
public class JWelcome extends JFrame {

    /**
     * Launch the application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new JWelcome().setVisible(true);
    }


    /**
     * The following constructor creates the frame.
     */
    public JWelcome() {
        super();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException
                         | InstantiationException
                         | IllegalAccessException
                         | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                //JFrame frame = new JFrame("Battleship: Call Of Ships");
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.pack();
                //frame.setLocationRelativeTo(null);
                //frame.setVisible(true);
            }
        });
        clickOnWelcome();
        setJwelcomeWindowStuff();
    }

    /**
     * ClickOnWelcome method containing the key event listeners.
     */
    public void clickOnWelcome() {

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {

                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    JWelcome.this.dispose(); // closes the frame
                    // and open the src/gui/Main.java class
                    new JWelcome().setVisible(true);
                }
            }
        });
    }

    /**
     * Method that sets the window for the jwelcome window.
     */
    public void setJwelcomeWindowStuff() {

        final String font = "Comfortaa";

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(00, 00, 1920, 1080);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(BLACK);
        panel.setBounds(00, 00, 1920, 1080);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel labelOne = new JLabel("Welcome to Battleship: Call of Ships!");
        labelOne.setHorizontalAlignment(SwingConstants.CENTER);
        labelOne.setForeground(PINK);
        labelOne.setFont(new Font(font, Font.BOLD, 50));
        labelOne.setBounds(-120, -250, 1920, 1080);
        panel.add(labelOne);

        JLabel labelTwo = new JLabel("© Likollari Kelvin - Kaymak Ilker");
        labelTwo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTwo.setForeground(RED);
        labelTwo.setFont(new Font(font, Font.BOLD, 50));
        labelTwo.setBounds(-110, -120, 1920, 1080);
        panel.add(labelTwo);

        JLabel labelThree = new JLabel("What would you like to do?");
        labelThree.setHorizontalAlignment(SwingConstants.CENTER);
        labelThree.setForeground(YELLOW);
        labelThree.setFont(new Font(font, Font.BOLD, 50));
        labelThree.setBounds(-70, 0, 1920, 1080);
        panel.add(labelThree);

        JButton quit = new JButton("Quit");
        quit.setBounds(630, 620, 100, 50);
        quit.setBackground(MAGENTA);
        quit.setForeground(BLACK);
        quit.setFont(new Font(font, Font.BOLD, 30));
        quit.setBorderPainted(true);
        quit.setOpaque(true);
        quit.setBorder(null);

        quit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                System.exit(0);
            }
        });

        JButton start = new JButton("Start Playing");
        start.setBounds(820, 620, 250, 50);
        start.setBackground(MAGENTA);
        start.setForeground(BLACK);
        start.setFont(new Font("Comfortaa", Font.BOLD, 30));
        start.setBorderPainted(true);
        start.setOpaque(true);
        start.setBorder(null);

        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                // dispose this frame
                JWelcome.this.dispose();
                // closes the frame
                // and open the src/gui/Main.java class
                new Main().setVisible(true);

            }
        });
        panel.add(quit);
        panel.add(start);
    }
}