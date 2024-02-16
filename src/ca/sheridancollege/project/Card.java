package ca.sheridancollege.project;

/**
 * A class representing a playing card for the game of War.
 * Each card has a rank and a suit.
 * 
 * @author Muhammad Aiz Baloch
 */
public class Card extends Object {
    // Properties
    private String rank; // Rank of the card
    private String suit; // Suit of the card

    // Constructor
    public Card(String rank, String suit) {
        this.rank = rank; // initialize the rank of the card
        this.suit = suit; // initialize the suit of the card
    }

    // Getters and Setters

      /**
     * Gets the rank of the card.
     * 
     * @return The rank of the card.
     */

    public String getRank() {
        return rank;
    }

      /**
     * Sets the rank of the card.
     * 
     * @param rank The rank of the card to be set.
     */

    public void setRank(String rank) {
        this.rank = rank;
    }

        /**
     * Gets the suit of the card.
     * 
     * @return The suit of the card.
     */

    public String getSuit() {
        return suit;
    }

       /**
     * Sets the suit of the card.
     * 
     * @param suit The suit of the card to be set.
     */

    public void setSuit(String suit) {
        this.suit = suit;
    }

    // Override toString method to provide a meaningful representation of a card

      /**
     * Returns a string representation of the card.
     * 
     * @return A string representation of the card, including its rank and suit.
     */

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
