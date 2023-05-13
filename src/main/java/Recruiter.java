/**
 * @author Dylan Minchhoff
 * @version 1.1.0
 *
 * represents a unit that can recruit
 */
public abstract class Recruiter extends Unit {

    private int numRecruits;

    // initializes the passed values to the respective members
    // initializes the number of recruits to 0
    public Recruiter(char symbol,
                     String name,
                     double health,
                     double healthModifier,
                     double damage,
                     double damageModifier,
                     int luck,
                     int xCor,
                     int yCor,
                     int movement,
                     int movementModifier,
                     String teamColor,
                     int numRecruits) {
        super(symbol,
                name,
                health,
                healthModifier,
                damage,
                damageModifier,
                luck,
                xCor,
                yCor,
                movement,
                movementModifier,
                teamColor);
        this.numRecruits = numRecruits;
    }

    // returns the current value of the number of recruits
    public int getNumRecruits() {
        return this.numRecruits;
    }

    // sets the number of recruits
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    /**
     *
     * @param fromRow - the row the action is being made from
     * @param fromColumn - the column the action is being made from
     * @param toRow - the row the action is being made to
     * @param toColumn - the column the action is being made to
     * @return true if the recruit path is valid
     */
    public boolean validRecruitPath(int fromRow, int fromColumn, int toRow, int toColumn) {
        return true;
    }
}
