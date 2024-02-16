package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
* Models each Player in the game.
* Players have a name and a hand of cards.
* Provides methods for managing the player's hand of cards and playing the game.
*
* @author Muhammad Aiz Baloch
 */
public abstract class Player {

    private String name; // the unique name for this player
    private List<Card> hand; // the player's hand of cards

    /**
     * a constructor that allows you to set the player's name and initialize their hand of cards.
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
     * set the player's name.
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
     * set the player's hand of cards.
     *
     * @param hand the hand of cards to set
     */
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    /**
     * add a card to the player's hand.
     *
     * @param card the card to add
     */
    public void addToHand(Card card) {
        hand.add(card);
    }

    /**
     * remove a card from the player's hand.
     *
     * @param card the card to remove
     */
    public void removeFromHand(Card card) {
        hand.remove(card);
    }

    /**
     * the method to be overridden when subclassing the Player class with specific player types.
     * this method should define the logic for a player's turn in the game.
     */
    public abstract void play();
}
