/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * represents the move action of a piece
 */
public class ActionMove extends Action {

    // initializes the given values to their respective fields of the super class Action
    public ActionMove(Game game, int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        super(game, fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn);
    }

    /**
     * moves a game piece from a board square to another board square
     * when done the turn is changed
     */
    @Override
    public void preformAction() {
        Unit movingUnit = game.getGameBoard().getSquares()[fromSquareRow][fromSquareColumn].removeUnit();
        game.getGameBoard().getSquares()[toSquareRow][toSquareColumn].setUnit(movingUnit);

        // if (game.getGameBoard().getSquares()[toSquareRow][toSquareColumn].getUnit() == null) throw new RuntimeException("to the to spot is null");

        game.changeTurn();;
    }

    @Override
    public String toString() {

        return game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " team's " + game.getBoardSquares()[fromSquareRow][fromSquareColumn]
                .getUnit().getName() + " unit moves from " + fromSquareRow + "," + fromSquareColumn + " to " + toSquareRow + "," + toSquareColumn;

    }

}
