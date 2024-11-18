import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Player currentPlayer;
    private Hand currentHand;
    private ArrayList<Card> cards;
    private Card lastPlayed;
    private DiscardPile discardPile;
    private TurnManager turnManager;
    private DeckFactory deckFactory;
    private LeaderBoard leaderBoard;

    private Dealer dealer;

    private Referee referee;
    private Executor executor;

    private Validator validator;
    Scanner scanner = new Scanner(System.in);

    public Dealer getDealer(){
        return dealer;
    }
    public Referee getReferee(){
        return referee;
    }

    public Executor getExecutor(){
        return executor;
    }

    public LeaderBoard getLeaderBoard(){
        return leaderBoard;
    }

    public TurnManager getTurnManager(){
        return turnManager;
    }

    public DiscardPile getDiscardPile(){
        return discardPile;
    }



    public Game(){
        deck = new Deck();
        discardPile = new DiscardPile();
        players = createPlayers(deck, discardPile);
        turnManager = new TurnManager(players);
        deckFactory = new DeckFactory(deck, turnManager, discardPile);
        deckFactory.populate();
        discardPile.addCard(deck.draw());
        leaderBoard = new LeaderBoard(players);
        validator = new Validator(discardPile);
        referee = new Referee(turnManager);
        executor = new Executor();
    }

    public void reset(){
        deck = new Deck();
        discardPile = new DiscardPile();
        turnManager = new TurnManager(players);
        deckFactory = new DeckFactory(deck, turnManager, discardPile);
        deckFactory.populate();
        discardPile.addCard(deck.draw());
        leaderBoard = new LeaderBoard(players);
    }
    public final ArrayList<Player> createPlayers(Deck deck, DiscardPile discardPile){
        String name;
        int noPlayers = 0;

        while (true) {
            System.out.print("Enter number of players: ");
            if (scanner.hasNextInt()) {
                noPlayers = scanner.nextInt();
                scanner.nextLine();
                if (noPlayers >= 2 && noPlayers <= 10) {
                    break;
                } else {
                    System.out.println("Number of players must be between 2 and 10.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.nextLine();
            }
        }

        ArrayList<Player> players = new ArrayList<>();

        for(int i = 0; i<noPlayers ;i++){
            System.out.printf("Enter player %d name: ", i+1);
            name = scanner.nextLine();
            players.add(new Player(name , new Hand(deck, discardPile)));
        }

        return players;
    }


    public void setDealer() {
        dealer = createDealer();
        dealer.deal();
    }

    public Dealer createDealer() {
        return new DefaultDealer(players, 7);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void addValidationRules(){
        validator.addValidationRule(new WildCardRule());
        validator.addValidationRule(new SameNumberRule());
        validator.addValidationRule(new SameColorRule());
        validator.addValidationRule(new SameActionRule());
    }
    // Game Class
    protected void prePlayHandRules(){

    }

    protected void postPlayHandRules(){
        referee.addAfterRule(new ShoutUNORule(), new ShoutUNOAction());
        referee.addAfterRule(new HandEmpty(), new HandEmptyAction(this, leaderBoard));
        referee.addAfterRule(new WinningRule(), new WinningAction(this, leaderBoard));
    }
    public final void getPlayerCards(){
        currentPlayer = turnManager.currentPlayer();
        currentHand = currentPlayer.getHand();
        cards = currentHand.getCards();
        lastPlayed = discardPile.getLastPlayed();
    }

    // Game Class
    public void assignCardToAction(){
        executor.addCardAction("Draw2", new Draw2Action(turnManager));
        executor.addCardAction("Reverse", new ReverseAction(turnManager));
        executor.addCardAction("Skip", new SkipAction(turnManager));
        executor.addCardAction("Wild", new WildAction(discardPile));
        executor.addCardAction("WildDrawFour", new DrawFourAction(discardPile, turnManager));
    }
    public final void chooseCard(){
        int chosenIndex = scanner.nextInt();
        Card chosenCard = currentHand.getCard(chosenIndex);

        while(!validator.validate(chosenCard)){
            System.out.println("Invalid card - renter a card");
            chosenIndex = scanner.nextInt();
            chosenCard = currentHand.getCard(chosenIndex);
        }
        currentHand.playCard(chosenIndex);
        executor.execute(chosenCard);
    }

    public void addCards(){

    }

    public final void play() {

            addCards();
            assignCardToAction();
            addValidationRules();
            prePlayHandRules();
            postPlayHandRules();
            setDealer();

        while(true){
            System.out.println("------------------------------------------------");

            getPlayerCards();

            System.out.println("\uD83C\uDCA1 Discard Pile");

            CardPrinter.showCards(lastPlayed);

            System.out.println("\u001B[4m" + currentPlayer.getName() + "'s Turn" + "\u001B[0m");
            System.out.println("✋ hand before");

            CardPrinter.showCards(cards);

            referee.testBeforePlaying();

            if(referee.hasValidCard(validator)){
                chooseCard();
            }

            referee.testAfterPlaying();

            Sleep.sleep(500);
            System.out.println("✋ hand after");
            CardPrinter.showCards(cards);

            turnManager.nextTurn();
            Sleep.sleep(500);
            System.out.println("------------------------------------------------");

        }

    }
}
