package Game;

public interface Ability {
    void attack(Rogue rogue, Ground ground, Player attacker);
    void attack(Wizard wizard, Ground ground, Player attacker);
    void attack(Knight knight, Ground ground, Player attacker);
    void attack(Pyromancer pyromancer, Ground ground, Player attacker);
}
