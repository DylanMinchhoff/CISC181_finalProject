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
    private final int POINTS_PER_UNIT = 20;
    private final int POINTS_TO_WIN = 500;

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

    private void setupMountains() {
        int numMountains = 10;
        for(int i = 0; i < numMountains; i++) {
            getGameBoard().findRandomEmptySpace().setMountain(true);
        }
    }
    private void setUpFlag(int numRows, int numColumns) {
        boolean rowNotOnEdge = false, columnNotOnEdge = false;
        int randRow = 0, randColumn = 0;
        while(!(rowNotOnEdge && columnNotOnEdge)) {
            randRow = (int)(Math.random() * (numRows));
            randColumn = (int)(Math.random() * (numColumns));
            rowNotOnEdge = randRow != 0 && randRow != numRows-1;
            columnNotOnEdge = randColumn != 0 && randColumn != numColumns-1;
        }
        gameBoard.setFlagSquare(new FlagSquare(randRow, randColumn));
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
        // adding the flag
        setUpFlag(numRows, numColumns);
        // adding mountains
        setupMountains();

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
    private boolean hasOverPoints(Player player) {
        return player.getPoints() >= POINTS_TO_WIN;
    }

    /**
     * preforms an OXR comparison on the players, if one of the teams have no units
     * but not both
     * @return - true if only one team has a size of zero
     */
    public boolean isAWinner() {
        // xor comparison
        return (hasOverPoints(playerOne) ^ hasOverPoints(playerTwo));
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
        if ((playerOne.getPoints() >= POINTS_TO_WIN) && (playerTwo.getPoints() >= POINTS_TO_WIN)) return null;
        if (playerOne.getPoints() >= POINTS_TO_WIN) return playerOne;
        return playerTwo;
    }

    /**
     *
     * @return - true if either player had reached a team of zero
     */
    public boolean isGameEnded() {
        return hasOverPoints(playerOne) || hasOverPoints(playerTwo);
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
                .append("\n" + getCurrentPlayer().toString() + "\n")
                .append("\n" + getCurrentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getOpponentPlayer().toString() + "\n")
                .append("\n" + getOpponentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getPlayersTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }

    private boolean hasUnitFromTeam(int row, int column, Player player) {
        Unit unit = gameBoard.getSquares()[row][column].getUnit();
        if(unit == null) return false;
        return unit.getTeamColor().equals(player.getPlayersTeam().getTeamColor());
    }
    public void checkContestation() {
        int currentPlayerUnits = 0, opposingPlayerUnits = 0;

        Player currentPlayer = this.getCurrentPlayer();
        Player opponentPlayer = this.getOpponentPlayer();

        FlagSquare flag = gameBoard.getFlagSquare();
        Team teamBefore = (flag.isContested()) ? flag.getMajorityTeam() : null;

        int xCor = flag.getXCor();
        int yCor = flag.getYCor();
        //checking 3 rows
        int currentRow;
        int currentColumn;
        for (int i = 0; i < 3; i++) {
            currentRow = (yCor - 1) + i;
            for (int j = 0; j < 3; j++) {
                currentColumn = (xCor - 1) + j;
                if (gameBoard.inBounds(currentRow, currentColumn)) {
                    // the current player is now the previous player because the turn has been switched
                    if (hasUnitFromTeam(currentRow, currentColumn, currentPlayer)) currentPlayerUnits++;
                    if (hasUnitFromTeam(currentRow, currentColumn, opponentPlayer)) opposingPlayerUnits++;
                }
            }
        }
        // updating the flag
        if (currentPlayerUnits > opposingPlayerUnits) {
            flag.setMajorityTeam(currentPlayer.getPlayersTeam());
            flag.setContested(true);
        }
        if (opposingPlayerUnits > currentPlayerUnits) {
            flag.setMajorityTeam(opponentPlayer.getPlayersTeam());
            flag.setContested(true);
        }
        else {
            flag.setMajorityTeam(null);
            flag.setContested(false);
        }
        // adding points to the respective player's
        if (teamBefore == null || flag.getMajorityTeam() == null) return;

        if (teamBefore == currentPlayer.getPlayersTeam()) {
            currentPlayer.setPoints(currentPlayer.getPoints() + (currentPlayerUnits - opposingPlayerUnits) * POINTS_PER_UNIT);
        }
        if (teamBefore == opponentPlayer.getPlayersTeam()) {
            opponentPlayer.setPoints(opponentPlayer.getPoints() + (opposingPlayerUnits - currentPlayerUnits) * POINTS_PER_UNIT);
        }
    }


}