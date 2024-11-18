import java.util.Scanner;
public class NoValidCardAction implements Action{

    Scanner scanner = new Scanner(System.in);

    public NoValidCardAction(){

    }
    @Override
    public void performAction(TurnManager turnManager) {

        Player currentPlayer = turnManager.currentPlayer();
        Hand currentHand = currentPlayer.getHand();

        String input;
        char c = 0;
        while(c != 'd'){
            System.out.print("You don't have a valid card. Press 'd' to draw a card. ");
            input = scanner.next();
            c = input.charAt(0);
        }
        currentHand.drawCard();
        System.out.println("Drawing a new card");
        CardPrinter.showCards(currentHand.getCards());
        if(!Validator.validate(currentHand.drawCard())){
            System.out.println("Invalid card drawn");
            turnManager.nextTurn();
        }
    }
}
