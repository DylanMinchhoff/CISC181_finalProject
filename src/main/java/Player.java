import java.util.ArrayList;

/**
 * @author Dylan Minchhoff
 * @version 2.0.0
 *
 * the player class represents the
 */
public class Player {
    private int playerNumber;
    private boolean turn;
    private Team team;

    /**
     *
     * @param playerNumber - an int to represent the player's number
     * @param turn - a boolean to represent if it is this player's turn
     * @param team - a team object representing the player's 'pieces' or 'team'
     *
     * three parameter constructor setting the playerNumber, turn, and team to the passed values
     */
    public Player(int playerNumber, boolean turn, Team team) {
        this.playerNumber = playerNumber;
        this.turn = turn;
        this.team = team;
    }

    /**
     *
     * @param playerNumber - an int representing the player's number
     * @param team - a team object representing the player's 'pieces' or 'team'
     * two parameter constructor, setting the player's number and the team as the parameter's passed
     * and the turn to false
     */
    public Player(int playerNumber, Team team) {
        this(playerNumber, false, team);
    }

    /**
     *
     * zero parameter constructor, for creating a Player object
     * this initializes the playerNum as 1, the turn false, and an empty new team
     */
    public Player() {
        this(1, false, new Team("Blue", new ArrayList<Unit>()));
    }

    /**
     *
     * @return an int representing the number of this player
     */
    public int getPlayerNumber() {
        return this.playerNumber;
    }

    /**
     *
     * @return a boolean if it is the players turn or not
     */
    public boolean isTurn() {
        return this.turn;
    }

    /**
     *
     * @return - the current team of this player
     */
    public Team getPlayersTeam() {
        return this.team;
    }

    /**
     *
     * @param playerNumber - an int to represent a player
     * sets this player's number to the passed player number
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     *
     * @param turn - a boolean representing if it is this player's turn
     * sets this player's turn to the passed value
     */
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    /**
     *
     * @param team - a Team
     * modifies the current Player's team to equal the team passed in
     */
    public void setPlayersTeam(Team team) {
        this.team = team;
    }
}
