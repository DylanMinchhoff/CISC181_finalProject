/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 */
public class FlagSquare extends BoardSquare{
    private boolean contested;
    private Team majorityTeam;
    private String flagString;
    private int xCor;
    private int yCor;

    public FlagSquare(int xCor, int yCor) {
        super("Flag", false, false);
        this.xCor = xCor;
        this.yCor = yCor;
        this.contested = false;
        this.majorityTeam = null;
        createFlagString();
    }

    public int getXCor() {
        return this.xCor;
    }

    public int getYCor() {
        return this.yCor;
    }

    public boolean isContested() {
        return this.contested;
    }

    public Team getMajorityTeam() {
        return majorityTeam;
    }

    public void setContested(boolean contested) {
        createFlagString();
        this.contested = contested;
    }

    public void setMajorityTeam(Team majorityTeam) {
        this.majorityTeam = majorityTeam;
    }

    private void createFlagString() {
        if (majorityTeam != null) {
            this.flagString = "%&" + majorityTeam.getTeamColor() + "&%";
        }
        else {
            this.flagString = "%&---&%";
        }
    }

    @Override
    public String toString() {
        return this.flagString;
    }
}
