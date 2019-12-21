package main;

import game.Game;
import game.ground.GameMap;
import game.players.Player;
import game.players.PlayerFactory;
import reader.GameInput;
import reader.GameInputLoader;
import writer.GameOutput;

import java.io.IOException;
import java.util.Vector;

public final class Main {
    private Main() {
        // just to trick checkstyle
    }

    public static void main(final String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        int mapLength = gameInput.getMapLength();
        int mapWidth = gameInput.getMapWidth();
        int nrPlayers = gameInput.getNrPlayers();
        int nrRounds = gameInput.getNrRounds();
        Vector<Vector<Character>> groundMatrix = gameInput.getGroundMatrix();
        Vector<Character> playersTypeVector = gameInput.getPlayersTypeVector();
        Vector<Vector<Integer>> playersPosMatrix = gameInput.getPlayersPosMatrix();
        Vector<Vector<Character>> movesMatrix = gameInput.getMovesMatrix();

        Game game = new Game();
        PlayerFactory playerFactory = PlayerFactory.getInstance();
        Vector<Player> players = new Vector<>(nrPlayers);

        // crearea hartii
        GameMap gameMap = GameMap.getInstance();
        gameMap.createGameMap(mapLength, mapWidth, groundMatrix);
        // crearea jucatorilor
        for (int i = 0; i < nrPlayers; i++) {
            Character character = playersTypeVector.get(i);
            int xPos = playersPosMatrix.get(i).get(0);
            int yPos = playersPosMatrix.get(i).get(1);
            gameMap.getMap().get(xPos).get(yPos).addPlayerOnThisPlaceId(i);
            players.add(playerFactory.createPlayer(character, i, xPos, yPos));
        }

        // mutarea jucatorilor pe harta
        game.movePlayersOnMapAndPlay(nrRounds, nrPlayers, movesMatrix, gameMap,
                mapLength, mapWidth, players);

        // scrie in fisier
        GameOutput myFileWriter = new GameOutput(args[0], args[1]);
        myFileWriter.writePlayersInFile(players);
    }
}
