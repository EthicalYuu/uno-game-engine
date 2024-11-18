import java.util.Scanner;

public class NoValidCard implements Requirement{

    private Validator validator;
    private TurnManager turnManager;

    Scanner scanner = new Scanner(System.in);
    public NoValidCard(Validator validator){
        this.validator = validator;
    }
    @Override
    public boolean checkRequirement(TurnManager turnManager) {
        String input;
        char c = 0;


        Player currentPlayer = turnManager.currentPlayer();
        Hand currentHand = currentPlayer.getHand();

        for(Card card: currentHand.getCards()){
            if(validator.validate(card)){
                return false;
            }
        }

        while(c != 'd'){
            System.out.print("No valid card - press <d> to draw a card");
            input = scanner.next();
            c = input.charAt(0);
            if(c == 'd'){
                break;
            }
        }

        return true;
    }

}
