package Game;

public interface Ability {
    public void attack(Rogue rogue, Ground ground, Player attacker);
    public void attack(Wizard wizard, Ground ground, Player attacker);
    public void attack(Knight knight, Ground ground, Player attacker);
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker);
}
