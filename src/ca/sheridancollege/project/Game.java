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

    private final String name; // the title of the game
    private ArrayList<Player> players; // the players of the game
    private ArrayList<Card> deck; // the deck of cards

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
        deck = new ArrayList<>();
        initializeDeck(); // initialize the deck when a game object is created
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
     * set the players of this game.
     * 
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * initialize the deck of cards with 52 cards.
     */
    private void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
        shuffleDeck(); // shuffle the deck after initialization
    }

    /**
     * shuffle the deck of cards.
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
     * play the game. this method should be implemented in concrete subclasses.
     */
    public abstract void play();

    /**
     * declare the winner of the game. this method should be implemented in concrete subclasses.
     */
    public abstract void declareWinner();
}
