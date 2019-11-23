package Game;

public class Knight extends Player {
    private Ability slam = new Slam();
    private Ability execute = new Execute();
    public Knight(final int id){
        super(id);
    }
    @Override
    public void isHitBy(Player attacker, Ground ground) {
        attacker.fight(this, ground, attacker);
    }

    @Override
    public void acceptLandModifier(Ground g) {

    }
    @Override
    public void fight(Rogue rogue, Ground ground, Player attacker){
        slam.attack(rogue, ground, attacker);
        execute.attack(rogue, ground, attacker);
    }
    @Override
    public void fight(Wizard wizard, Ground ground, Player attacker){
        slam.attack(wizard, ground, attacker);
        execute.attack(wizard, ground, attacker);
    }
    @Override
    public void fight(Knight knight, Ground ground, Player attacker){
        slam.attack(knight, ground, attacker);
        execute.attack(knight, ground, attacker);
    }
    @Override
    public void fight(Pyromancer pyromancer, Ground ground, Player attacker){
        slam.attack(pyromancer, ground, attacker);
        execute.attack(pyromancer, ground, attacker);
    }
}
