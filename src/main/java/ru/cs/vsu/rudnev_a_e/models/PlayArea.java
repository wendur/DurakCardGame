package ru.cs.vsu.rudnev_a_e.models;

import java.util.ArrayList;
import java.util.List;

public class PlayArea {
    private final List<Pair> playArea;
    private int size;
    private int attPointer = 0;
    private int defPointer = 0;

    public PlayArea(int size) {
        this.playArea = new ArrayList<>();
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void resize(int s){
        size = s;
    }

    public int getAttPointer() {
        return attPointer;
    }

    public int getDefPointer() {
        return defPointer;
    }

    public List<Pair> getPlayArea() {
        return playArea;
    }

    public void upAttPointer() {
        attPointer++;
    }

    public void upDefPointer() { defPointer++; }

    public Rank getRank() { return playArea.get(0).getAtt().getRank(); }

}
