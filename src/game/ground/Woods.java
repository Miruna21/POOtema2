package game.ground;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

import java.util.ArrayList;

public final class Woods implements Ground {
    private static final float SPECIAL_LAND_MODIFIER = 1.15f;
    private static final int NR_ROUNDS_PARALYZED = 6;
    private ArrayList<Integer> playersOnThisPlaceId;
    public Woods() {
        this.playersOnThisPlaceId = new ArrayList<>();
    }

    public ArrayList<Integer> getPlayersOnThisPlaceId() {
        return playersOnThisPlaceId;
    }

    @Override
    public void addPlayerOnThisPlaceId(final Integer playerOnThisPlaceId) {
        this.playersOnThisPlaceId.add(playerOnThisPlaceId);
    }

    @Override
    public void removePlayerOnThisPlaceId(final Integer playerOnThisPlaceId) {
        this.playersOnThisPlaceId.remove(playerOnThisPlaceId);
        this.playersOnThisPlaceId.trimToSize();
    }

    @Override
    public boolean hasTwoPlayersOnThisPlace() {
        return playersOnThisPlaceId.size() == 2;
    }

    public int getNrRoundsParalyzed() {
        return NR_ROUNDS_PARALYZED;
    }

    @Override
    public boolean criticalPower() {
        return true;
    }

    @Override
    public float transferGroundModifier(final Pyromancer pyromancer) {
        return 1f;
    }

    @Override
    public float transferGroundModifier(final Rogue rogue) {
        return SPECIAL_LAND_MODIFIER;
    }

    @Override
    public float transferGroundModifier(final Wizard wizard) {
        return 1f;
    }

    @Override
    public float transferGroundModifier(final Knight knight) {
        return 1f;
    }
}
