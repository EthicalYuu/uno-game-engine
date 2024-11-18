public class SkipAction implements CardAction{
    private TurnManager turnManager;
    public SkipAction(TurnManager turnManager){
        this.turnManager = turnManager;
    }
    @Override
    public void action(){
        System.out.println("Skipped player " + turnManager.nextPlayer().getName());
        turnManager.skipTurn();
    }
}
