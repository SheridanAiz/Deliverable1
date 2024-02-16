package ca.sheridancollege.project;

/**
 * A concrete implementation of the Game class representing the game of War.
 * This class provides the specific logic for playing the game of War.
 * 
* @author Muhammad Aiz Baloch
 */
public class WarGame extends Game {

    private static final int INITIAL_HAND_SIZE = 26;

    public WarGame() {
        super("War"); // set the name of the game
    }

    @Override
    public void play() {
        // create two human players
        Player player1 = new HumanPlayer("Player 1");
        Player player2 = new HumanPlayer("Player 2");

        // deal cards to players
        dealCards(player1);
        dealCards(player2);

        // main game loop
        while (!player1.getHand().isEmpty() && !player2.getHand().isEmpty()) {
            // perform a round of the game
            performRound(player1, player2);
        }

        // Determine the winner
        if (player1.getHand().isEmpty()) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println(player1.getName() + " wins!");
        }
    }

    @Override
    public void declareWinner() {
        // this method is not used in this implementation
    }

    // method to deal cards to a player
    private void dealCards(Player player) {
        for (int i = 0; i < INITIAL_HAND_SIZE; i++) {
            if (!getDeck().isEmpty()) {
                player.addToHand(getDeck().remove(0)); // Remove the first card from the deck and add it to the player's hand
            } else {
                // handle the case where the deck becomes empty during dealing
                System.out.println("Deck is empty. Unable to deal more cards.");
                return;
            }
        }
    }

    // method to perform a round of the game
    private void performRound(Player player1, Player player2) {
        // simulate a round of War (compare top cards of each player's hand)
        Card card1 = player1.getHand().get(0);
        Card card2 = player2.getHand().get(0);

        System.out.println(player1.getName() + " plays: " + card1);
        System.out.println(player2.getName() + " plays: " + card2);

        // compare ranks of the cards
        int comparison = compareRanks(card1, card2);

        if (comparison > 0) {
            // player 1 wins the round
            player1.addToHand(player2.getHand().remove(0)); // Move player 2's card to player 1's hand
            System.out.println(player1.getName() + " wins the round!");
        } else if (comparison < 0) {
            // player 2 wins the round
            player2.addToHand(player1.getHand().remove(0)); // Move player 1's card to player 2's hand
            System.out.println(player2.getName() + " wins the round!");
        } else {
            // War: cards are of equal rank
            System.out.println("War!");
            // remove cards from players' hands for the war (not implemented in this basic example)
            player1.getHand().remove(0);
            player2.getHand().remove(0);
        }
    }

    // method to compare ranks of two cards
    private int compareRanks(Card card1, Card card2) {
        // convert rank strings to integers for comparison
        int rank1 = getRankValue(card1.getRank());
        int rank2 = getRankValue(card2.getRank());
        return Integer.compare(rank1, rank2);
    }

    // helper method to convert rank strings to integers for comparison
    private int getRankValue(String rank) {
        switch (rank) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            case "Ace":
                return 14;
            default:
                return 0; // Invalid rank
        }
    }

    // concrete subclass of Player representing a human player
    private static class HumanPlayer extends Player {
        public HumanPlayer(String name) {
            super(name);
        }

        @Override
        public void play() {
            // this method is not used in this implementation
        }
    }

    public static void main(String[] args) {
        // create a new instance of the WarGame class and start the game
        WarGame warGame = new WarGame();
        warGame.play();
    }
}
