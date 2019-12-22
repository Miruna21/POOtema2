package game;

import game.angels.Angel;
import game.players.Player;

public interface Observer {
    void printKilledPlayerInTheFight(Player victim, Player attacker);
    void printKilledPlayerByAngel(Player victim, Angel angel);
    void printRevivedPlayerByAngel(Player player, Angel angel);
    void printLevelUp(Player player);
    void printAngelApparition(Angel angel);
    void printTheHelpOfAngel(Player player, Angel angel);
    void printThePreventionOfAPlayer(Player player, Angel angel);
}
