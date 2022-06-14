package ru.cs.vsu.rudnev_a_e.models;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public int size() { return hand.size(); }

    public Card getCard(int i) { return hand.get(i); }

    public Card useCard(int i) {
        return hand.remove(i);
    }

    public List<Card> getCards() {
        return hand;
    }
}
