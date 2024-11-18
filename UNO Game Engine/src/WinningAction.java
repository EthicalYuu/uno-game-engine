public class WinningAction implements Action{

    private Game game;
    private LeaderBoard leaderBoard;
    public WinningAction(Game game, LeaderBoard leaderBoard) {
        this.game = game;
        this.leaderBoard = leaderBoard;
    }


    @Override
    public void performAction(TurnManager turnManager) {
        System.out.println(leaderBoard.toString());
        game.reset();
        game.play();
    }
}

