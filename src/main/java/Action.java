/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * represents an action a unit can make
 */
public abstract class Action {
    protected Game game;
    protected int fromSquareRow;
    protected int fromSquareColumn;
    protected int toSquareRow;
    protected int toSquareColumn;

    // initializes all the passed values to their respective member fields
    public Action(Game game, int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        this.game = game;
        this.fromSquareRow = fromSquareRow;
        this.fromSquareColumn = fromSquareColumn;
        this.toSquareRow = toSquareRow;
        this.toSquareColumn = toSquareColumn;
    }

    public abstract void preformAction(); // represents the specific implementation of an action
}
