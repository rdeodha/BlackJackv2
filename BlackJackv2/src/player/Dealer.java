package player;

import java.util.ArrayList;

import ai.AI;
import card.Card;

public class Dealer implements Player{

    private String name = "Dealer";
    private int total;
    private ArrayList<Card> cards;
    private boolean bust;
    private AI difficulty;
    private Card hidden;
    
    public Dealer(AI difficulty) {
        this.difficulty = difficulty;
        total = 0;
        cards = new ArrayList<Card>();
        bust = false;
        hidden = null;
    }
    
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public int getTotal() {
        return total;
    }

    public Card getHidden() {
        return hidden;
    }
    
    public Card showHidden() {
        addCard(hidden);
        return hidden;
    }
    
    public boolean turn(Card c, int toBeat) {
        return difficulty.hit(this, c, toBeat);
    }
    
    @Override
    public void addCard(Card c) {
        if (hidden == null) {
            hidden = c;
        } else {
            cards.add(c);
            calculateTotal(c);   
        }
    }

    private void calculateTotal(Card c) {
        if (c.getName() == 1) {
            total += 11;
        } else if (c.getName() > 10) {
            total += 10;
        } else {
            total += c.getName();
        }
        
        if (total > 21) {
            bust = true;
        }
        
        
        if (bust) {
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).getName() == 1 && cards.get(i).getAce11()) {
                    total -= 10;
                    cards.get(i).falseAce11();
                    bust = false;
                    break;
                }
            }
        }
    }
    
    @Override
    public void reset() {
        total = 0;
        cards.clear();
        bust = false;
        hidden = null;
    }

    @Override
    public boolean busted() {
        return bust;
    }

    public void setDiff(AI diff) {
        this.difficulty = diff;
    }
}
