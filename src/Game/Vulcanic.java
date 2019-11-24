package Game;

import java.util.ArrayList;
import java.util.List;

public class Vulcanic implements Ground{
    private List<Integer> playersOnThisPlaceId;
    public Vulcanic(){
        this.playersOnThisPlaceId = new ArrayList<>();
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
    public int transferGroundModifier(Player p) {
        return 0;
    }
}
