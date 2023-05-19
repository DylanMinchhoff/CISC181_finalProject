/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * A class representation of a square on the game-board
 */
public class BoardSquare {
    protected boolean isEmpty;
    protected Unit unit;
    protected String squareColor;
    protected boolean isMountain;

    /**
     *
     * @param squareColor - the color of the current square
     */
    BoardSquare(String squareColor) {
        this.squareColor = squareColor;
        this.unit = null;
        this.isEmpty = true;
        this.isMountain = false;
    }

    /**
     *
     * @param squareColor - the color of the current square
     * @param isEmpty - a boolean representing if the square is empty or not
     * @param isMountain - a boolean representing if the square is a mountain
     */
    BoardSquare(String squareColor, boolean isEmpty, boolean isMountain) {
        this.squareColor = squareColor;
        this.unit = null;
        this.isEmpty = isEmpty;
        this.isMountain = isMountain;
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
     * @return - true if the current boardSquare is a mountain
     */
    public boolean isMountain() {
        return this.isMountain;
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
     *
     * @param mountain - a boolean representing the place of a mountain
     * modifies the current square to mountain or not
     */
    public void setMountain(boolean mountain) {
        this.isEmpty = !mountain;
        this.isMountain = mountain;
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
        if (this.isMountain) return "X^X^X^X";
        return (this.unit == null) ? "-------" : "-" + unit + "-";
    }


}
