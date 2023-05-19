
public class TomJerryUnit extends Attacker
{
    private boolean homingRocket;
    private boolean offerCheese;
    private boolean hiding;

    // initializes the passed parameters to their respective member fields
    // this calls the class's super constructor for all properties common to Unit classes
    public TomJerryUnit (char symbol,
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
                         boolean homingRocket,
                         boolean offerCheese,
                         boolean hiding,
                         String teamColor) {
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
                teamColor,
                0);
        // a new unit has not attacked anyone, hence numAttacks = 0
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    // initializes a new TomJerryUnit if no parameters are passed
    public TomJerryUnit() {
        this('T',
                "Tom & Jerry",
                100.0,
                0.0,
                25.0,
                0.0,
                0,
                5,
                5,
                1,
                0,
                true,
                true,
                false,
                "red");
    }

    /**
     *
     * @return a boolean if the unit can use homing rocket
     */
    public boolean canHomingRocket() {
        return this.homingRocket;
    }

    /**
     *
     * @return a boolean if the unit can offer cheese
     */
    public boolean canOfferCheese() {
        return this.offerCheese;
    }

    /**
     *
     * @return a boolean if the unit is hidden
     */
    public boolean isHiding() {
        return this.hiding;
    }


    /**
     *
     * @param homingRocket - a boolean representing if the unit can use the homing rocket
     * modifies the current unit's homing rocket to the passed value
     */
    public void setHomingRocket(boolean homingRocket) {
        this.homingRocket = homingRocket;
    }

    /**
     *
     * @param offerCheese - a boolean representing if the current unit can offer cheese
     * modifies the current unit's offerChesse to the passed value
     */
    public void setOfferCheese(boolean offerCheese) {
        this.offerCheese = offerCheese;
    }

    /**
     *
     * @param hiding - a boolean representing if the unit is hiding
     * modifies the current unit's hiding member to the passed value
     */
    public void setHiding(boolean hiding) {
        this.hiding = hiding;
    }

    /**
     *
     * @return a double representing the amount of damage this piece deals to another piece
     * the total damage this unit can deal is the unit's base damage plus the damage modifier
     * an additional 10 extra damage is added if the homing rocket is set to true
     */
    public double dealDamage() {
        double totalDamage = this.damage + this.damageModifier;
        return this.homingRocket ? totalDamage + 10.0 : totalDamage;
    }

    /**
     *
     * @param damage a double representing the amount of damage to be subtracted from this piece
     *
     * subtracts the amount of damage from the piece, if the current piece is
     * in hiding the piece will receive no health decrease
     */
    public void takeDamage (double damage) {
        this.health -= this.hiding ? 0.0 : damage;
    }

    /**
     *
     * @return a new TomJerryUnit
     */
    public TomJerryUnit spawn() {
        return new TomJerryUnit('t',
                "Little Tom",
                100.0,
                5.0,
                25.0,
                10.0,
                0,
                1,
                1,
                1,
                1,
                true,
                true,
                false,
                "red");
    }

    public boolean canSpawn()
    {
        return true;
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol)
    {
        return true;
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol)
    {
        int colDifference = Math.abs(fromCol - toCol);
        int rowDifference = Math.abs(fromRow - fromCol);
        return colDifference == 0 && rowDifference <= 2;
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol)
    {
        return validMovePath(fromRow, fromCol, toRow, toCol);
    }
}

