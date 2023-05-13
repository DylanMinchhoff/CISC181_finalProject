/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 */
public class Rules {
    /**
     *
     * @param team - a team
     * @param unit - a unit
     * @return - true if the unit belongs to the passed team
     */
    private static boolean belongsTo(Team team, Unit unit) {
        return team.getTeamColor().equals(unit.getTeamColor());
    }

    /**
     *
     * @param game - the current game being played
     * @param fromRow - the row the action is being made from
     * @param fromColumn - the column the action is being made from
     * @param toRow - the row the action is being made to
     * @param toColumn - the column the action is being made to
     * @return - true if the unit can move to the specified square
     */
    private static boolean validMove(Game game, int fromRow, int fromColumn, int toRow, int toColumn) {
        // the move to square must be empty
        if (!game.getBoardSquares()[toRow][toColumn].isEmpty()) return false;
        return game.getBoardSquares()[fromRow][fromColumn].getUnit().
                validMovePath(fromRow, fromColumn, toRow, toColumn);
    }

    /**
     *
     * @param game - the current game being played
     * @param fromRow - the row the action is being made from
     * @param fromColumn - the column the action is being made from
     * @param toRow - the row the action is being made to
     * @param toColumn - the column the action is being made to
     * @return - true if the unit can spawn a new unit
     */
    private static boolean validSpawn(Game game, int fromRow, int fromColumn, int toRow, int toColumn) {
        if (!game.getBoardSquares()[toRow][toColumn].isEmpty()) return false;
        Unit unit = game.getBoardSquares()[fromRow][fromColumn].getUnit();
        return unit.validSpawnPath(fromRow, fromColumn, toRow, toColumn) && unit.canSpawn();
    }

    /**
     *
     * @param game - the current game being played
     * @param fromRow - the row the action is being made from
     * @param fromColumn - the column the action is being made from
     * @param toRow - the row the action is being made to
     * @param toColumn - the column the action is being made to
     * @return - true if the unit can recruit the unit
     */
    private static boolean validRecruit(Game game, int fromRow, int fromColumn, int toRow, int toColumn) {
        Unit fromUnit = game.getBoardSquares()[fromRow][fromColumn].getUnit();
        Unit toUnit = game.getBoardSquares()[toRow][toColumn].getUnit();
        if (!(fromUnit instanceof BartSimpsonUnit)) return false;
        // recruit is valid if
        // the recruiter is on the current player's team
        // the recruited unit is on the opponent's team
        // the unit has a valid recruit path to the recruited unit
        return (belongsTo(game.getCurrentPlayer().getPlayersTeam(), fromUnit)
                &&
                belongsTo(game.getOpponentPlayer().getPlayersTeam(), toUnit)
                &&
                ((BartSimpsonUnit) fromUnit).validRecruitPath(fromRow, fromColumn, toRow, toColumn));
    }

    /**
     *
     * @param game - the current game being played
     * @param fromRow - the row the action is being made from
     * @param fromColumn - the column the action is being made from
     * @param toRow - the row the action is being made to
     * @param toColumn - the column the action is being made to
     * @return - true if the unit can attack the unit
     */
    private static boolean validAttack(Game game, int fromRow, int fromColumn, int toRow, int toColumn) {
        Unit fromUnit = game.getBoardSquares()[fromRow][fromColumn].getUnit();
        Unit toUnit = game.getBoardSquares()[toRow][toColumn].getUnit();
        if (!(fromUnit instanceof TomJerryUnit)) return false;
        // attack is valid if
        // the attacker is on the current player's team
        // the attacked unit is on the opponent's team
        // the unit has a valid attack path to the attacked unit
        return (belongsTo(game.getCurrentPlayer().getPlayersTeam(), fromUnit)
                &&
                belongsTo(game.getOpponentPlayer().getPlayersTeam(), toUnit)
                &&
                ((TomJerryUnit)fromUnit).validAttackPath(fromRow, fromColumn, toRow, toColumn));
    }

    /**
     *
     * @param game - the current game being played
     * @param fromRow - the row the action is being made from
     * @param fromColumn - the column the action is being made from
     * @param toRow - the row the action is being made to
     * @param toColumn - the column the action is being made to
     * @param actionType - the type of action being preformed
     * @return - true if the given unit on the from row/column can preform the given action
     */
    public static boolean checkValidAction(Game game, int fromRow, int fromColumn, int toRow, int toColumn, char actionType) {
        // the action is with the bounds of the board
        if (!game.getGameBoard().inBounds(fromRow, fromColumn)) return false;
        if (!game.getGameBoard().inBounds(toRow, toColumn)) return false;

        // there is a unit on the square preforming the action, and it belongs to the current team
        if (game.getBoardSquares()[fromRow][fromColumn].isEmpty()) return false;
        if (!belongsTo(game.getCurrentPlayer().getPlayersTeam() ,game.getBoardSquares()[fromRow][fromColumn].getUnit())) return false;

        // checking the specified action
        switch (Character.toUpperCase(actionType)) {
            case 'M' -> {
                return validMove(game, fromRow, fromColumn, toRow, toColumn);
            }
            case 'S' -> {
                return validSpawn(game, fromRow, fromColumn, toRow, toColumn);
            }
            case 'R' -> {
                return validRecruit(game, fromRow, fromColumn, toRow, toColumn);
            }
            case 'A' -> {
                return validAttack(game, fromRow, fromColumn, toRow, toColumn);
            }
        }
        // if it's not a valid action type or anything else
        return false;
    }
}
