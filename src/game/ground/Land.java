package game.ground;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

import java.util.ArrayList;

public final class Land implements Ground {
    private static final float SPECIAL_LAND_MODIFIER = 1.15f;
    private static final int NR_ROUNDS_PARALYZED = 3;
    private ArrayList<Integer> playersOnThisPlaceId;
    private ArrayList<Integer> angelsOnThisPlaceId;

    public Land() {
        this.playersOnThisPlaceId = new ArrayList<>();
        this.angelsOnThisPlaceId = new ArrayList<>();
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

    public ArrayList<Integer> getAngelsOnThisPlaceId() {
        return angelsOnThisPlaceId;
    }

    public void addAngelsOnThisPlaceId(final Integer angelOnThisPlaceId) {
        this.angelsOnThisPlaceId.add(angelOnThisPlaceId);
    }

    public void removeAngelOnThisPlaceId(final Integer angelOnThisPlaceId) {
        this.angelsOnThisPlaceId.remove(angelOnThisPlaceId);
        this.angelsOnThisPlaceId.trimToSize();
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
