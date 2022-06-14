package ru.cs.vsu.rudnev_a_e.services;

import ru.cs.vsu.rudnev_a_e.models.*;

import java.util.*;


public class DeckService {
    private final HandService handService = new HandService();

    public void createDeck(Game game) throws Exception {

        Queue<Card> deck = new LinkedList<>();


        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        Collections.shuffle((List<?>) deck);

        System.out.println("Trump is - " + deck.peek().toString() + "\n");
        game.setTrump(deck.peek());
        deck.add(deck.poll());

        game.setDeck(new Deck(deck));

    }

    public void dealing(Game game) throws Exception {
        Queue<Player> players = game.getPlayers();
        Deck deck = game.getDeck();

        for (int j = 0; j < 6; j++) {
            players.forEach(player -> {
                handService.drawCard(player, deck.give(), game.getTrump());
            });
        }
    }
}
