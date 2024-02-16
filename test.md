Card.java

package ca.sheridancollege.project;

/**
 * A class representing a playing card for the game of War.
 * Each card has a rank and a suit.
 * 
 * @author Muhammad Aiz Baloch
 */
public class Card extends Object {
    // Properties
    private String rank;
    private String suit;

    // Constructor
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getters and Setters
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    // Override toString method to provide a meaningful representation of a card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

Game.java

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The abstract class that models a generic card game.
 * Specific games should extend this class and implement the abstract methods.
 * 
* @author Muhammad Aiz Baloch
 */
public abstract class Game {

    private final String name; // The title of the game
    private ArrayList<Player> players; // The players of the game
    private ArrayList<Card> deck; // The deck of cards

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
        deck = new ArrayList<>();
        initializeDeck(); // Initialize the deck when a game object is created
    }

    /**
     * @return war
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Set the players of this game.
     * 
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Initialize the deck of cards with 52 cards.
     */
    private void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
        shuffleDeck(); // Shuffle the deck after initialization
    }

    /**
     * Shuffle the deck of cards.
     */
    protected void shuffleDeck() {
        Collections.shuffle(deck);
    }

    /**
     * @return the deck of cards
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Play the game. This method should be implemented in concrete subclasses.
     */
    public abstract void play();

    /**
     * Declare the winner of the game. This method should be implemented in concrete subclasses.
     */
    public abstract void declareWinner();
}

GroupOfCards.java

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents a group of cards for a game.
 * This class manages a group of cards and provides methods for manipulation.
 * 
* @author Muhammad Aiz Baloch
 */
public class GroupOfCards {

    // The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size; // The maximum size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>();
    }

    /**
     * Get the group of cards as an ArrayList.
     * 
     * @return the group of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Add a card to the group of cards.
     * 
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (cards.size() < size) {
            cards.add(card);
        }
    }

    /**
     * Remove a card from the group of cards.
     * 
     * @param card the card to remove
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * Shuffle the group of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Get the size of the group of cards.
     * 
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the max size for the group of cards.
     * 
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
}

Player.java

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that models each Player in the game. Players have a name and a hand of cards.
 * This class provides methods for managing the player's hand of cards and playing the game.
 * 
* @author Muhammad Aiz Baloch
 */
public abstract class Player {

    private String name; // the unique name for this player
    private List<Card> hand; // the player's hand of cards

    /**
     * A constructor that allows you to set the player's name and initialize their hand of cards.
     *
     * @param name the name to assign to this player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the player's name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the player's hand of cards
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * Set the player's hand of cards.
     *
     * @param hand the hand of cards to set
     */
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    /**
     * Add a card to the player's hand.
     *
     * @param card the card to add
     */
    public void addToHand(Card card) {
        hand.add(card);
    }

    /**
     * Remove a card from the player's hand.
     *
     * @param card the card to remove
     */
    public void removeFromHand(Card card) {
        hand.remove(card);
    }

    /**
     * The method to be overridden when subclassing the Player class with specific player types.
     * This method should define the logic for a player's turn in the game.
     */
    public abstract void play();
}

Test.java

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        // Remove all cards from the deck to simulate an empty deck
        warGame.getDeck().clear();
        warGame.play();
    }

    private static void testWarGameEqualRanks() {
        System.out.println(ANSI_GREEN + "=== Testing WarGame (Equal Ranks) ===" + ANSI_RESET);
        WarGame warGame = new WarGame();
        // Set up players with equal ranks
        Player player1 = new TestPlayer("Player 1", "Ace");
        Player player2 = new TestPlayer("Player 2", "Ace");
        warGame.setPlayers(new ArrayList<>(Arrays.asList(player1, player2)));
        warGame.play();
    }

    // Helper class to simulate a player with a predetermined hand
    private static class TestPlayer extends Player {
        private String rank;

        public TestPlayer(String name, String rank) {
            super(name);
            this.rank = rank;
        }

        @Override
        public void play() {
            // Not used in this test
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

WarGame.java

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
        super("War"); // Set the name of the game
    }

    @Override
    public void play() {
        // Create two human players
        Player player1 = new HumanPlayer("Player 1");
        Player player2 = new HumanPlayer("Player 2");

        // Deal cards to players
        dealCards(player1);
        dealCards(player2);

        // Main game loop
        while (!player1.getHand().isEmpty() && !player2.getHand().isEmpty()) {
            // Perform a round of the game
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
        // This method is not used in this implementation
    }

    // Method to deal cards to a player
    private void dealCards(Player player) {
        for (int i = 0; i < INITIAL_HAND_SIZE; i++) {
            if (!getDeck().isEmpty()) {
                player.addToHand(getDeck().remove(0)); // Remove the first card from the deck and add it to the player's hand
            } else {
                // Handle the case where the deck becomes empty during dealing
                System.out.println("Deck is empty. Unable to deal more cards.");
                return;
            }
        }
    }

    // Method to perform a round of the game
    private void performRound(Player player1, Player player2) {
        // Simulate a round of War (compare top cards of each player's hand)
        Card card1 = player1.getHand().get(0);
        Card card2 = player2.getHand().get(0);

        System.out.println(player1.getName() + " plays: " + card1);
        System.out.println(player2.getName() + " plays: " + card2);

        // Compare ranks of the cards
        int comparison = compareRanks(card1, card2);

        if (comparison > 0) {
            // Player 1 wins the round
            player1.addToHand(player2.getHand().remove(0)); // Move player 2's card to player 1's hand
            System.out.println(player1.getName() + " wins the round!");
        } else if (comparison < 0) {
            // Player 2 wins the round
            player2.addToHand(player1.getHand().remove(0)); // Move player 1's card to player 2's hand
            System.out.println(player2.getName() + " wins the round!");
        } else {
            // War: Cards are of equal rank
            System.out.println("War!");
            // Remove cards from players' hands for the war (not implemented in this basic example)
            player1.getHand().remove(0);
            player2.getHand().remove(0);
        }
    }

    // Method to compare ranks of two cards
    private int compareRanks(Card card1, Card card2) {
        // Convert rank strings to integers for comparison
        int rank1 = getRankValue(card1.getRank());
        int rank2 = getRankValue(card2.getRank());
        return Integer.compare(rank1, rank2);
    }

    // Helper method to convert rank strings to integers for comparison
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

    // Concrete subclass of Player representing a human player
    private static class HumanPlayer extends Player {
        public HumanPlayer(String name) {
            super(name);
        }

        @Override
        public void play() {
            // This method is not used in this implementation
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the WarGame class and start the game
        WarGame warGame = new WarGame();
        warGame.play();
    }
}
