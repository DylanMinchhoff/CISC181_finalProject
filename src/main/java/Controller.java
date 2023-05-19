import java.util.ArrayList;

/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 */
public class Controller {
    private Game game;
    private TextView textView;
    private GameEventsLinkedList gameEvents;
    // sets up a game
    public Game setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();


        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");


        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");

        Archer archer1 = new Archer(3, 3,"Blu");
        Archer archer2 = new Archer(3, 3,"Red");


        piecesTeamA.add(bs);
        piecesTeamA.add(tj);
        piecesTeamA.add(archer1);


        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);
        Player playerOne = new Player(1, true, teamA);


        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();


        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");


        TomJerryUnit tj2 = new TomJerryUnit();
        tj2.setTeamColor("Red");


        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);
        piecesTeamB.add(archer2);


        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);


        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    // initializes a controller class
    public Controller() {
        this.game = setUpGameModel();
        this.textView = new TextView();
        this.gameEvents = new GameEventsLinkedList();
        textView.updateView(game);
    }

    /**
     *
     * @param fromRow - the row the action is being made from
     * @param fromColumn - the column the action is being made from
     * @param toRow - the row the action is being made to
     * @param toColumn - the column the action is being made to
     * @param actionType - the action type
     */
    public void carryOutAction(int fromRow, int fromColumn, int toRow, int toColumn, char actionType) {
        actionType = Character.toUpperCase(actionType);
        Action action = null;
        if (actionType == 'M') action = new ActionMove(game, fromRow, fromColumn, toRow, toColumn);
        if (actionType == 'S') action = new ActionSpawn(game, fromRow, fromColumn, toRow, toColumn);
        if (actionType == 'R') action = new ActionRecruit(game, fromRow, fromColumn, toRow, toColumn);
        if (actionType == 'A') action = new ActionAttack(game, fromRow, fromColumn, toRow, toColumn);

        // if the action is not defined as one of the set actions above
        if (action != null) {
            // add actions here
            gameEvents.push(new GameEventNode(new GameEvent(game.getCurrentPlayer().getPlayerNumber(),
                    Character.toString(actionType),
                    action.toString())));
            action.preformAction();
        }
    }

    /**
     * runs indefinitely until the games has ended
     * gets the player's action
     * checks to see if action is valid
     *
     */
    public void playGame() {
        while (!game.isGameEnded()) {
            textView.getNextPlayersAction(game);

            // if the action is valid the action is carried out
            if (Rules.checkValidAction(game,
                    textView.getFromRow(),
                    textView.getFromColumn(),
                    textView.getToRow(),
                    textView.getToColumn(),
                    textView.getActionType())) {

                carryOutAction(textView.getFromRow(),
                        textView.getFromColumn(),
                        textView.getToRow(),
                        textView.getToColumn(),
                        textView.getActionType());
            }
            // checking if the flag "belongs" to a certain player
            game.checkContestation();
            textView.updateView(game);
        }
        textView.printWinningMove(gameEvents);
        textView.printEndOfGameMessage(game);
    }

    // creates the game
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }

}
