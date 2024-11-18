public class Draw2Action implements CardAction{

    private TurnManager turnManager;
    public Draw2Action(TurnManager turnManager){
        this.turnManager = turnManager;
    }

    @Override
    public void action(){
        System.out.println("Player " + turnManager.nextPlayer().getName() + " draws 2 cards.");
        Player nextPlayer = turnManager.nextPlayer();
        nextPlayer.getHand().drawCard();
        nextPlayer.getHand().drawCard();
    }
}
