package Game;

import java.util.List;
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
                // daca nu se poate misca in runda curenta
                if (!players.get(j).getMovPermission()){
                    players.get(j).setMovPermission(true);
                    continue;
                }
                switch (move){
                    case 'U':
                        map.get(xPos).get(yPos).removePlayerOnThisPlaceId(currentPlayerId);
                        int xPos1 = xPos - 1;
                        if (xPos1 >= mapWidth){
                            break;
                        }
                        map.get(xPos1).get(yPos).addPlayerOnThisPlaceId(currentPlayerId);
                        players.get(j).setxPos(xPos1);
                    case 'D':
                        map.get(xPos).get(yPos).removePlayerOnThisPlaceId(currentPlayerId);
                        int xPos2 = xPos + 1;
                        if (xPos2 >= mapWidth){
                            break;
                        }
                        map.get(xPos2).get(yPos).addPlayerOnThisPlaceId(currentPlayerId);
                        players.get(j).setxPos(xPos2);
                    case 'L':
                        map.get(xPos).get(yPos).removePlayerOnThisPlaceId(currentPlayerId);
                        int yPos1 = yPos - 1;
                        if (yPos1 >= mapLength){
                            break;
                        }
                        map.get(xPos).get(yPos1).addPlayerOnThisPlaceId(currentPlayerId);
                        players.get(j).setyPos(yPos1);
                    case 'R':
                        map.get(xPos).get(yPos).removePlayerOnThisPlaceId(currentPlayerId);
                        int yPos2 = yPos + 1;
                        if (yPos2 >= mapLength){
                            break;
                        }
                        map.get(xPos).get(yPos2).addPlayerOnThisPlaceId(currentPlayerId);
                        players.get(j).setyPos(yPos2);
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
                if (map.get(i).get(j).hasTwoPlayersOnThisPlace()){
                    Ground fightGround = map.get(i).get(j);
                    List<Integer> playersOnThisPlace = map.get(i).get(j).getPlayersOnThisPlaceId();
                    int firstIdPlayer = playersOnThisPlace.get(0);
                    int secondIdPlayer = playersOnThisPlace.get(1);
                    if (players.get(firstIdPlayer).getNrRoundParalyzed() != 0){
                        int overtimeDamage = players.get(firstIdPlayer).getOvertimeDamage();
                        players.get(firstIdPlayer).subHp(overtimeDamage);
                        players.get(firstIdPlayer).subNrRoundParalysed(1);
                        if (players.get(firstIdPlayer).getHp() < 0){
                            players.get(firstIdPlayer).setLife(false);
                        }
                    }
                    if (players.get(secondIdPlayer).getNrRoundParalyzed() != 0){
                        int overtimeDamage = players.get(secondIdPlayer).getOvertimeDamage();
                        players.get(secondIdPlayer).subHp(overtimeDamage);
                        players.get(secondIdPlayer).subNrRoundParalysed(1);
                        if (players.get(firstIdPlayer).getHp() < 0){
                            players.get(firstIdPlayer).setLife(false);
                        }
                    }
                    // daca cei 2 jucatori sunt in viata, acestia se vor lupta unul cu altul
                    if (players.get(firstIdPlayer).getLife()
                            && players.get(secondIdPlayer).getLife()){
                        players.get(firstIdPlayer).setRound(currentRound);
                        players.get(secondIdPlayer).setRound(currentRound);
                        // wizard ataca al doilea
                        if (!(players.get(firstIdPlayer) instanceof Wizard)){
                            players.get(firstIdPlayer).isHitBy(players.get(secondIdPlayer), fightGround);
                            players.get(secondIdPlayer).isHitBy(players.get(firstIdPlayer), fightGround);
                        } else {
                            players.get(secondIdPlayer).isHitBy(players.get(firstIdPlayer), fightGround);
                            players.get(firstIdPlayer).isHitBy(players.get(secondIdPlayer), fightGround);
                        }
                    }
                }
            }
        }

        // resetare damage fara race modifier
        for (int i = 0; i < players.size(); i++){
            players.get(i).setDamageWithoutRaceModifier(0);
        }
    }
}
