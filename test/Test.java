import ca.sheridancollege.project.WarGame;
import ca.sheridancollege.project.Player;
import ca.sheridancollege.project.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains test methods to validate the functionality of the WarGame class.
 * Also includes a helper class to simulate a player with a predetermined hand.
 * 
 * @author Muhammad Aiz Baloch
 */

public class Test {

    // ANSI color codes for console output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        testWarGameBasic();
        testWarGameEmptyDeck();
        testWarGameEqualRanks();
    }

    private static void testWarGameBasic() {
        System.out.println(ANSI_GREEN + "=== Testing WarGame (Basic) ===" + ANSI_RESET);
        WarGame warGame = new WarGame();
        warGame.play();
    }

    private static void testWarGameEmptyDeck() {
        System.out.println(ANSI_GREEN + "=== Testing WarGame (Empty Deck) ===" + ANSI_RESET);
        WarGame warGame = new WarGame();
        // remove all cards from the deck to simulate an empty deck
        warGame.getDeck().clear();
        warGame.play();
    }

    private static void testWarGameEqualRanks() {
        System.out.println(ANSI_GREEN + "=== Testing WarGame (Equal Ranks) ===" + ANSI_RESET);
        WarGame warGame = new WarGame();
        // set up players with equal ranks
        Player player1 = new TestPlayer("Player 1", "Ace");
        Player player2 = new TestPlayer("Player 2", "Ace");
        warGame.setPlayers(new ArrayList<>(Arrays.asList(player1, player2)));
        warGame.play();
    }

    // helper class to simulate a player with a predetermined hand
    private static class TestPlayer extends Player {
        private String rank;

        public TestPlayer(String name, String rank) {
            super(name);
            this.rank = rank;
        }

        @Override
        public void play() {
            // not used in this test
        }

        @Override
        public List<Card> getHand() {
            List<Card> hand = new ArrayList<>();
            hand.add(new Card(rank, "Hearts"));
            hand.add(new Card(rank, "Diamonds"));
            hand.add(new Card(rank, "Clubs"));
            hand.add(new Card(rank, "Spades"));
            return hand;
        }
    }
}
