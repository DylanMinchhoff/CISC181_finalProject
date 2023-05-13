/**
 * @author dylan minchhoff
 * @version 2.1.0
 *
 * the class creates a Bart Simpson Unit piece
 */
public class BartSimpsonUnit extends Recruiter{
    private int numTimesSpawned;
    private boolean distract;
    private boolean recruit;

    private final int MAX_NUM_SPAWNED = 2;

    // initializes the member fields of this class by calling this unit's super class (Unit)
    // sets the passed parameters to their respective member fields
    public BartSimpsonUnit (char symbol,
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
                         int numTimesSpawned,
                         boolean distract,
                         boolean recruit,
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
        // a new unit hasn't recruited yet, hence numRecruits = 0
        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        this.recruit = recruit;
    }

    // constructor for no passed parameters
    // creates an instance of this class by calling this class's constructor with 'base' values
    public BartSimpsonUnit() {
        this('B',
                "Bart Simpson",
                100.0,
                0.0,
                25.0,
                0.0,
                0,
                5,
                5,
                1,
                0,
                0,
                true,
                true, "red");
    }

    /**
     * @return a boolean representing if the piece is distracted
     */
    public boolean isDistract() {
        return this.distract;
    }

    /**
     * @return a boolean representing if the piece can recruit
     */
    public boolean canRecruit() {
        return this.recruit;
    }

    /**
     * @return a boolean representing if the piece can spawn
     */
    public boolean canSpawn () {
        return this.numTimesSpawned < this.MAX_NUM_SPAWNED && Character.isUpperCase(this.symbol);
    }


    /**
     *
     * @return - an int representing the number of times this unit has spawned
     */
    public int getNumTimesSpawned() {
        return this.numTimesSpawned;
    }

    /**
     *
     * @param numTimesSpawned - an int to represent the number of times this unit has spawned
     * modifies the current unit's number of times spawned to the passed value
     */
    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    /**
     *
     * @param distract - a boolean representing if Bart is distracted
     * modifies the current unit's distract to the passed value
     */
    public void setDistract(boolean distract) {
        this.distract = distract;
    }

    /**
     *
     * @param recruit - a boolean representing if the current Bart Unit can recruit
     * modifies the current unit's recruit member to the passed value
     */
    public void setRecruit(boolean recruit) {
        this.recruit = recruit;
    }

    /**
     * displays a message if the current unit is distracted
     */
    public void distracted() {
        if (this.distract) {
            System.out.println("Unit Distracted!");
        }
    }

    /**
     *
     * @return a new BartSimpsonUnit with base stats, and a lower case b to represent non-originality
     * increments the numTimesSpawned for the current piece
     */
    public BartSimpsonUnit spawn() {
        BartSimpsonUnit newUnit = new BartSimpsonUnit('b',
                "Bart Simpson",
                100.0,
                5.0,
                25.0,
                10.0,
                0,
                1,
                1,
                1,
                1,
                0,
                true,
                true,
                "red");

        // updating the number of time this piece has spawned
        this.numTimesSpawned++;
        return newUnit;
    }

}
