import java.util.ArrayList;

public class Validator {
    private static DiscardPile discardPile;
    private static ArrayList<ValidationRule> validationRules = new ArrayList<>();
    public Validator(DiscardPile discardPile){
        this.discardPile = discardPile;
    }
    public static boolean validate(Card card){

        Card lastPlayed = discardPile.getLastPlayed();

        for(ValidationRule validation: validationRules){
            if(validation.testRule(card, lastPlayed)){
                return true;
            }
        }

        return false;
    }

    public void addValidationRule(ValidationRule validationRule){
        validationRules.add(validationRule);
    }
}
