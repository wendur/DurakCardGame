package ru.cs.vsu.rudnev_a_e.services;

import ru.cs.vsu.rudnev_a_e.models.Card;
import ru.cs.vsu.rudnev_a_e.models.Player;

public class HandService {

    public void drawCard (Player player, Card card, Card trump) {
        if (player.getHand().size() > 0) {
            int i = 0;
            while (i != player.getHand().size() && compare(card, player.getHand().getHand().get(i), trump)) {
                i++;
            }
            if (i <= player.getHand().size() - 1) {
                player.getHand().getHand().add(i, card);
            } else {
                player.getHand().getHand().add(card);
            }
        } else {
            player.getHand().getHand().add(card);
        }
    }

    private boolean compare(Card first, Card second, Card trump) {
        if (first.getSuit() == trump.getSuit() && second.getSuit() != trump.getSuit()) {
            return true;
        }
        if (first.getSuit() != trump.getSuit() && second.getSuit() == trump.getSuit()) {
            return false;
        }
        return first.getRank().ordinal() > second.getRank().ordinal();
    }

}
