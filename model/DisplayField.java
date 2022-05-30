package model;

/**
 * This class's function is to display the Field used for
 * the game itself, represented by 10 by 10 grid.
 * @author kelvin.likollari@usi.ch
 */
public class DisplayField {

    // add colors to the terminal
    private static final String RESET_COLOR = "\u001B[0m";
    private static final String RED_COLOR = "red";

    private static final String FORMAT_STRING = "%4s|";
    private final int row; // row of the field
    private static int col; // column of the field
    private static final String EMPTY_T_SPACES = "\t\t\t\t\t\t";
    private static String columnPart;

    /**
     * Constructor of DisplayField.
     * @param row represents the number of rows
     * @param col represents the number of columns
     */
    public DisplayField(int row, int col) {
        this.row = row;
        DisplayField.col = col;
        columnPartitioner(col);
    }

    /**
     * Getter for the row.
     * @return the number of rows
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter for the col.
     * @return the number of columns
     */
    public int getCol() {
        return col;
    }


    /**
     * Method that displays textually the two fields.
     * @param field1 the player's field
     * @param field2 the opponent's field
     */
    public static void displayBoard(String[][] field1, String[][] field2) {
        // display the content of board
        displayWhoIsWho();
        displayHeader(col);
        for (int i = 0; i < field1.length; i++) {  // both arrays have to be the same dimension
            int rowNum = i;
            StringBuilder tmp1 = new StringBuilder(rowNum + "\t|");
            StringBuilder tmp2 = new StringBuilder(rowNum + "\t|");
            for (int j = 0; j < field1[0].length; j++) {
                if (field1[i][j].equals("[]")) {
                    String emptyCells = String.format(FORMAT_STRING," ");
                    tmp1.append(emptyCells);
                }
                if (field2[i][j].equals("[]")) {
                    String emptyCells = String.format(FORMAT_STRING," ");
                    tmp2.append(emptyCells);
                }
                if (!field1[i][j].equals("[]")) {
                    String symbol = String.format("%1s%2s%2s|"," ",field1[i][j]," ");
                    tmp1.append(symbol);
                }
                if (!field2[i][j].equals("[]")) {
                    String symbol = String.format("%1s%2s%2s|"," ",field2[i][j]," ");
                    tmp2.append(symbol);
                }
            }
            System.out.format(tmp1 + EMPTY_T_SPACES + tmp2 + "\n");
            System.out.println(columnPart + EMPTY_T_SPACES + columnPart);
        }
        System.out.println(displayFieldColumns(col) + EMPTY_T_SPACES + displayFieldColumns(col));
        System.out.println();
    }

    /**
     * Method that displays textually the columns.
     * @param col represents the number of columns
     * @return columns represent as Strings
     */
    public static String displayFieldColumns(int col) {
        // display the column
        String colNum = "\t|";
        for (int j = 0; j < col; j++) {
            String num =  RED_COLOR + j + RESET_COLOR ;
            colNum += String.format(" ",num," ");
        }
        return colNum;
        // String output = String.format(colNum + emptySpaces + "%1s" + colNum);
        // System.out.println(output);
    }
    
    /**
     * Method that displays textually owner of a field.
     */
    public static void displayWhoIsWho() {
        // print out what is what
        String distance = "\t\t\t"; // tab space between the header of the boards
        String unit = "     ";
        String s1 = "The player's own board:";
        String s2 = "The opponent's board:";
        for (int i = 0; i < 4; i++) {
            distance += unit;
        }
        distance += EMPTY_T_SPACES;
        String output = String.format(s1 + distance + s2);
        System.out.println(output);
    }
    
    /**
     * Method that displays the header.
     * @param col represents the position of the header
     */
    public static void displayHeader(int col) {
        // display header
        String tmp = String.format(FORMAT_STRING, " ");
        for (int i = 0; i < col; i++) {
            tmp += String.format(FORMAT_STRING, " ");
        }
        System.out.format(tmp + EMPTY_T_SPACES + tmp + "\n");
        System.out.println(columnPart + EMPTY_T_SPACES + columnPart);
    }
    
    /**
     * Mehtod that separates the columns.
     * @param col represents the number of columns
     */
    public void columnPartitioner(int col) {
        // set the separator
        String separatorLine = "----+";
        for (int i = 0; i < col; i++) {
            separatorLine += "----+";
        }
        this.columnPart = separatorLine;
    }

}

// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
// how to add color to the output in terminal.
