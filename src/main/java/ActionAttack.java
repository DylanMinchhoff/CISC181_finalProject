/**
 * @author Dylan minchhoff
 * @version 1.0.0
 *
 * represents an attack action a piece can make
 */
public class ActionAttack extends Action {
    // initializes the given values to their respective fields of the super class Action
    public ActionAttack(Game game, int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        super(game, fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn);
    }

    /**
     *
     * @param square - the board square with the unit to be removed
     * @param team - the team the unit is to be removed from
     *
     * removes the unit from the board square and removes it from the current player's team
     */
    private void removeUnit(BoardSquare square, Team team) {
        // removes unit from board and from the team
        team.removeUnitsFromTeam(square.getUnit());
        square.removeUnit();
    }

    /**
     * preforms an "attack" on the Unit in the to row/column
     * only an Attacker may attack, if the attacked unit is a BartSimpson the unit is removed
     * changes the turn
     */
    @Override
    public void preformAction() {
        Unit attacking = game.getGameBoard().getSquares()[fromSquareRow][fromSquareColumn].getUnit();
        // only an attacker Unit may attack
        if (!(attacking instanceof Attacker)) return;
        Unit attacked = game.getGameBoard().getSquares()[toSquareRow][toSquareColumn].getUnit();

        // only use health fields if unit is not a BartSimpsonUnit
        if (attacked instanceof BartSimpsonUnit) {
            removeUnit(game.getGameBoard().getSquares()[toSquareRow][toSquareColumn],
                    game.getOpponentPlayer().getPlayersTeam());
            game.changeTurn();
            return;
        }
        attacked.setHealth(attacked.getHealth() - ((TomJerryUnit)attacking).dealDamage());

        // removing a "dead piece from the board"
        if (attacked.getHealth() <= 0.0) {
            removeUnit(game.getGameBoard().getSquares()[toSquareRow][toSquareColumn],
                    game.getOpponentPlayer().getPlayersTeam());
        }

        game.changeTurn();
    }

    @Override
    public String toString() {

        return game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " team's " + game.getBoardSquares()[fromSquareRow][fromSquareColumn]
                .getUnit().getName() + " attacks " + game.getOpponentPlayer().getPlayersTeam().getTeamColor() + "'s " +
                game.getBoardSquares()[toSquareRow][toSquareColumn].getUnit() + " from "
                + fromSquareRow + "," + fromSquareColumn + " to " + toSquareRow + "," + toSquareColumn;

    }

}
