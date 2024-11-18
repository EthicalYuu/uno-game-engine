import java.util.Scanner;
public class WildDrawFour extends Card implements WildCard, ExecutableCard {
    private final int VALUE = 50;
    private final String NAME = "WildDrawFour";
    private DiscardPile discardPile;
    private TurnManager turnManager;

    Scanner scanner = new Scanner(System.in);
    public WildDrawFour(DiscardPile discardPile, TurnManager turnManager){
        this.discardPile = discardPile;
        this.turnManager = turnManager;
    }

    @Override
    public int getValue() {
        return VALUE;
    }

    @Override
    public String getName() {
        return NAME;
    }

}

