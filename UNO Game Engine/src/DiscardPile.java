import java.util.ArrayList;

public class DiscardPile {
    private ArrayList<Card> cards;
    private Card lastPlayed;

    public DiscardPile(){
        cards = new ArrayList<Card>();
    }

    public Card getLastPlayed(){
        return lastPlayed;
    }

    public ArrayList<Card> getCards(){
        return cards;
    }


    public void setLastPlayed(Card card){
        lastPlayed = card;
    }
    public void addCard(Card card){
        cards.add(card);
        lastPlayed = card;
    }

    public void clear(){
        cards.clear();
    }
}
