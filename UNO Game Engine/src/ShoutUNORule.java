public class ShoutUNORule implements Requirement{

    public ShoutUNORule(){
    }
    public boolean checkRequirement(TurnManager turnManager) {
        Player currentPlayer = turnManager.currentPlayer();
        Hand currentHand = currentPlayer.getHand();
        return currentHand.getCards().size() == 1;
    }
}
