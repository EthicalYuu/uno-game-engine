import java.util.Scanner;

public class DrawFourAction implements CardAction{
    private DiscardPile discardPile;
    private TurnManager turnManager;
    Scanner scanner = new Scanner(System.in);
    public DrawFourAction(DiscardPile discardPile, TurnManager turnManager){
        this.discardPile = discardPile;
        this.turnManager = turnManager;
    }

    @Override
    public void action() {
        String input;
        Card fakeCard = null;
        char c = 0;

        while(c != 'r' && c != 'g' && c != 'b' && c != 'y'){
            System.out.print("Select a color <r/g/b/y> ");
            input = scanner.next();
            c = input.charAt(0);
        }
        if(c == 'r'){
            fakeCard = new FakeCard(Color.RED);
        } else if (c == 'g'){
            fakeCard = new FakeCard(Color.GREEN);
        } else if(c == 'b'){
            fakeCard = new FakeCard(Color.BLUE);
        } else if (c == 'y'){
            fakeCard = new FakeCard(Color.YELLOW);
        }

        discardPile.addCard(fakeCard);

        System.out.println("Player " + turnManager.nextPlayer().getName() + " draws 4 cards.");
        Player nextPlayer = turnManager.nextPlayer();
        nextPlayer.getHand().drawCard();
        nextPlayer.getHand().drawCard();
        nextPlayer.getHand().drawCard();
        nextPlayer.getHand().drawCard();
    }
}
