package Game;

public interface Ground {
    public int transferGroundModifier(Player p);
    public void addPlayerOnThisPlaceId(Integer playerOnThisPlaceId);
    public void removePlayerOnThisPlaceId(Integer playerOnThisPlaceId);
}
