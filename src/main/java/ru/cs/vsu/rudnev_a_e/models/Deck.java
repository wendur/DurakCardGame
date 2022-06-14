package ru.cs.vsu.rudnev_a_e.models;

import java.util.Queue;
import java.util.Stack;

public class Deck {
    private Queue<Card> cards;

    public Deck(Queue<Card> cards) { this.cards = cards; }

    public Card give() { return cards.poll(); }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
