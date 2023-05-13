import java.util.ArrayList;

/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * a class representing a 'team' of units for a player
 */
public class Team {
    private String teamColor;
    private ArrayList<Unit> teamUnits;
    public Team(String teamColor, ArrayList<Unit> teamUnits){
        this.teamUnits = new ArrayList<Unit>();
        this.teamColor = teamColor;
        if(teamUnits != null) {
            this.teamUnits.addAll(teamUnits);
        }
    }

    /**
     *
     * @return - the color of this team
     */
    public String getTeamColor() {
        return this.teamColor;
    }

    /**
     *
     * @return - an ArrayList of unit's for the current team
     */
    public ArrayList<Unit> getTeamUnits() {
        return this.teamUnits;
    }

    /**
     *
     * @param unit - a unit
     * removes the given unit from the team's available units
     */
    public void removeUnitsFromTeam(Unit unit){
        this.teamUnits.remove(unit);
    }

    /**
     *
     * @param unit - a Unit
     * adds the given unit to the team's available units
     * and change's the team color of the given unit to that of the current team
     */
    public void addUnitsToTeam(Unit unit){
        unit.setTeamColor(this.teamColor);
        this.teamUnits.add(unit);
    }


    /**
     *
     * @return - a string of all the Unit's in the current team
     */
    @Override
    public String toString(){
        StringBuilder team = new StringBuilder("Team " + this.teamColor + " Units :\n");
        for (Unit unit : this.teamUnits){
            team.append(unit.toString() + "   ");
        }
        team.append("\n");
        return team.toString();
    }
}
