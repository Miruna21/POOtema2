package game;

import game.angels.Angel;
import game.players.Player;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Player player, Angel angel, String event);
}
