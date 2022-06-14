package ru.cs.vsu.rudnev_a_e.models;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() { return name; }

    public Hand getHand() { return hand; }
}
