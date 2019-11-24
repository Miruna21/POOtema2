package Game;

import java.util.Vector;

public class Game {
    public void movePlayersOnMapAndPlay(final int nrRounds, final int nrPlayers,
                                 final Vector<Vector<Character>> movesMatrix, final Vector<Vector<Ground>> map,
                                 final int mapLength, final int mapWidth, final Vector<Player> players){
        for (int i = 0; i < nrRounds; i++){
            for (int j = 0; j < nrPlayers; j++) {
                Character move = movesMatrix.get(i).get(j);
                int currentPlayerId = players.get(j).getId();
                int xPos = players.get(j).getxPos();
                int yPos = players.get(j).getyPos();
                switch (move){
                    case 'U':
                        map.get(xPos).get(yPos).removePlayerOnThisPlaceId(currentPlayerId);
                        int xPos1 = xPos - 1;
                        map.get(xPos1).get(yPos).addPlayerOnThisPlaceId(currentPlayerId);
                    case 'D':
                        map.get(xPos).get(yPos).removePlayerOnThisPlaceId(currentPlayerId);
                        int xPos2 = xPos + 1;
                        map.get(xPos2).get(yPos).addPlayerOnThisPlaceId(currentPlayerId);
                    case 'L':
                        map.get(xPos).get(yPos).removePlayerOnThisPlaceId(currentPlayerId);
                        int yPos1 = yPos - 1;
                        map.get(xPos).get(yPos1).addPlayerOnThisPlaceId(currentPlayerId);
                    case 'R':
                        map.get(xPos).get(yPos).removePlayerOnThisPlaceId(currentPlayerId);
                        int yPos2 = yPos + 1;
                        map.get(xPos).get(yPos2).addPlayerOnThisPlaceId(currentPlayerId);
                    case '_':

                }
            }
            lookForBattlesAndStartTheFight(map, mapLength, mapWidth, players, i);
        }
    }
    public void lookForBattlesAndStartTheFight(final Vector<Vector<Ground>> map,
                                               final int mapLength, final int mapWidth,
                                                    final Vector<Player> players,
                                                        final int currentRound){
        for (int i = 0; i < mapLength; i++){
            for (int j = 0; j < mapWidth; j++){

            }
        }
    }
}
