package ru.cs.vsu.rudnev_a_e.models;

public class Pair {
    private Card att;
    private Card def;

    public Pair(Card card) {
        this.att = card;
    }

    public void addDef(Card card) {
        def = card;
    }

    public Card getAtt() {
        return att;
    }

    public Card getDef() {
        return def;
    }
}
