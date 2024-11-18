public class SameActionRule implements ValidationRule{
    @Override
    public boolean testRule(Card card, Card lastPlayed) {

        if(card instanceof ExecutableCard &&
                lastPlayed instanceof ExecutableCard){
            return card.getClass().getName() ==
                    lastPlayed.getClass().getName();
        }
        return false;
    }
}
