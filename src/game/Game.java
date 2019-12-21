package game;

import game.ground.GameMap;
import game.ground.Ground;
import game.players.Player;

import java.util.List;
import java.util.Vector;

public final class Game {
    public void movePlayersOnMapAndPlay(final int nrRounds, final int nrPlayers,
                                        final Vector<Vector<Character>> movesMatrix,
                                        final GameMap gameMap, final int mapLength,
                                        final int mapWidth, final Vector<Player> players) {
        for (int i = 0; i < nrRounds; i++) {
            for (int j = 0; j < nrPlayers; j++) {
                Character move = movesMatrix.get(i).get(j);
                int currentPlayerId = players.get(j).getId();
                int xPos = players.get(j).getxPos();
                int yPos = players.get(j).getyPos();
                // daca jucatorul a iesit din joc
                if (!players.get(j).getLife()) {
                    continue;
                }
                // daca nu se poate misca in runda curenta
                if (!players.get(j).getMovPermission()) {
                    players.get(j).setMovPermission(true);
                    continue;
                }
                if (players.get(j).getNrRoundsParalyzed() != 0) {
                    int overtimeDamage = players.get(j).getOvertimeDamage();
                    players.get(j).subHp(overtimeDamage);
                    players.get(j).subNrRoundsParalysed(1);
                    continue;
                }
                if (players.get(j).getNrRoundsIgniteHit() != 0) {
                    int overtimeDamage = players.get(j).getOvertimeDamage();
                    players.get(j).subHp(overtimeDamage);
                    players.get(j).subNrRoundsIgniteHit(1);
                }
                switch (move) {
                    case 'U':
                        gameMap.getMap().get(xPos).get(yPos).
                                        removePlayerOnThisPlaceId(currentPlayerId);
                        int xPos1 = xPos - 1;
                        if (xPos1 < 0) {
                            break;
                        }
                        gameMap.getMap().get(xPos1).get(yPos).
                                            addPlayerOnThisPlaceId(currentPlayerId);
                        players.get(j).setxPos(xPos1);
                        break;
                    case 'D':
                        gameMap.getMap().get(xPos).get(yPos).
                                            removePlayerOnThisPlaceId(currentPlayerId);
                        int xPos2 = xPos + 1;
                        if (xPos2 >= mapWidth) {
                            break;
                        }
                        gameMap.getMap().get(xPos2).get(yPos).
                                        addPlayerOnThisPlaceId(currentPlayerId);
                        players.get(j).setxPos(xPos2);
                        break;
                    case 'L':
                        gameMap.getMap().get(xPos).get(yPos).
                                    removePlayerOnThisPlaceId(currentPlayerId);
                        int yPos1 = yPos - 1;
                        if (yPos1 < 0) {
                            break;
                        }
                        gameMap.getMap().get(xPos).get(yPos1).
                                    addPlayerOnThisPlaceId(currentPlayerId);
                        players.get(j).setyPos(yPos1);
                        break;
                    case 'R':
                        gameMap.getMap().get(xPos).get(yPos).
                                    removePlayerOnThisPlaceId(currentPlayerId);
                        int yPos2 = yPos + 1;
                        if (yPos2 >= mapLength) {
                            break;
                        }
                        gameMap.getMap().get(xPos).get(yPos2).
                                        addPlayerOnThisPlaceId(currentPlayerId);
                        players.get(j).setyPos(yPos2);
                        break;
                    case '_':
                        break;
                    default:
                }
            }
            lookForBattlesAndStartTheFight(gameMap, mapLength, mapWidth, players);

        }
    }
    private void lookForBattlesAndStartTheFight(final GameMap gameMap,
                                                final int mapLength, final int mapWidth,
                                                final Vector<Player> players) {
        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapWidth; j++) {
                if (gameMap.getMap().get(i).get(j).hasTwoPlayersOnThisPlace()) {
                    Ground fightGround = gameMap.getMap().get(i).get(j);
                    List<Integer> playersOnThisPlace =
                                        gameMap.getMap().get(i).get(j).getPlayersOnThisPlaceId();
                    int firstIdPlayer = playersOnThisPlace.get(0);
                    int secondIdPlayer = playersOnThisPlace.get(1);
                    // daca cei 2 jucatori sunt in viata, acestia se vor lupta unul cu altul
                    if (players.get(firstIdPlayer).getLife()
                            && players.get(secondIdPlayer).getLife()) {
                        // wizard ataca al doilea
                        if (players.get(firstIdPlayer).startFirst()) {
                            players.get(secondIdPlayer).isHitBy(players.get(firstIdPlayer),
                                                fightGround);
                            players.get(firstIdPlayer).isHitBy(players.get(secondIdPlayer),
                                                fightGround);
                        } else {
                            players.get(firstIdPlayer).isHitBy(players.get(secondIdPlayer),
                                                fightGround);
                            players.get(secondIdPlayer).isHitBy(players.get(firstIdPlayer),
                                                fightGround);
                        }
                        if (!players.get(firstIdPlayer).getLife()) {
                            fightGround.removePlayerOnThisPlaceId(firstIdPlayer);
                        }
                        if (!players.get(secondIdPlayer).getLife()) {
                            fightGround.removePlayerOnThisPlaceId(secondIdPlayer);
                        }
                        verifyVictimDead(players.get(firstIdPlayer), players.get(secondIdPlayer));
                        verifyVictimDead(players.get(secondIdPlayer), players.get(firstIdPlayer));
                    }
                }
            }
        }
    }
    private void verifyVictimDead(final Player attacker, final Player victim) {
        if (!victim.getLife()) {
            int max;
            int a = 0;
            int b = 200 - (attacker.getLevel() - victim.getLevel()) * 40;
            int xpWinner = attacker.getXp();
            int newXpWinner;
            max = Math.max(a, b);
            newXpWinner = xpWinner + max;
            if (newXpWinner != xpWinner) {
                attacker.gainXp(newXpWinner, attacker.getInitialHp(),
                                            attacker.getPlusHpPerLevel());
            }
        }
    }
}
