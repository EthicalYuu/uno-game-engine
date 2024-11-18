public class Player {
    private final String NAME;
    private Hand hand;
    private int score;

    public Player(String name, Hand hand){
        this.hand = hand;
        this.NAME = name;
        this.score = 0;
    }

    public String getName(){
        return NAME;
    }

    public int getScore(){
        return score;
    }

    public Hand getHand(){
        return hand;
    }

    public void setScore(int newScore){
        score = newScore;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }
}
