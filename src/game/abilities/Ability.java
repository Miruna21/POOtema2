package game.abilities;

import game.ground.Ground;
import game.players.Knight;
import game.players.Rogue;
import game.players.Wizard;
import game.players.Pyromancer;
import game.players.Player;

public interface Ability {
    void attack(Rogue rogue, Ground ground, Player attacker);
    void attack(Wizard wizard, Ground ground, Player attacker);
    void attack(Knight knight, Ground ground, Player attacker);
    void attack(Pyromancer pyromancer, Ground ground, Player attacker);
}
