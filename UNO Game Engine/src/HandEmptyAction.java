public class HandEmptyAction implements Action{

    private LeaderBoard leaderBoard;
    private Game game;

    public HandEmptyAction(Game game, LeaderBoard leaderBoard){
        this.game = game;
        this.leaderBoard = leaderBoard;
    }
    @Override
    public void performAction(TurnManager turnManager) {
        int score;
        Player currentPlayer = turnManager.currentPlayer();
        score = LeaderBoard.calculateScore();
        leaderBoard.updateScore(currentPlayer, score);
        System.out.println(currentPlayer.getName() + " wins with a score of " + score);
        Sleep.sleep(1000);
        game.reset();
        game.play();
    }
}
