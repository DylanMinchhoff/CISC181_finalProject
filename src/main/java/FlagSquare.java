/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * represents a flagSquare in which the players will need to "capture" in order to gain points
 */
public class FlagSquare extends BoardSquare{
    private boolean contested;
    private Team majorityTeam;
    private String flagString;
    private int xCor;
    private int yCor;

    /**
     *
     * @param xCor - the xCor (Column) of the square
     * @param yCor - the yCor (Row) of the Square
     *
     * Creates a FlagSquare on the board
     */
    public FlagSquare(int xCor, int yCor) {
        super("Flag", false, false);
        this.xCor = xCor;
        this.yCor = yCor;
        this.contested = false;
        this.majorityTeam = null;
        createFlagString();
    }

    /**
     *
     * @return - the x or column of the flag
     */
    public int getXCor() {
        return this.xCor;
    }

    /**
     *
     * @return - the y cor or row of the flag
     */
    public int getYCor() {
        return this.yCor;
    }

    /**
     *
     * @return - true if a majority team has captured the flag
     */
    public boolean isContested() {
        return this.contested;
    }

    /**
     *
     * @return - the team with the majority units around the flag
     */
    public Team getMajorityTeam() {
        return majorityTeam;
    }

    /**
     *
     * @param majorityTeam - the team with the majority units around the flag
     * modifies the current majorityTeam to the value passed
     * sets the flagSquare to contested or not
     * modifies the flagString to represent the current contestation
     */
    public void setMajorityTeam(Team majorityTeam) {
        this.contested = (majorityTeam != null);
        this.majorityTeam = majorityTeam;
        createFlagString();
    }

    /**
     * sets the current flagString to represent the current contestation
     */
    private void createFlagString() {
        if (majorityTeam != null) {
            this.flagString = "%&" + majorityTeam.getTeamColor() + "&%";
        }
        else {
            this.flagString = "%&---&%";
        }
    }

    /**
     *
     * @return - the string representation of the current flag
     */
    @Override
    public String toString() {
        return this.flagString;
    }
}
