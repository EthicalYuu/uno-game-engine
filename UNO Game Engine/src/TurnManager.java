import java.util.ArrayList;

public class TurnManager {
    private ArrayList<Player> players;
    private boolean clockWise;
    private int turn;

    public TurnManager(ArrayList<Player> players){
        this.players = players;
        clockWise = true;
        turn = 0;
    }

    public void nextTurn(){
        if(clockWise){
            turn = (turn + 1) % players.size();
        } else {
            if(turn == 0){
                turn = players.size() - 1;
            } else {
                turn = turn - 1;
            }
        }
    }

    public Player currentPlayer(){
        return players.get(turn);
    }

    public Player nextPlayer() {
        if(clockWise){
            return players.get((turn + 1) % players.size());
        } else {
            if(turn == 0){
                return players.get(players.size()-1);
            } else {
                return players.get(turn - 1);
            }
        }
    }

    public void skipTurn(){
        nextTurn();
    }

    public void reverseDirection(){
        clockWise = !clockWise;
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public void eliminatePlayer(Player player){
        players.remove(player);
    }

}
