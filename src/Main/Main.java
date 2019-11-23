package Main;

import Game.Ground;
import Game.GroundFactory;
import Game.Player;
import Game.PlayerFactory;
import Reader.GameInput;
import Reader.GameInputLoader;

import java.util.Vector;

public class Main {

    public static void main(String[] args){
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

        Vector<Vector<Ground>> map = new Vector<>();
        PlayerFactory playerFactory = PlayerFactory.getInstance();
        GroundFactory groundFactory = GroundFactory.getInstance();
        Player[] players = new Player[nrPlayers];

        // crearea jucatorilor
        for (int i = 0; i < nrPlayers; i++){
            Character character = playersTypeVector.get(i);
            players[i] = playerFactory.createPlayer(character, i);
        }
        // crearea hartii
        for (int i = 0; i < mapLength; i++){
            Vector<Ground> vector = new Vector<>();
            for (int j = 0; j < mapWidth; j++){
                Character character = groundMatrix.get(i).get(j);
                vector.add(groundFactory.createGround(character));
            }
            map.add(vector);
        }
    }
}
