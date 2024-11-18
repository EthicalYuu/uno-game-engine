public class HandEmpty implements Requirement{

    public HandEmpty(){
    }
    public boolean checkRequirement(TurnManager turnManager) {
        Player currentPlayer = turnManager.currentPlayer();
        Hand currentHand = currentPlayer.getHand();
        return currentHand.getCards().isEmpty();
    }
}
