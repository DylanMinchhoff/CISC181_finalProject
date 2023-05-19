/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * represents the spawn action a piece can preform
 */
public class ActionSpawn extends Action{

    // initializes the given values to their respective fields of the super class Action
    public ActionSpawn(Game game, int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        super(game, fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn);
    }

    /**
     * spawns a new piece on the toRow/toColumn specified
     * changes the turn when done
     */
    @Override
    public void preformAction() {
        Unit unit = game.getGameBoard().getSquares()[fromSquareRow][fromSquareColumn].getUnit().spawn();
        game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(unit);
        game.getGameBoard().getSquares()[toSquareRow][toSquareColumn].setUnit(unit);
        game.changeTurn();
    }
    @Override
    public String toString() {
        return game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " team's " + game.getBoardSquares()[fromSquareRow][fromSquareColumn]
                .getUnit().getName() + " unit spawns a new unit to " + toSquareRow + "," + toSquareColumn;

    }

}
