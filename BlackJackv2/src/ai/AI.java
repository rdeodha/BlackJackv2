package ai;

import card.Card;
import player.Dealer;

public interface AI {

    public boolean hit(Dealer dealer, Card c);
}
