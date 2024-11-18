public class SameColorRule implements ValidationRule{
    public boolean testRule(Card card, Card lastPlayed) {

        if (!(card instanceof ColoredCard) ||
                !(lastPlayed instanceof ColoredCard)) return false;

        ColoredCard numCard1 = (ColoredCard) card;
        ColoredCard numCard2 = (ColoredCard) lastPlayed;

        return numCard1.getColor().equals(numCard2.getColor());
    }
}
