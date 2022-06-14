package ru.cs.vsu.rudnev_a_e.models;

public enum Suit {
    Hearts("♥"), Diamonds("♦"), Clubs("♣"), Spades("♠");

    private final String suit;

    Suit(String suit) { this.suit = suit; }

    public String getSuit() { return suit; }
}
