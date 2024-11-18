public class WinningRule implements Requirement{
    @Override
    public boolean checkRequirement(TurnManager turnManager) {
        Player currentPlayer = turnManager.currentPlayer();
        return currentPlayer.getScore() >= 10;
    }
}

