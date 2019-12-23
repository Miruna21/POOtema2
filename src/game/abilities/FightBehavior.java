package game.abilities;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public interface FightBehavior {
    void changeFightPowers(Knight knight);
    void changeFightPowers(Rogue rogue);
    void changeFightPowers(Wizard wizard);
    void changeFightPowers(Pyromancer pyromancer);
}
