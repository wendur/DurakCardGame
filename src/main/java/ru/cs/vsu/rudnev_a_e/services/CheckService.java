package ru.cs.vsu.rudnev_a_e.services;

import ru.cs.vsu.rudnev_a_e.models.*;


public class CheckService {
    public boolean checkDefPoss(Game game, PlayArea table, Hand hand) {
        return hand.getHand().stream().anyMatch(card -> checkAddDef(game.getTrump().getSuit(), table, card));
    }

    public boolean checkAddDef(Suit suit, PlayArea table, Card card) {
        if (card.getSuit() == suit && table.getPlayArea().get(table.getDefPointer()).getAtt().getSuit() != suit) {
            return true;
        } else if (card.getSuit() == table.getPlayArea().get(table.getDefPointer()).getAtt().getSuit() &&
                card.getRank().ordinal() > table.getPlayArea().get(table.getDefPointer()).getAtt().getRank().ordinal()){
            return true;
        }
        return false;
    }

    public boolean checkAttPoss(PlayArea table, Hand hand) {
        return hand.getHand().stream().anyMatch(card -> (table.getAttPointer() < table.getSize() && checkIdentical(table, card)));
    }

    public boolean checkAddAtt(PlayArea table, Card card) {
        return checkIdentical(table, card);
    }

    public boolean checkTrans(PlayArea table, Hand hand) {
        return checkAttPoss(table, hand);
    }

    public boolean checkEndRound(PlayArea table) {
        return table.getDefPointer() == table.getAttPointer();
    }

    public boolean checkIdentical(PlayArea table, Card card) {
        for (int i = 0; i < table.getAttPointer(); i++) {
            if (card.getRank() == table.getPlayArea().get(i).getAtt().getRank()) {
                return true;
            }
        }
        for (int i = 0; i < table.getDefPointer(); i++) {
            if (card.getRank() == table.getPlayArea().get(i).getDef().getRank()) {
                return true;
            }
        }
        return false;
    }
}
