package Game;

import java.util.List;

public interface Ground {
    public float transferGroundModifier(Pyromancer pyromancer);
    public float transferGroundModifier(Rogue rogue);
    public float transferGroundModifier(Wizard wizard);
    public float transferGroundModifier(Knight knight);

    public void addPlayerOnThisPlaceId(Integer playerOnThisPlaceId);
    public void removePlayerOnThisPlaceId(Integer playerOnThisPlaceId);
    public boolean hasTwoPlayersOnThisPlace();
    public List<Integer> getPlayersOnThisPlaceId();
}
