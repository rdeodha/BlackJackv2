package card;

/**
 * POJO Card object
 * @author Rushikesh Deodhar
 *
 */
public class Card {
    /** Suit value [1, 4] */
    private int suit;
    
    /** Card value [1, 13] */
    private int name;
    
    /** If card is an ace with value 11 */
    boolean ace11;
    
    /**
     * Creates a new card
     * @param suit suit of card
     * @param value value of card
     */
    public Card(int suit, int value) {
        setSuit(suit);
        setName(value);
    }
    
    /**
     * Sets the card suit
     * @param suit suit of card
     */
    public void setSuit(int suit) {
        if (suit < 1 || suit > 4) {
            throw new IllegalArgumentException(Integer.toString(suit));
        }

        this.suit = suit;
    }
     
    /**
     * Sets the card value
     * @param value value of the card
     */
    public void setName(int name) {
        if (name < 1 || name > 13) {
            throw new IllegalArgumentException(Integer.toString(name));
        }
        
        this.name = name;
        
        if (name == 1) {
            ace11 = true;
        } else {
            ace11 = false;
        }
    }
    
    /**
     * Gets the suit of the card
     * @return suit of the card
     */
    public int getSuit() {
        return suit;
    }
    
    /**
     * Gets the value of the card
     * @return value of the card
     */
    public int getName() {
        return name;
    }
    
    /**
     * Gets if card is ace with 11 value
     * @return if ace with 11 value
     */
    public boolean getAce11() {
        return ace11;
    }
    
    /**
     * Sets ace11 to false
     */
    public void falseAce11() {
        ace11 = false;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (name == 1) {
            str.append("Ace of ");
        } else if (name > 1 && name < 11) {
            str.append(name);
            str.append(" of ");
        } else if (name == 11) {
            str.append("Jack of ");
        } else if (name == 12) {
            str.append("Queen of ");
        } else {
            str.append("King of ");
        }
        
        if (suit == 1) {
            str.append("Spades");
        } else if (suit == 2) {
            str.append("Hearts");
        } else if (suit == 3) {
            str.append("Diamonds");
        } else {
            str.append("Clubs");
        }
        
        return str.toString();
    }
}

