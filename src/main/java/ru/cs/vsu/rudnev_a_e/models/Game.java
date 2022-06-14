package ru.cs.vsu.rudnev_a_e.models;

import java.util.Queue;

public class Game {

    private Queue<Player> players;
    private Deck deck;
    private Card trump;

    public void setPlayers(Queue<Player> players) { this.players = players; }
    public void setDeck(Deck deck) { this.deck = deck; }
    public void setTrump(Card trump) { this.trump = trump; }

    public Queue<Player> getPlayers() { return players; }
    public Deck getDeck() { return deck; }
    public Card getTrump() { return trump; }

}
