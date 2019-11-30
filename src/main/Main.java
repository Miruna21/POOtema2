package main;

import Game.*;
import Reader.GameInput;
import Reader.GameInputLoader;
import Writer.GameOutput;

import java.io.IOException;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {
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
        Vector<Vector<Ground>> map = new Vector<>();
        PlayerFactory playerFactory = PlayerFactory.getInstance();
        GroundFactory groundFactory = GroundFactory.getInstance();
        Vector<Player> players = new Vector<>(nrPlayers);

        // crearea hartii
        for (int i = 0; i < mapLength; i++){
            Vector<Ground> vector = new Vector<>();
            for (int j = 0; j < mapWidth; j++){
                Character character = groundMatrix.get(i).get(j);
                vector.add(groundFactory.createGround(character));
            }
            map.add(vector);
        }

        // crearea jucatorilor
        for (int i = 0; i < nrPlayers; i++){
            Character character = playersTypeVector.get(i);
            int xPos = playersPosMatrix.get(i).get(0);
            int yPos = playersPosMatrix.get(i).get(1);
            map.get(xPos).get(yPos).addPlayerOnThisPlaceId(i);
            players.add(playerFactory.createPlayer(character, i, xPos, yPos));
        }

        // mutarea jucatorilor pe harta
        game.movePlayersOnMapAndPlay(nrRounds, nrPlayers, movesMatrix, map,
                mapLength, mapWidth, players);

        // scrie in fisier
        GameOutput myFileWriter = new GameOutput(args[0], args[1]);
        myFileWriter.writePlayersInFile(players);
    }
}
