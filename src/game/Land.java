package game;

import java.util.ArrayList;

public final class Land implements Ground {
    private static final float SPECIAL_LAND_MODIFIER = 1.15f;
    private static final int NR_ROUNDS_PARALYZED = 3;
    private ArrayList<Integer> playersOnThisPlaceId;
    public Land() {
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
        if (playersOnThisPlaceId.size() == 2) {
            return true;
        }
        return false;
    }

    public int getNrRoundsParalyzed() {
        return NR_ROUNDS_PARALYZED;
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
