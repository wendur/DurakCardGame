package ru.cs.vsu.rudnev_a_e.services;

import ru.cs.vsu.rudnev_a_e.models.Card;
import ru.cs.vsu.rudnev_a_e.models.Game;
import ru.cs.vsu.rudnev_a_e.models.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayerService {
    private final HandService handService = new HandService();

    public void createPlayerList(int countOfPlayers, Game game) throws Exception {
        if (countOfPlayers < 2 || countOfPlayers > 6) {
            throw new Exception("Incorrect number of players!!!");
        }
        Queue<Player> players = new LinkedList<>();
        for (int i = 0; i < countOfPlayers; i++) {
            players.add(new Player("Player " + (i+1)));
        }
        game.setPlayers(players);
    }

    public Card makeMove(Player player) {
        System.out.println(player.getName() + " -> " + player.getHand().getCard(0).toString());   //started with
        return player.getHand().useCard(0);
    }


    public void drawCards(Game game) {
        game.getPlayers().forEach(player -> {
            int num = needToDraw(player);
            for (int j = 0; j < num; j++) {
                if (!game.getDeck().isEmpty()) {
                    handService.drawCard(player, game.getDeck().give(), game.getTrump());
                }
            }
        });

        System.out.println();
    }


    public int needToDraw(Player player) {
        if (player.getHand().size() < 6) {
            return 6 - player.getHand().size();
        } else {
            return 0;
        }
    }

    public String cardList(Player player) {
        StringBuilder ret = new StringBuilder();
        List<Card> cards = player.getHand().getCards();

        cards.forEach(card -> {
            ret.append(" ").append(card);
        });

        return ret.toString();
    }


}
