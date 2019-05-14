package ai;

import card.Card;
import player.Dealer;

public class Hard implements AI{

    @Override
    public boolean hit(Dealer dealer, Card c) {
        int value;
        
        if (c.getName() > 10) {
            value = 10;
        } else if (c.getName() == 1 && dealer.getTotal() + 11 > 21) {
            value = 1;
        } else if (c.getName() == 1 && dealer.getTotal() + 11 < 21) {
            value = 11;
        } else {
            value = c.getName();
        }
        
        if (dealer.getTotal() + value > 21) {
            return false;
        } else {
            return true;
        }
        
    }

}
