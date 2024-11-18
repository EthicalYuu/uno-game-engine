public class WildCardRule implements ValidationRule{
    public WildCardRule() {
    }
    public boolean testRule(Card card, Card lastPlayed) {
        return card instanceof WildCard;
    }
}
