/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * A class representation of a square on the game-board
 */
public class BoardSquare {
    boolean isEmpty;
    Unit unit;
    String squareColor;
    BoardSquare(String squareColor) {
        this.squareColor = squareColor;
        this.unit = null;
        this.isEmpty = true;
    }

    /**
     *
     * @return the current unit located in the board square
     */
    public Unit getUnit() {
        return this.unit;
    }

    /**
     *
     * @return if the board square is empty
     */
    public boolean isEmpty() {
        return this.isEmpty;
    }

    /**
     *
     * @return the current boards square color
     */
    public String getSquareColor() {
        return this.squareColor;
    }

    /**
     *
     * @param unit - a unit
     * modifies the current to be set to the passed unit
     *
     */
    public void setUnit(Unit unit) {
        this.isEmpty = (unit == null);
        this.unit = unit;
    }

    /**
     * sets the current unit to null
     * @return the unit that was in the board square
     */
    public Unit removeUnit() {
        Unit currentUnit = this.unit;
        this.unit = null;
        this.isEmpty = true;
        return currentUnit;
    }

    /**
     *
     * @return a string representation of the current BoardSquare
     * if the square is null 7 '-' are returned
     * if there is a unit to unit's to-string is called with a '-' is added to the beginning and end
     */
    @Override
    public String toString() {
        return (this.unit == null) ? "-------" : "-" + unit + "-";
    }


}
