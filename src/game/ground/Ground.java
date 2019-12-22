package game.ground;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

import java.util.ArrayList;

public interface Ground {
    float transferGroundModifier(Pyromancer pyromancer);
    float transferGroundModifier(Rogue rogue);
    float transferGroundModifier(Wizard wizard);
    float transferGroundModifier(Knight knight);
    int getNrRoundsParalyzed();
    boolean criticalPower();

    void addPlayerOnThisPlaceId(Integer playerOnThisPlaceId);
    void removePlayerOnThisPlaceId(Integer playerOnThisPlaceId);
    boolean hasTwoPlayersOnThisPlace();
    ArrayList<Integer> getPlayersOnThisPlaceId();

    ArrayList<Integer> getAngelsOnThisPlaceId();
    void addAngelsOnThisPlaceId(final Integer angelOnThisPlaceId);
    void removeAngelOnThisPlaceId(final Integer angelOnThisPlaceId);
}
