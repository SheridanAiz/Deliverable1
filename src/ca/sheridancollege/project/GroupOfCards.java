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

    // the group of cards, stored in an arrayList
    private ArrayList<Card> cards;
    private int size; // the maximum size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>();
    }

    /**
     * det the group of cards as an arrayList.
     * 
     * @return the group of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * add a card to the group of cards.
     * 
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (cards.size() < size) {
            cards.add(card);
        }
    }

    /**
     * remove a card from the group of cards.
     * 
     * @param card the card to remove
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * shuffle the group of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * get the size of the group of cards.
     * 
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * set the max size for the group of cards.
     * 
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
}
