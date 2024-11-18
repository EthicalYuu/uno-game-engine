import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private Deck deck;
    private DiscardPile discardPile;

    public Hand(Deck deck, DiscardPile discardPile){
        cards = new ArrayList<Card>();
        this.deck = deck;
        this.discardPile = discardPile;
    }

    public Card getCard(int index){
        try{
            return cards.get(index);
        } catch (IndexOutOfBoundsException e){
            System.out.println("No such card - choose another");
            return null;
        }
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public Card getLastDraw(){
        return cards.get(cards.size());
    }

    public Card drawCard(){
        Card drawnCard = deck.draw();
        cards.add(drawnCard);
        return drawnCard;
    }

    public boolean isEmpty(){
        return this.getCards().size() == 0;
    }

    public void playCard(int cardIndex) {
        Card playCard = cards.get(cardIndex);
        discardPile.addCard(playCard);
        cards.remove(playCard);
    }

}
