package ru.cs.vsu.rudnev_a_e.models;

public enum Rank {
    Six("6"), Seven("7"), Eight("8"), Nine("9"), Ten("10"), Jack("Jack"), Queen("Queen"), King("King"), Ace("Ace");

    private final String rank;

    Rank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
