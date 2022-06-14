package ru.cs.vsu.rudnev_a_e;

import ru.cs.vsu.rudnev_a_e.services.GameService;

public class Main {

    public static void main(String[] args) throws Exception {

        GameService gameService = new GameService();
        gameService.startGame(4);

    }
}
