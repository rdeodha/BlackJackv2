package player;

import java.util.ArrayList;

import card.Card;

public interface Player {

    public String getName();
    public ArrayList<Card> getCards();
    public int getTotal();
    public void addCard(Card c);
    public void reset();
    public boolean busted();
}
