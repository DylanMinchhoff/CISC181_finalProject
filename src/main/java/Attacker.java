/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 */
public abstract class Attacker extends Unit{
    private int numAttacks;

    // initializes the passed values to the respective members, calls Unit's constructor
    // initializes the number of attacks to 0
    public Attacker(char symbol,
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
                    int numAttacks) {
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
        this.numAttacks = numAttacks;
    }

    // returns the number of attacks this current unit has made
    public int getNumAttacks() {
        return this.numAttacks;
    }

    // sets the unit's number of attacks to the passed value
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    /**
     *
     * @param fromRow - the row the action is being made from
     * @param fromColumn - the column the action is being made from
     * @param toRow - the row the action is being made to
     * @param toColumn - the column the action is being made to
     * @return true if the attack path is valid
     */
    public boolean validAttackPath(int fromRow, int fromColumn, int toRow, int toColumn) {
        return true;
    }




}
