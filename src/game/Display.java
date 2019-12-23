package game;

import game.angels.Angel;
import game.players.Player;

interface Display {
    void printKilledPlayerInTheFight(Player victim, Player attacker);
    void printKilledPlayerByAngel(Player victim);
    void printRevivedPlayerByAngel(Player player);
    void printLevelUp(Player player);
    void printAngelApparition(Angel angel);
    void printTheHelpOfAngel(Player player, Angel angel);
    void printTheComplicationOfAPlayer(Player player, Angel angel);
}
