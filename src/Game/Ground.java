package Game;
import java.util.ArrayList;

public interface Ground {
    float transferGroundModifier(Pyromancer pyromancer);
    float transferGroundModifier(Rogue rogue);
    float transferGroundModifier(Wizard wizard);
    float transferGroundModifier(Knight knight);
    int getNrRoundsParalyzed();

    void addPlayerOnThisPlaceId(Integer playerOnThisPlaceId);
    void removePlayerOnThisPlaceId(Integer playerOnThisPlaceId);
    boolean hasTwoPlayersOnThisPlace();
    ArrayList<Integer> getPlayersOnThisPlaceId();
}
