import java.util.Collections;

/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * a class representing the currently running game
 */
public class Game {
    private GameBoard gameBoard;
    private Player playerOne;
    private Player playerTwo;


    /**
     *
     * @param player - the player whose unit's to be placed on the game-board
     *
     * finds a random empty space to allocate each unit in a given player's team in the board
     */
    private void playerSetup(Player player) {
        for (Unit unit : player.getPlayersTeam().getTeamUnits()) {
            gameBoard.findRandomEmptySpace().setUnit(unit);
        }
    }

    /**
     *
     * @param numRows - the number of rows for the game-board
     * @param numColumns - the number of columns for the game-board
     * initializes the game board by creating the game-board and calls a helper function
     * to allocate each of the player's unit's randomly on the board
     */
    private void initializeGameBoard(int numRows, int numColumns) {
        // creating the game board
        this.gameBoard = new GameBoard(numRows, numColumns);

        // setting up each player's team
        playerSetup(this.playerOne);
        playerSetup(this.playerTwo);
    }

    /**
     *
     * @param numRows - the number of rows for the game-board
     * @param numColumns - the number of columns for the game-board
     * @param playerOne - the first player in the game
     * @param playerTwo - the second player in the game
     */
    public Game(int numRows, int numColumns, Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.initializeGameBoard(numRows, numColumns);
    }

    /**
     *
     * @return  -the game-board of this current game
     */
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }

    /**
     *
     * @return - the player whose turn it is
     */
    public Player getCurrentPlayer() {
        return (playerOne.isTurn()) ? playerOne : playerTwo;
    }

    /**
     *
     * @return - the player whose turn it is not
     */
    public Player getOpponentPlayer() {
        return (playerOne.isTurn()) ? playerTwo : playerOne;
    }

    /**
     *
     * @param player - A player object
     * @return - if it is the given player's turn
     */
    public boolean isTurn(Player player) {
        return player.isTurn();
    }

    /**
     *
     * @return - an array of BoardSquares in the current game
     */
    public BoardSquare[][] getBoardSquares() {
        return this.gameBoard.getSquares();
    }

    /**
     * modifies the turns of the players by negating the turns of the two players
     */
    public void changeTurn() {
        playerOne.setTurn(!playerOne.isTurn());
        playerTwo.setTurn(!playerTwo.isTurn());
    }

    /**
     *
     * @param player - a player of the game
     * @return - true if the passed player's team has a size of zero
     */
    private boolean isZero(Player player) {
        return player.getPlayersTeam().getTeamUnits().size() == 0;
    }

    /**
     * preforms an OXR comparison on the players, if one of the teams have no units
     * but not both
     * @return - true if only one team has a size of zero
     */
    public boolean isAWinner() {
        // xor comparison
        return (isZero(playerOne) ^ isZero(playerTwo));
    }

    /**
     *
     * @return - the player of who won the game,
     * who still has their team
     * if there's a tie it will return null
     *
     * IMPORTANT: do not call this method if there is no winner
     */
    public Player getWinner() {
        if (isZero(playerOne) && isZero(playerTwo)) return null;
        if (isZero(playerOne)) return playerTwo;
        return playerOne;
    }

    /**
     *
     * @return - true if either player had reached a team of zero
     */
    public boolean isGameEnded() {
        return isZero(playerOne) || isZero(playerTwo);
    }

    /**
     *
     * @return - a string representation of the current game including the board and each player's unit and turn
     */
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getCurrentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getOpponentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getPlayersTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }


}