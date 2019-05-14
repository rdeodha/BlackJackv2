package player;

import java.util.ArrayList;

import card.Card;

public class User implements Player{

    private String name;
    private int total;
    private ArrayList<Card> cards;
    private boolean bust;
    
    public User(String name) {
        this.name = name;
        total = 0;
        cards = new ArrayList<Card>();
        bust = false;
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

    @Override
    public void addCard(Card c) {
        cards.add(c);
        calculateTotal(c);        
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
        bust = false;
        total = 0;
        cards.clear();      
    }


    @Override
    public boolean busted() {
        return bust;
    }

}
