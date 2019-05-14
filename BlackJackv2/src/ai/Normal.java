package ai;

import card.Card;
import player.Dealer;

public class Normal implements AI{

    @Override
    public boolean hit(Dealer dealer, Card c, int toBeat) {
        if (dealer.getTotal() > toBeat) {
            return false;
        }
        
        if (dealer.getTotal() < 17) {
            return true;
        } else if (dealer.getTotal() > 17) {
            return false;
        } else {
            for (Card ca : dealer.getCards()) {
                if (ca.getAce11() == true) {
                    return true;
                }
            }
            
            return false;
        }
        
    }

}
