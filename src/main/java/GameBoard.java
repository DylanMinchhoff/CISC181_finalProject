
//
/**
 * @author Dylan Minchhoff
 * @version 1.7.0
 *
 * A class representing a game-board for playing a game on
 */
public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;
    private FlagSquare flagSquare;

    /**
     *
     * @param numRows - the number of rows for the board
     * @param numColumns - the number of columns for the board
     *
     * sets up an empty board to play the game on
     */
    GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        this.setUpEmptyBoard();
    }

    /**
     *
     * @return - the current flagSquare on the board
     */
    public FlagSquare getFlagSquare() {
        return this.flagSquare;
    }

    /**
     *
     * @return the number of rows in the game-board
     */
    public int getNumRows() {
        return this.numRows;
    }

    /**
     *
     * @return the number of columns in the game-board
     */
    public int getNumColumns() {
        return numColumns;
    }

    /**
     *
     * @param flagSquare - the flagSquare to be set on the board
     * modifies the board to set the flagSquare at the passed flag's (x,y)
     */
    public void setFlagSquare(FlagSquare flagSquare) {
        if (flagSquare == null) return;
        this.squares[flagSquare.getYCor()][flagSquare.getXCor()] = flagSquare;
        this.flagSquare = flagSquare;
    }

    /**
     *
     * @return an array of the BoardSquares of this game-board
     */
    public BoardSquare[][] getSquares() {
        return this.squares;
    }

    /**
     *
     * @param rowIndex - the row to be accessed on the game-board
     * @param columnIndex - the column to be accessed on the game-board
     * @return a boolean if the given coordinate (row, column) pair is in the bounds of the given game board
     */
    public boolean inBounds(int rowIndex, int columnIndex) {
        return (0 <= rowIndex && rowIndex <= this.numRows - 1) && (0 <= columnIndex && columnIndex <= this.numColumns - 1);
    }

    /**
     * initializes each square of the game-board with a random color
     */
    private void setUpEmptyBoard() {
        String[] colors = new String[] {"Black", "White", "Blue", "Red", "Orange", "Green"};
        int numColors = colors.length;
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j++) {
                // choosing a random color from the colors array
                String currColor = colors[(int)(Math.random() * numColors)];
                this.squares[i][j] = new BoardSquare(currColor);
            }
        }

    }

    /**
     *
     * @return the string representation of the game-board
     */
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

    /**
     *
     * @param row - the row of the piece
     * @param column - column of the current piece
     * @return - true if the passed (x,y) or (row, column) is adjacent to the flag on the board
     */
    private boolean adjacentToFlag(int row, int column) {
        int currentRow;
        int currentColumn;
        for (int i = 0; i < 3; i++) {
            currentRow = (row - 1) + i;
            for (int j = 0; j < 3; j++) {
                currentColumn = (column - 1) + j;
                if (inBounds(currentRow, currentColumn)) {
                    if (squares[currentRow][currentColumn] instanceof FlagSquare) return true;
                }
            }
            // x 0 1 2 3
            // 0 - - - -
            // 1 - / - -
            // 2 - - - -
            // 3 - - - -
        }
        // none of the surrounding squares are the flag
        return false;
    }

    /**
     *
     * @return the BoardSquare that does not contain any unit and is not directly adjacent to the flag on the board
     * this method will run until an empty game-board square (one with unit as a null value) is reached
     * if no space is reached, this method will run indefinitely
     */
    public BoardSquare findRandomEmptySpace() {
        // WARNING: if the board contains no empty spaces, this loop will run indefinitely
        while(true) {
            int randRow = (int)(Math.random() * this.numRows);
            int randColumn = (int)(Math.random() * this.numColumns);
            if (squares[randRow][randColumn].isEmpty() && (!adjacentToFlag(randRow, randColumn))) return squares[randRow][randColumn];
        }
    }
}
