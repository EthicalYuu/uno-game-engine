import java.util.ArrayList;

public class DefaultDealer implements Dealer{

    private ArrayList<Player> players;
    private int noCards;

    public DefaultDealer(ArrayList<Player> players, int noCards){
        this.players = players;
        this.noCards = noCards;
    }

    public void deal() {
        System.out.println("------------------------------------------------");
        for(Player player: players){
            for(int i = 0; i<noCards ;i++){
                System.out.println(player.getName() + " is drawing a card");
                player.getHand().drawCard();
                Sleep.sleep(200);
            }
            System.out.println("------------------------------------------------");
        }
    }

}
