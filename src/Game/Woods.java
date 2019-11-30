package Game;

import java.util.ArrayList;

public class Woods implements Ground{
    private final static float specialLandModifier = 1.15f;
    private int nrRoundsParalyzed = 6;
    private ArrayList<Integer> playersOnThisPlaceId;
    public Woods(){
        this.playersOnThisPlaceId = new ArrayList<>();
    }

    public ArrayList<Integer> getPlayersOnThisPlaceId() {
        return playersOnThisPlaceId;
    }

    @Override
    public void addPlayerOnThisPlaceId(final Integer playerOnThisPlaceId){
        this.playersOnThisPlaceId.add(playerOnThisPlaceId);
    }

    @Override
    public void removePlayerOnThisPlaceId(final Integer playerOnThisPlaceId) {
        this.playersOnThisPlaceId.remove(Integer.valueOf(playerOnThisPlaceId));
        this.playersOnThisPlaceId.trimToSize();
    }

    @Override
    public boolean hasTwoPlayersOnThisPlace() {
        if (playersOnThisPlaceId.size() == 2){
            return true;
        }
        return false;
    }

    public int getNrRoundsParalyzed() {
        return nrRoundsParalyzed;
    }

    @Override
    public float transferGroundModifier(Pyromancer pyromancer) {
        return 1f;
    }

    @Override
    public float transferGroundModifier(Rogue rogue) {
        return specialLandModifier;
    }

    @Override
    public float transferGroundModifier(Wizard wizard) {
        return 1f;
    }

    @Override
    public float transferGroundModifier(Knight knight) {
        return 1f;
    }
}
