import java.util.Scanner;
public class WildAction implements CardAction{

    Scanner scanner = new Scanner(System.in);

    private DiscardPile discardPile;
    public WildAction(DiscardPile discardPile){
        this.discardPile = discardPile;
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

    }
}
