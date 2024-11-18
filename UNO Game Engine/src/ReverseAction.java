public class ReverseAction implements CardAction{

    private TurnManager turnManager;
    public ReverseAction(TurnManager turnManager){
        this.turnManager = turnManager;
    }

    @Override
    public void action() {
        turnManager.reverseDirection();
    }
}
