public interface ValidationRule {
    boolean testRule(Card card, Card lastPlayed);
}
