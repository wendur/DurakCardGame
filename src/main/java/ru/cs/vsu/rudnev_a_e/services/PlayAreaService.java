package ru.cs.vsu.rudnev_a_e.services;

import ru.cs.vsu.rudnev_a_e.models.Card;
import ru.cs.vsu.rudnev_a_e.models.Game;
import ru.cs.vsu.rudnev_a_e.models.Pair;
import ru.cs.vsu.rudnev_a_e.models.PlayArea;

import java.util.ArrayList;
import java.util.List;

public class PlayAreaService {

    public void addFirst(PlayArea table, Card card) {
        table.getPlayArea().add(new Pair(card));
        table.upAttPointer();
    }

    public void addAtt(PlayArea table, Card card) {
        if (table.getAttPointer() < table.getSize()) {
            table.getPlayArea().add(new Pair(card));
            table.upAttPointer();
        }
    }

    public void addDef(PlayArea table, Card card) {
        table.getPlayArea().get(table.getDefPointer()).addDef(card);
        table.upDefPointer();
    }

    public void resize(PlayArea table, int size) {
        if (size < 6) {
            table.resize(size);
        }
    }

    public List<Card> drawsCards(PlayArea table) {
        List<Card> puff = new ArrayList<>();

        for (int i = 0; i < table.getAttPointer(); i++) {
            puff.add(table.getPlayArea().get(i).getAtt());
        }

        for (int i = 0; i < table.getDefPointer(); i++) {
            puff.add(table.getPlayArea().get(i).getDef());

        }
        return puff;
    }

    public void printCardsOnTable(PlayArea table) {
        System.out.println("Table: ");
        System.out.print("Attack cards: ");
        for (int i = 0; i < table.getAttPointer(); i++) {
            System.out.print(table.getPlayArea().get(i).getAtt().toString() + " ");
            for (int j = 0; j < 10 - table.getPlayArea().get(i).getAtt().toString().length(); j++) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.print("Defend cards: ");
        for (int i = 0; i < table.getDefPointer(); i++) {
            System.out.print(table.getPlayArea().get(i).getDef() + " ");

            for (int j = 0; j < 10 - table.getPlayArea().get(i).getDef().toString().length(); j++) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
