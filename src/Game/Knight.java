package Game;

public class Knight extends Player {
    private Ability slam = new Slam(this);
    private Ability execute = new Execute(this);
    public Knight(final int id, final int hp, final int xp, final int level){
        super(id, hp, xp, level);
    }
    @Override
    public void isHitBy(Player p, Ground ground) {
        p.fight(this, ground);
    }

    @Override
    public void acceptLandModifier(Ground g) {

    }
    @Override
    public void fight(Rogue rogue, Ground ground){
        slam.attack(rogue, ground);
        execute.attack(rogue, ground);
    }
    @Override
    public void fight(Wizard wizard, Ground ground){
        slam.attack(wizard, ground);
        execute.attack(wizard, ground);
    }
    @Override
    public void fight(Knight knight, Ground ground){
        slam.attack(knight, ground);
        execute.attack(knight, ground);
    }
    @Override
    public void fight(Pyromancer pyromancer, Ground ground){
        slam.attack(pyromancer, ground);
        execute.attack(pyromancer, ground);
    }
}
