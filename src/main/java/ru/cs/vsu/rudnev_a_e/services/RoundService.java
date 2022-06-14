package ru.cs.vsu.rudnev_a_e.services;

import ru.cs.vsu.rudnev_a_e.models.Card;
import ru.cs.vsu.rudnev_a_e.models.Game;
import ru.cs.vsu.rudnev_a_e.models.PlayArea;
import ru.cs.vsu.rudnev_a_e.models.Player;

import java.util.List;

public class RoundService {
    private final PlayAreaService playAreaService = new PlayAreaService();
    private final PlayerService playerService = new PlayerService();
    private final CheckService checkService = new CheckService();
    private final HandService handService = new HandService();


    public void playFirstRound(Game game) {
        PlayArea table = new PlayArea(5);
        playAreaService.addFirst(table, playerService.makeMove(game.getPlayers().peek()));
        game.getPlayers().add(game.getPlayers().poll());

        Player defer = game.getPlayers().poll();

        System.out.println(defer.getName() + " - defender");

        midStage(game, table, defer);

        playerService.drawCards(game);
    }

    public void playGeneralRound(Game game) {
        PlayArea table = new PlayArea(6);
        playAreaService.addFirst(table, playerService.makeMove(game.getPlayers().peek()));
        game.getPlayers().add(game.getPlayers().poll());

        Player defer = transfer(game, table);

        System.out.println(defer.getName() + " - defender");

        playAreaService.resize(table, defer.getHand().size());

        midStage(game, table, defer);

        playerService.drawCards(game);
    }

    public void midStage(Game game, PlayArea table, Player defer) {
        boolean flag = false;

        while (!flag) {
            append(game, table);

            if (checkService.checkDefPoss(game, table, defer.getHand())) {

                int j = 0;
                while (!checkService.checkAddDef(game.getTrump().getSuit(), table, defer.getHand().getCard(j))) {
                    j++;
                }
                System.out.println(defer.getName() + " <- " + defer.getHand().getCard(j));  //fight back
                playAreaService.addDef(table, defer.getHand().useCard(j));

                append(game, table);

                flag = checkService.checkEndRound(table);
                if (flag) {
                    playAreaService.printCardsOnTable(table);
                    System.out.println(defer.getName() + " ↑");  //fought back
                    game.getPlayers().add(defer);

                    for (int i = 0; i < game.getPlayers().size() - 1; i++) {
                        Player temp = game.getPlayers().poll();

                        game.getPlayers().add(temp);
                    }

                }

            } else {
                append(game, table);
                flag = true;
                List<Card> puff = playAreaService.drawsCards(table);
                playAreaService.printCardsOnTable(table);
                System.out.print(defer.getName() + " ↓ ");        //" puff cards: "

                puff.forEach(card -> {
                    handService.drawCard(defer, card, game.getTrump());
                });
                System.out.println();
                game.getPlayers().add(defer);
            }
        }
    }

    public Player transfer(Game game, PlayArea table) {
        Player defer = game.getPlayers().poll();

        if (checkService.checkTrans(table, defer.getHand())) {
            int i = 0;
            while (table.getRank() != defer.getHand().getCard(i).getRank()) {
                i++;
            }
            System.out.println(defer.getName() + " >> " + defer.getHand().getCard(i));  //transfer
            playAreaService.addAtt(table, defer.getHand().useCard(i));
            game.getPlayers().add(defer);
            return transfer(game, table);
        }

        return defer;
    }

    public void append(Game game, PlayArea table) {

        game.getPlayers().forEach(player -> {
            if (checkService.checkAttPoss(table, player.getHand())) {
                int j = 0;
                while (!checkService.checkAddAtt(table, player.getHand().getCard(j))) {
                    j++;
                }
                System.out.println(player.getName() + " ->> " + player.getHand().getCard(j));  //throw up
                playAreaService.addAtt(table, player.getHand().useCard(j));
            }
        });
    }


}
