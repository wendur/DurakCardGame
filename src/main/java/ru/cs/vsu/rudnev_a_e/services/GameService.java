package ru.cs.vsu.rudnev_a_e.services;

import ru.cs.vsu.rudnev_a_e.models.Game;

public class GameService {
    private final PlayerService playerService = new PlayerService();
    private final DeckService deckService = new DeckService();
    private final RoundService roundService = new RoundService();

    public void startGame(int countOfPlayers) throws Exception {
        Game game = new Game();
        System.out.println("DURAK CARD GAME");
        setupGame(game, countOfPlayers);
        play(game);
    }

    public void setupGame(Game game, int countOfPlayers) throws Exception {
        playerService.createPlayerList(countOfPlayers, game);
        deckService.createDeck(game);
        deckService.dealing(game);
    }

    public void play(Game game) throws Exception {
        roundService.playFirstRound(game);
        while (game.getPlayers().size() > 1) {
            roundService.playGeneralRound(game);
            if (game.getDeck().isEmpty()) {
                int size = game.getPlayers().size();
                for (int i = 0; i < size; i++) {
                    if (game.getPlayers().peek().getHand().size() == 0) {
                        game.getPlayers().poll();
                    } else {
                        game.getPlayers().add(game.getPlayers().poll());
                    }
                }
            }
        }
        if (!game.getPlayers().isEmpty()) {
            System.out.println(game.getPlayers().peek().getName() + " - DURAK!!!");
            System.out.print("Remained in his hand cards: ");
            System.out.print(playerService.cardList(game.getPlayers().peek()));
        } else {
            System.out.print("Draw");
        }
    }
}
