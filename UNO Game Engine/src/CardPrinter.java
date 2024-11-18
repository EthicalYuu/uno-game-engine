import java.util.ArrayList;

public abstract class CardPrinter {

    public static void showCards(Card card){
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card);
        showCards(cards);
    }
    public static void showCards(ArrayList<Card> cards){
        System.out.print("{ ");
        for(int i = 0; i < cards.size(); i++){
            Card card = (cards.get(i));
            if(card instanceof NumberedCard){
                NumberedCard numberedCard = (NumberedCard)card;
                System.out.print(numberedCard.getColor() + "_" + numberedCard.getNumber() + "["+ i + "]");
            } else if(card instanceof Skip){
                Skip skip = (Skip)card;
                System.out.print(skip.getColor() + "_SKIP" + "["+ i + "]");
            } else if(card instanceof Reverse){
                Reverse reverse = (Reverse) card;
                System.out.print(reverse.getColor() + "_REVERSE" + "["+ i + "]");
            } else if(card instanceof Draw2){
                Draw2 draw2 = (Draw2) card;
                System.out.print(draw2.getColor() + "_DRAW2" + "["+ i + "]");
            } else if(card instanceof Wild){
                Wild wild = (Wild) card;
                System.out.print("WILD" + "["+ i + "]");
            } else if(card instanceof FakeCard){
                FakeCard fakeCard = (FakeCard) card;
                System.out.print(fakeCard.getColor() + "["+ i + "]");
            } else if(card instanceof WildDrawFour){
                WildDrawFour wildDrawFour = (WildDrawFour) card;
                System.out.print("WildDrawFour" + "["+ i + "]");
            }


            if(i != cards.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
