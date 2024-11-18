import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Executor {

    private Map<String, CardAction> cardActionMap = new HashMap<>();

    public void addCardAction(String cardName, CardAction cardAction){
        cardActionMap.put(cardName, cardAction);
    }
    public void execute(Card card){
        if(!(card instanceof ExecutableCard)){
            return;
        }
        CardAction cardAction = cardActionMap.get(card.getName());
        cardAction.action();
    }
}

