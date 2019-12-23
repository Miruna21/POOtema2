package game;

import game.angels.Angel;
import game.players.Player;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Player player, Angel angel, String event);
    void notifyObservers(Player victim, Player attacker, String event);
    void notifyObservers(Angel angel, String event);
    void notifyObservers(Player player, String event);
    void anEventHappened(Player player, Angel angel, String event);
    void anEventHappened(Player victim, Player attacker, String event);
    void anEventHappened(Angel angel, String event);
    void anEventHappened(Player player, String event);
}
