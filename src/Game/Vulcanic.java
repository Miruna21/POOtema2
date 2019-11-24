package Game;

import java.util.ArrayList;
import java.util.List;

public class Vulcanic implements Ground{
    private final static float specialLandModifier = 0.1f;
    private List<Integer> playersOnThisPlaceId;
    public Vulcanic(){
        this.playersOnThisPlaceId = new ArrayList<>();
    }

    public List<Integer> getPlayersOnThisPlaceId() {
        return playersOnThisPlaceId;
    }

    @Override
    public void addPlayerOnThisPlaceId(final Integer playerOnThisPlaceId){
        this.playersOnThisPlaceId.add(playerOnThisPlaceId);
    }

    @Override
    public void removePlayerOnThisPlaceId(Integer playerOnThisPlaceId) {
        this.playersOnThisPlaceId.remove(playerOnThisPlaceId);
    }

    @Override
    public boolean hasTwoPlayersOnThisPlace() {
        if (playersOnThisPlaceId.size() == 2){
            return true;
        }
        return false;
    }

    @Override
    public float transferGroundModifier(Pyromancer pyromancer) {
        return specialLandModifier;
    }

    @Override
    public float transferGroundModifier(Knight knight) {
        return 1f;
    }

    @Override
    public float transferGroundModifier(Wizard wizard) {
        return 1f;
    }

    @Override
    public float transferGroundModifier(Rogue rogue) {
        return 1f;
    }
}
