import java.util.ArrayList;

public class LeaderBoard {
    private static ArrayList<Player> players;

    public LeaderBoard(ArrayList<Player> players){
        this.players = players;
    }
    public void updateScore(Player player, int score){
        player.setScore(score);
    }

    public static int calculateScore(){
        int score = 0;
        for(Player player: players){
            for(Card card: player.getHand().getCards()){
                score += card.getValue();
            }
        }
        return score;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Player\tScore\n");
        for(Player player: players){
            stringBuilder.append(player.getName() + "\t" + player.getScore() + "\n");
        }
        return stringBuilder.toString();
    }
}
