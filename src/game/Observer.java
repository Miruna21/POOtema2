package game;

import game.angels.Angel;
import game.players.Player;

public interface Observer {
    void update(Player victim, Player attacker, String event);
    void update(Player player, Angel angel, String event);
}
