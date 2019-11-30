package reader;
import java.util.Vector;

public class GameInput {
    private int mapLength;
    private int mapWidth;
    private int nrPlayers;
    private int nrRounds;
    private Vector<Vector<Character>> groundMatrix;
    private Vector<Character> playersTypeVector;
    private Vector<Vector<Integer>> playersPosMatrix;
    private Vector<Vector<Character>> movesMatrix;

    public GameInput() {
        mapLength = 0;
        mapWidth = 0;
        nrPlayers = 0;
        nrRounds = 0;
        groundMatrix = null;
        movesMatrix = null;
        playersTypeVector = null;
        playersPosMatrix = null;
    }

    public GameInput(final int mapLength, final int mapWidth,
                        final Vector<Vector<Character>> groundMatrix,
                            final int nrPlayers, final Vector<Character> playersTypeVector,
                                final Vector<Vector<Integer>> playersPosMatrix,
                                    final int nrRounds,
                                        final Vector<Vector<Character>> movesMatrix) {
        this.mapLength = mapLength;
        this.mapWidth = mapWidth;
        this.nrPlayers = nrPlayers;
        this.nrRounds = nrRounds;
        this.groundMatrix = groundMatrix;
        this.playersTypeVector = playersTypeVector;
        this.playersPosMatrix = playersPosMatrix;
        this.movesMatrix = movesMatrix;
    }

    public final int getMapLength() {
        return mapLength;
    }

    public final int getMapWidth() {
        return mapWidth;
    }

    public final int getNrPlayers() {
        return nrPlayers;
    }

    public final int getNrRounds() {
        return nrRounds;
    }

    public final Vector<Vector<Character>> getGroundMatrix() {
        return groundMatrix;
    }

    public final Vector<Vector<Character>> getMovesMatrix() {
        return movesMatrix;
    }

    public final Vector<Character> getPlayersTypeVector() {
        return playersTypeVector;
    }

    public final Vector<Vector<Integer>> getPlayersPosMatrix() {
        return playersPosMatrix;
    }
}
