package Game;
import java.util.List;

public interface Ground {
    float transferGroundModifier(Pyromancer pyromancer);
    float transferGroundModifier(Rogue rogue);
    float transferGroundModifier(Wizard wizard);
    float transferGroundModifier(Knight knight);

    void addPlayerOnThisPlaceId(Integer playerOnThisPlaceId);
    void removePlayerOnThisPlaceId(Integer playerOnThisPlaceId);
    boolean hasTwoPlayersOnThisPlace();
    List<Integer> getPlayersOnThisPlaceId();
}
