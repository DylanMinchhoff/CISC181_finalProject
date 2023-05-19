import java.util.Scanner;

/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 *
 */
public class TextView {
    private int fromRow;
    private int fromColumn;
    private int toRow;
    private int toColumn;
    private char actionType;

    /**
     *
     * @return - the current row the unit is from
     */
    public int getFromRow() {
        return this.fromRow;
    }

    /**
     *
     * @return - the current column the unit is from
     */
    public int getFromColumn() {
        return this.fromColumn;
    }

    /**
     *
     * @return - the current row the unit is to act upon
     */
    public int getToRow() {
        return this.toRow;
    }

    /**
     *
     * @return - the current column the unit is to act upon
     */
    public int getToColumn() {
        return this.toColumn;
    }

    /**
     *
     * @return - the current action desired by the user
     */
    public char getActionType() {
        return this.actionType;
    }

    /**
     * @param scnr -> Instance of a Scanner object
     *
     * @return a character basing the action of a player
     */
    public static char getUsersNextActionType(Scanner scnr) {
        boolean validInput = false;
        char userInput = ' ';
        while (!validInput) {
            System.out.println("Enter a Command:\nA -> Attack\nM -> Move\nR -> Recruit\nS -> Spawn");
            userInput = Character.toUpperCase(scnr.next().charAt(0));
            if (userInput == 'A' || userInput == 'M' || userInput == 'R' || userInput == 'S'){
                validInput = true;
            }
            else{
                System.out.println("Please enter a valid command!");
            }
        }
        return userInput;
    }

    /**
     *
     * @param lowerBound the lower-bound for a range of ints that will be excepted
     * @param upperBound the upper-bound for a range of ints that will be excepted
     * @param scr an instance of a scanner object
     *
     * @return an int entered by the user between the upper and lower bounds, inclusive
     */
    public static int getValidInt(int lowerBound, int upperBound, Scanner scr) {
        boolean validInput = false;
        int userNum = lowerBound;

        // keep asking the user for a number between the bounds (inclusive)
        while (!validInput){
            System.out.println("Enter a number from " + lowerBound + " to " + upperBound);

            if (scr.hasNextInt()){
                userNum = scr.nextInt();
                if (userNum >= lowerBound && userNum <= upperBound){
                    validInput = true;
                }
            }

            else {
                System.out.println(scr.next() + " is not a number between " +
                        lowerBound +
                        " to " +
                        upperBound);
            }
        }
        return userNum;
    }

    public void getNextPlayersAction(Game game) {
        Scanner scnr = new Scanner(System.in);
        this.actionType = getUsersNextActionType(scnr);


        this.fromRow = getValidInt(0, game.getGameBoard().getNumRows(), scnr);
        this.fromColumn = getValidInt(0, game.getGameBoard().getNumColumns(), scnr);


        this.toRow = getValidInt(0, game.getGameBoard().getNumRows(), scnr);
        this.toColumn = getValidInt(0, game.getGameBoard().getNumColumns(), scnr);

    }

    /**
     *
     * @param game - the current game being played
     * outputs the view of the game
     */
    public void updateView(Game game) {
        System.out.println(game);
    }

    /**
     *
     * @param game - the current game being played
     * outputs the end of the game and who won
     */
    public void printEndOfGameMessage(Game game) {
        Player winner = game.getWinner();
        if (winner == null) System.out.println("The game has ended with a tie!");
        System.out.println("The game has ended with player " + winner.getPlayerNumber() +
                " on the " + winner.getPlayersTeam().getTeamColor() + " team winning!");
    }

    public void printWinningMove(GameEventsLinkedList gameEvents) {
        System.out.println("Winning Move: " + gameEvents.pop().getGameState().getEventDetails());
    }


}
