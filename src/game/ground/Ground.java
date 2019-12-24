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

    void addDeadPlayerOnThisPlaceId(Integer deadPlayerOnThisPlaceId);
    void addLivePlayerOnThisPlaceId(Integer livePlayerOnThisPlaceId);
    void removeDeadPlayerOnThisPlaceId(Integer deadPlayerOnThisPlaceId);
    void removeLivePlayerOnThisPlaceId(Integer livePlayerOnThisPlaceId);
    boolean hasTwoLivePlayersOnThisPlace();
    ArrayList<Integer> getDeadPlayersOnThisPlaceId();
    ArrayList<Integer> getLivePlayersOnThisPlaceId();
}
