package main;

import game.Game;
import game.angels.Angel;
import game.angels.AngelsFactory;
import game.ground.GameMap;
import game.players.Player;
import game.players.PlayerFactory;
import reader.GameInput;
import reader.GameInputLoader;
import writer.GameOutput;

import java.awt.*;
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
        Vector<Integer> nrAngelsPerRound = gameInput.getNrAngelsPerRound();
        Vector<String> angelsNames = gameInput.getAngelsNames();
        Vector<Vector<Point>> angelsPos = gameInput.getAngelsPos();

        Game game = new Game();
        PlayerFactory playerFactory = PlayerFactory.getInstance();
        Vector<Player> players = new Vector<>(nrPlayers);
        Vector<Vector<Angel>> angels = new Vector<>();
        AngelsFactory angelsFactory = AngelsFactory.getInstance();

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
        // crearea ingerilor
        for (int i = 0; i < nrRounds; i++) {
            int nrAngels = nrAngelsPerRound.get(i);
            Vector<Angel> angelsVector = new Vector<>();
            if (nrAngels == 0){
                angels.add(angelsVector);
                continue;
            }
            for (int j = 0; j < nrAngels; j++) {
                String name = angelsNames.get(j);
                int xPos = (int)angelsPos.get(i).get(j).getX();
                int yPos = (int)angelsPos.get(i).get(j).getY();
                angelsVector.add(angelsFactory.createAngel(name, j, xPos, yPos));
            }
            angels.add(angelsVector);
        }
        // mutarea jucatorilor pe harta
        game.movePlayersOnMapAndPlay(nrRounds, nrPlayers, movesMatrix, gameMap,
                mapLength, mapWidth, players);

        // scrie in fisier
        GameOutput myFileWriter = new GameOutput(args[0], args[1]);
        myFileWriter.writePlayersInFile(players);
    }
}
