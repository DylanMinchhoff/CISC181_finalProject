public class FlagCapture{
    private boolean contested;
    private Team majorityTeam;
    private String flagString;
    private Game game;
    public FlagCapture(Game game, int xCor, int yCor) {
        this.game = game;
        this.contested = false;
        this.majorityTeam = null;
        this.flagString = createFlagString();
    }

    public boolean isContested() {
        return this.contested;
    }

    public void checkContestation() {
        int currentPlayerUnits = 0, opposingPlayerUnits = 0;
        for (int i = 0; i < 3; i++){
            // checks above below and the same row
            GameBoard board = game.getGameBoard();


        }
        if (currentPlayerUnits > opposingPlayerUnits) {
            this.contested = true;
            this.majorityTeam = game.getCurrentPlayer().getPlayersTeam();
        }
        if (opposingPlayerUnits > currentPlayerUnits) {
            this.contested = true;
            this.majorityTeam = game.getOpponentPlayer().getPlayersTeam();
        }
        else {
            this.contested = false;
            this.majorityTeam = null;
        }
    }

    private String createFlagString() {
        StringBuilder flag = new StringBuilder();
        for (int i = 0; i < 7; i++) {

        }
        return flag.toString();
    }

    @Override
    public String toString() {
        return this.flagString;
    }
}
