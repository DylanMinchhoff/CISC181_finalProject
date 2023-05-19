/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * represents the recruit action of a given piece
 */
public class ActionRecruit extends Action{
    // initializes the given values to their respective fields of the super class Action
    public ActionRecruit(Game game, int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        super(game, fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn);
    }

    /**
     * removes the Unit that was recruited from the opponent’s team
     * adds the Unit that was recruited to the current team
     * changes the turn
     */
    @Override
    public void preformAction() {
        Unit unitRecruited = game.getGameBoard().getSquares()[toSquareRow][toSquareColumn].getUnit();
        game.getOpponentPlayer().getPlayersTeam().removeUnitsFromTeam(unitRecruited);
        game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(unitRecruited);
        game.changeTurn();
    }

    @Override
    public String toString() {

        return game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " team's " + game.getBoardSquares()[fromSquareRow][fromSquareColumn]
                .getUnit().getName() + " unit recruits from " + fromSquareRow + "," + fromSquareColumn + " to " + toSquareRow + "," + toSquareColumn +
                " previously on the " + game.getOpponentPlayer().getPlayersTeam().getTeamColor() + " team";

    }

}
