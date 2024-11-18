import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Referee {
    private String input;
    private char c;
    private Map<Requirement, Action> prePlayingRules = new HashMap<>();
    private Map<Requirement, Action> postPlayingRules = new HashMap< >();
    private TurnManager turnManager;
    public Referee(TurnManager turnManager){
        this.turnManager = turnManager;
    }

    Scanner scanner = new Scanner(System.in);

    public void testBeforePlaying(){

        for(Map.Entry<Requirement, Action> entry: prePlayingRules.entrySet()){
            Requirement requirement = entry.getKey();
            Action action = entry.getValue();

            if(requirement.checkRequirement(turnManager)){
                action.performAction(turnManager);
            }
        }
    }

    public void testAfterPlaying(){

        for(Map.Entry<Requirement, Action> entry: postPlayingRules.entrySet()){
            Requirement requirement = entry.getKey();
            Action action = entry.getValue();

            if(requirement.checkRequirement(turnManager)){
                action.performAction(turnManager);
            }
        }
    }

    public void addBeforeRule(Requirement requirement, Action action){
        prePlayingRules.put(requirement, action);
    }

    public void addAfterRule(Requirement requirement, Action action){
        postPlayingRules.put(requirement, action);
    }

    public boolean hasValidCard (Validator validator) {


            Player currentPlayer = turnManager.currentPlayer();
            Hand currentHand = currentPlayer.getHand();

            for (Card card : currentHand.getCards()) {
                if (validator.validate(card)) {
                    return true;
                }
            }
            System.out.println("No valid card");
            while(c != 'd'){
                System.out.print("No valid card - press <d> to draw a card");
                input = scanner.next();
                c = input.charAt(0);
                if(c == 'd'){
                    break;
                }
            }
            Card card = turnManager.currentPlayer().getHand().drawCard();
            System.out.println("Drawing Card...");
            if(Validator.validate(card)){
                CardPrinter.showCards(currentHand.getCards());
                return true;
            } else {
                System.out.println("Not a valid card - skip player");
                return false;
            }
        }

    }

