package game.ground;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

import java.util.ArrayList;
import java.util.Collections;

public final class Land implements Ground {
    private static final float SPECIAL_LAND_MODIFIER = 1.15f;
    private static final int NR_ROUNDS_PARALYZED = 3;
    private ArrayList<Integer> deadPlayersOnThisPlaceId;
    private ArrayList<Integer> livePlayersOnThisPlaceId;

    public Land() {
        this.livePlayersOnThisPlaceId = new ArrayList<>();
        this.deadPlayersOnThisPlaceId = new ArrayList<>();
    }

    public ArrayList<Integer> getLivePlayersOnThisPlaceId() {
        return livePlayersOnThisPlaceId;
    }

    public ArrayList<Integer> getDeadPlayersOnThisPlaceId() {
        return deadPlayersOnThisPlaceId;
    }

    @Override
    public void addDeadPlayerOnThisPlaceId(final Integer deadPlayerOnThisPlaceId) {
        this.deadPlayersOnThisPlaceId.add(deadPlayerOnThisPlaceId);
        Collections.sort(deadPlayersOnThisPlaceId);
    }

    @Override
    public void removeDeadPlayerOnThisPlaceId(final Integer deadPlayerOnThisPlaceId) {
        this.deadPlayersOnThisPlaceId.remove(deadPlayerOnThisPlaceId);
        this.deadPlayersOnThisPlaceId.trimToSize();
        Collections.sort(deadPlayersOnThisPlaceId);
    }

    @Override
    public void addLivePlayerOnThisPlaceId(final Integer livePlayerOnThisPlaceId) {
        this.livePlayersOnThisPlaceId.add(livePlayerOnThisPlaceId);
        Collections.sort(livePlayersOnThisPlaceId);
    }

    @Override
    public void removeLivePlayerOnThisPlaceId(final Integer livePlayerOnThisPlaceId) {
        this.livePlayersOnThisPlaceId.remove(livePlayerOnThisPlaceId);
        this.livePlayersOnThisPlaceId.trimToSize();
        Collections.sort(livePlayersOnThisPlaceId);
    }

    @Override
    public boolean hasTwoLivePlayersOnThisPlace() {
        return livePlayersOnThisPlaceId.size() == 2;
    }

    public int getNrRoundsParalyzed() {
        return NR_ROUNDS_PARALYZED;
    }

    @Override
    public boolean criticalPower() {
        return false;
    }

    @Override
    public float transferGroundModifier(final Pyromancer pyromancer) {
        return 1f;
    }

    @Override
    public float transferGroundModifier(final Rogue rogue) {
        return 1f;
    }

    @Override
    public float transferGroundModifier(final Wizard wizard) {
        return 1f;
    }

    @Override
    public float transferGroundModifier(final Knight knight) {
        return SPECIAL_LAND_MODIFIER;
    }
}
