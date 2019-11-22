package Game;

public interface Ability {
    public void attack(Rogue rogue, Ground ground);
    public void attack(Wizard wizard, Ground ground);
    public void attack(Knight knight, Ground ground);
    public void attack(Pyromancer pyromancer, Ground ground);
}
