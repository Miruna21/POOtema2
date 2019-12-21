package game.ground;

import java.util.Vector;

public final class GameMap {
    private static GameMap instance = null;
    private Vector<Vector<Ground>> map;

    private GameMap() {
        map = new Vector<>();
    }

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }
    public void createGameMap(final int mapLength, final int mapWidth,
                                 final Vector<Vector<Character>> groundMatrix) {
        GroundFactory groundFactory = GroundFactory.getInstance();
        for (int i = 0; i < mapLength; i++) {
            Vector<Ground> vector = new Vector<>();
            for (int j = 0; j < mapWidth; j++) {
                Character character = groundMatrix.get(i).get(j);
                vector.add(groundFactory.createGround(character));
            }
            map.add(vector);
        }
    }

    public Vector<Vector<Ground>> getMap() {
        return map;
    }
}
