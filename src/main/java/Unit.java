/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * This class represents the common characteristics found in all units and to be inherited
 * by all specific units
 */
public abstract class Unit {
    protected char symbol;
    protected String name;
    protected double health;
    protected double healthModifier;
    protected double damage;
    protected double damageModifier;
    protected int luck;
    protected int xCor;
    protected int yCor;
    protected int movement;
    protected int movementModifier;
    protected String teamColor;

    // initializes the passed values to the respective members
    public Unit (char symbol, String name, double health, double healthModifier, double damage,
                 double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor) {
        this.symbol = symbol;
        this.name = name;
        this.health = health;
        this.healthModifier = healthModifier;
        this.damage = damage;
        this.damageModifier = damageModifier;
        this.luck = luck;
        this.xCor = xCor;
        this.yCor = yCor;
        this.movement = movement;
        this.movementModifier = movementModifier;
        this.teamColor = teamColor;
    }

    // accessor methods

    /**
     * @return the symbol representing this class
     */
    public char getSymbol() {
        return this.symbol;
    }

    /**
     * @return a string representing the name of this class
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return a double representing the health of this 
     */
    public double getHealth() {
        return this.health;
    }

    /**
     * @return the health modifier of this class
     */
    public double getHealthModifier() {
        return this.healthModifier;
    }

    /**
     * @return the damage this unit does to another unit
     */
    public double getDamage() {
        return this.damage;
    }

    /**
     * @return the damage modifier of this unit
     */
    public double getDamageModifier() {
        return this.damageModifier;
    }

    /**
     * @return the luck of this unit
     */
    public int getLuck() {
        return this.luck;
    }

    /**
     * @return the x coordinate of this unit
     */
    public int getxCor() {
        return this.xCor;
    }

    /**
     * @return the y coordinate of this unit
     */
    public int getyCor() {
        return this.yCor;
    }

    /**
     * @return the movement of this unit
     */
    public int getMovement() {
        return this.movement;
    }

    /**
     * @return the movement modifier of this unit
     */
    public int getMovementModifier() {
        return this.movementModifier;
    }

    /**
     * @return the team color of this unit
     */
    public String getTeamColor() {
        return teamColor;
    }

    // mutator methods

    /**
     *
     * @param symbol the new symbol for the unit
     * modifies the current unit's symbol to the new symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @param name the new name for the unit
     * modifies the current unit's name to the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param health - the new health for the unit
     * modifies the current unit's health to the new health
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * @param healthModifier - the new healthModifier for the unit
     * modifies the current unit's healthModifier to the passed value
     */
    public void setHealthModifier(double healthModifier) {
        this.healthModifier = healthModifier;
    }

    /**
     *
     * @param damage - the new damage for the unit
     * modifies the current unit's damage to the passed value
     */
    public void setDamage(double damage) {
        this.damage = damage;
    }

    /**
     *
     * @param damageModifier - the new damageModifier for the unit
     * modifies the current unit's damageModifier to the passed value
     */
    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    /**
     *
     * @param luck - an int to represent the luck for the unit
     * modifies the current unit's luck to the passed value
     */
    public void setLuck(int luck) {
        this.luck = luck;
    }

    /**
     *
     * @param xCor - the x cor for the unit
     * modifies the current unit's xCor to the passed value
     */
    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    /**
     *
     * @param yCor - the y coordinate for the unit
     * modifies the current unit's yCor to the passed value
     */
    public void setyCor(int yCor) {
        this.yCor = yCor;
    }

    /**
     *
     * @param movement - an int to represent the movement of the piece
     * modifies the current unit's movement to the passed value
     */
    public void setMovement(int movement) {
        this.movement = movement;
    }

    /**
     *
     * @param movementModifier - an int to represent the movement modifier
     * modifies the current unit's movementModifier to the passed value
     */
    public void setMovementModifier(int movementModifier) {
        this.movementModifier = movementModifier;
    }

    /**
     *
     * @param teamColor - a string to represent the team's color
     * modifies the current unit's teamColor to the passed value
     */
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    /**
     *
     * @return a string representation of the class
     * the string is the color followed by the symbol, with a singular space as a separator
     */
    @Override
    public String toString() {
        return this.teamColor + " " + this.symbol;
    }


    abstract public Unit spawn(); // a spawn method to be implemented in subclasses

    abstract public boolean canSpawn(); // method representing if a unit can spawn

    /**
     *
     * @param fromRow - the row the unit is moving from
     * @param fromColumn - the column the unit is moving from
     * @param toRow - the row the unit is moving to
     * @param toColumn - the column the unit is moving to
     * @return true if the move path is valid
     */
    public boolean validMovePath(int fromRow, int fromColumn, int toRow, int toColumn) {
        return true;
    }

    /**
     *
     * @param fromRow - the row the unit is from
     * @param fromColumn - the column the unit is from
     * @param toRow - the row the unit is spawning to
     * @param toColumn - the column the unit is spawning to
     * @return true if the spawn path is valid
     */
    public boolean validSpawnPath(int fromRow, int fromColumn, int toRow, int toColumn) {
        return true;
    }
}
