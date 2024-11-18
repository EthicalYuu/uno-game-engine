public class SameNumberRule implements ValidationRule{
//    private Card card;
//    private Card lastPlayed;
//
//    public SameNumberRule(Card card, Card lastPlayed){
//        this.card = card;
//        this.lastPlayed = lastPlayed;
//    }
    public boolean testRule(Card card, Card lastPlayed) {
        if(!(card instanceof NumberedCard) ||
                !(lastPlayed instanceof NumberedCard)) return false;

        NumberedCard numCard1 = (NumberedCard)card;
        NumberedCard numCard2 = (NumberedCard)lastPlayed;
        if(numCard1.isSameNumber(numCard2)){
            return true;
        }
        return false;
    }
}
