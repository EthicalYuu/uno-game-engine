import java.util.Scanner;
public class Wild extends Card implements WildCard, ExecutableCard {
    private final int VALUE = 50;
    private final String NAME = "Wild";
    private DiscardPile discardPile;

    Scanner scanner = new Scanner(System.in);
    public Wild(DiscardPile discardPile){
        this.discardPile = discardPile;
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
