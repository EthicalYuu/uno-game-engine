public class DeckFactory {
    private Deck deck;
    private TurnManager turnManager;
    private DiscardPile discardPile;
    public DeckFactory(Deck deck, TurnManager turnManager, DiscardPile discardPile){
        this.deck = deck;
        this.turnManager = turnManager;
        this.discardPile = discardPile;
    }

    // The DeckFactory Class
    public void populate(){

        // Adds numbered cards from 0-9 <first batch> to the deck
        for(Color color: Color.values()){
            for(Number number: Number.values()){
                deck.addCard(new NumberedCard(color, number));
            }
        }

        // Adds numbered cards from 1-9 <second batch> to the deck
        for(Color color: Color.values()){
            for(Number number: Number.values()){
                if(number.getNum() == 0){
                    continue;
                }
                deck.addCard(new NumberedCard(color, number));
            }
        }

        // Adds action cards (Reverse, Skip, Draw Two) to the deck
        // We have two cards of each type for each color
        for(Color color: Color.values()){
            deck.addCard(new Reverse(color));
            deck.addCard(new Reverse(color));
            deck.addCard(new Skip(color));
            deck.addCard(new Skip(color));
            deck.addCard(new Draw2(color));
            deck.addCard(new Draw2(color));
        }

        for(int i = 0; i<4 ;i++){
            deck.addCard(new Wild(discardPile));
            deck.addCard(new WildDrawFour(discardPile, turnManager));
        }

        deck.shuffle();
    }

}
