package tui;

import model.Ai;
import model.Field;
import model.Game;
import model.Player;
import model.Ship;

import java.util.Scanner;
// was -> import java.util.*


/**
 * Text-User-Interface for the Battleship game.
 * This class represents the Battleship game and provides a TUI.
 * @author kelvin.likollari@usi.ch
 */
public class TuiUtil {
    private static Player player = new Player();
    public static final int FIELD_SIZE = 10;
    public static final int NUMBER_OF_SHIPS = 5;
    private static String name = "";

    static final Game game = new Game();

    private static Field aiFieldForPlayer = new Field(); // AI field for player
    private static Field aiFieldForAi = new Field(); // AI field for AI

    private static Field aiFieldForSecondAi = new Field(); // AI field for AI
    private static Field playerFieldForPlayer = new Field(); // Player field for player

    public static Field secondPlayerFieldForPlayer = new Field(); // second player field for player

    // line below added 06/05/22
    static Ship ship = new Ship(1, 1, 1,
            false, false, false, false);

    // --------------------------------------------------------------------------------------


    /**
     * run method - This is the main method of the TUI.
     * @throws InterruptedException if the thread is interrupted
     */
    public static void run() throws InterruptedException {

        System.out.println("Hi, kindly enter your name to proceed.");
        final Scanner scanner = new Scanner(System.in);
        final String name = scanner.nextLine();
        System.out.println("Hey " + name + "! Welcome to");
        System.out.println(""
                +
                "\n"
                +
                "██████╗░░█████╗░████████╗████████╗██╗░░░░░███████╗░██████╗██╗░░██╗██╗██████╗░\n"
                +
                "██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║░░░░░██╔════╝██╔════╝██║░░██║██║██╔══██╗\n"
                +
                "██████╦╝███████║░░░██║░░░░░░██║░░░██║░░░░░█████╗░░╚█████╗░███████║██║██████╔╝\n"
                +
                "██╔══██╗██╔══██║░░░██║░░░░░░██║░░░██║░░░░░██╔══╝░░░╚═══██╗██╔══██║██║██╔═══╝░\n"
                +
                "██████╦╝██║░░██║░░░██║░░░░░░██║░░░███████╗███████╗██████╔╝██║░░██║██║██║░░░░░\n"
                +
                "╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░░░░╚═╝░░░╚══════╝╚══════╝╚═════╝░╚═╝░░╚═╝╚═╝╚═╝░░░░░");
        System.out.println("\n");
        System.out.println("Welcome to Battleship : Call of Ships \n"
                + "© By Kelvin Likollari & Ilker Kaymak \n");
        System.out.println("\n");

//        Thread.sleep(2000);
        System.out.println("BattleShip is a game where you try to sink the enemy's ships");
//        Thread.sleep(2000);
        System.out.println("The goal is to sink all of the enemy's ships.");
//        Thread.sleep(2000);
        System.out.println("The game is played on a 10x10 grid."
                +
                "The grid is divided into 10 rows and 10 columns."
                + "The grid is numbered from 0 to 9.");
//        Thread.sleep(2000);
        System.out.println("Everything clear up to this point?");
//        Thread.sleep(2000);

        System.out.println("The player who sinks all of the enemy's ships wins.");
//        Thread.sleep(2000);
        System.out.println("You can either set your ships manually or randomly."
                +
                "Clear up to this point?");
//        Thread.sleep(2000);
        System.out.println("After that, you will have to also specify the direction of your ships.");
//        Thread.sleep(2000);

        System.out.println("When shooting, you will enter the coordinates of where you want to shoot.");
//        Thread.sleep(2000);

        System.out.println("The coordinates are in the form of X and Y "
                +
                "and they range from 0 to 9 (both included).");
//        Thread.sleep(2000);
        // create a scanner to read from the user
        Scanner scannerino = new Scanner(System.in);


        Game.shipSizesHelpful(); // Comment this one if you wanna play with 1 ships, else use the one below.
        // Game.shipSizesHelpful1(); // also uncomment the corresponding method in Game class

        Game.welcomingInstructions(scannerino);
        // printing instructions finishes here

        // At this point we must ask the user what game mode they want to play in.
        // we will get their input
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("What game mode do you want to play in?");
        System.out.println("1. PvP");
        System.out.println("2. PvA");
        System.out.println("3. AvA");


        int gameMode = scanner2.nextInt();

        // we will now check if the user entered a valid game mode
        if (gameMode == 1) {
            // if the user entered 1, we will start a PvP game
            // start off by asking the user's symbol
            System.out.println("Hey Player 1, what symbol would you like to use?");
            Game.getPlayerShipSymbol(scannerino);

            // also the second player's symbol
            System.out.println("Hey Player 2, what symbol would you like to use?");
            Game.getSecondPlayerShipSymbol(scannerino);
            // after we have set the symbols, we will create the game
            Game.updateGameDisplay(playerFieldForPlayer, secondPlayerFieldForPlayer);
            // now that we have updated the game display, we will ask the user to set the ships
            Game.setPlayerShips(scannerino);
            // update the game display
            Game.updateGameDisplay(playerFieldForPlayer, secondPlayerFieldForPlayer);
            // now we will ask the user to set the ships for the second player
            Game.setSecondPlayerShips(scannerino);
            // now that we have also set the ships for the second player, update the game display
            Game.updateGameDisplay(playerFieldForPlayer, secondPlayerFieldForPlayer);

            // now we start the game
            Game.startGamePVP(scannerino);

            Game.printHighestScore(scannerino);

        } else if (gameMode == 2) {
            // if the user entered 2, we will start a PvA game
            // start off by asking the user's symbol
            System.out.println("Hey Player, what symbol do you want to use?");
            Game.getPlayerShipSymbol(scannerino);

            Game.getAiShipSymbol(player.getSymbol());
            // now that we have set the symbols, we will create the game
            Game.updateGameDisplay(playerFieldForPlayer, aiFieldForPlayer);
            // now that we have updated the game display, we will ask the user to set the ships
            Game.setPlayerShips(scannerino);
            // update the board
            Game.updateGameDisplay(playerFieldForPlayer, aiFieldForPlayer);
            // now we will ask the user to set the ships for the second player
            Game.setAiShips();
            // now that we have also set the ships for the second player, update the game display
            Game.updateGameDisplay(playerFieldForPlayer, aiFieldForPlayer);

            // now we start the game
            Game.startGamePvsAI(scannerino);
            Game.printHighestScore(scannerino);
        } else if (gameMode == 3) {
            // if the user entered 3, we will start an AvA game
            Game.getAiShipSymbol(player.getSymbol());
            Game.updateGameDisplay(aiFieldForSecondAi, aiFieldForPlayer);
            Game.getSecondAiShipSymbol(player.getSymbol());
            // now that we have added the symbols, we will create the game
            Game.updateGameDisplay(aiFieldForSecondAi, aiFieldForAi);
            // now that we have updated the game display, we will ask the ai to set the ships
            Game.setAiShips();
            Game.updateGameDisplay(aiFieldForSecondAi, aiFieldForAi);


            // now we will ask the ai to set the ships for the second player
            Game.setSecondAiShips();
            // now that we have also set the ships for the second player, update the game display
            Game.updateGameDisplay(aiFieldForSecondAi, aiFieldForAi);
            // now we start the game
            Game.startGameAIvsAI(scannerino);
            Game.printHighestScore(scannerino);
        }

        // close the scanner
        scannerino.close();
    }
}
