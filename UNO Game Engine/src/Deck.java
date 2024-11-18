import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;;

    public Deck(){
        cards = new ArrayList<Card>();
    }

    public void addCard(Card card){
        cards.add(card);
    }
    // Deal with not having cards in the deck

    public Card draw(){
        Card drawCard = cards.remove(cards.size()-1);
        return drawCard;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public void clear(){
        cards.clear();
    }

}
