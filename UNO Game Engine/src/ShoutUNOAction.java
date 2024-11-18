import java.util.Scanner;

public class ShoutUNOAction implements Action{

    private Hand hand;
    private int noCards;
    Scanner scanner = new Scanner(System.in);

    public ShoutUNOAction(){
        this.noCards = 2;
    }
    @Override
    public void performAction(TurnManager turnManager) {

        Player currentPlayer = turnManager.currentPlayer();
        Hand currentHand = currentPlayer.getHand();

        String input;
        char c = 0;
        while(c != 'y' && c != 'n'){
            System.out.print("Seems like you have 1 card left. Would you like to shout UNO? <y/n> ");
            input = scanner.next();
            c = input.charAt(0);
        }
        if(c == 'y'){
            System.out.println("UNO!!!");
        } else if (c == 'n'){
            System.out.printf("%d cards penalty.\n", noCards);
            for(int i = 0; i<noCards ;i++){
                currentHand.drawCard();
            }
        }
    }
}
