package Game;

public class Pyromancer extends Player{
    private Ability fireblast = new Fireblast(this);
    private Ability ignite = new Ignite(this);

    public Pyromancer(final int id, final int hp, final int xp, final int level){
        super(id, hp, xp, level);
    }
    @Override
    public void isHitBy(Player p, Ground ground) {
        p.fight(this, ground);
    }
    @Override
    public void fight(Rogue rogue, Ground ground){
        fireblast.attack(rogue, ground);
        ignite.attack(rogue, ground);
    }
    @Override
    public void fight(Wizard wizard, Ground ground){
        fireblast.attack(wizard, ground);
        ignite.attack(wizard, ground);
    }
    @Override
    public void fight(Knight knight, Ground ground){
        fireblast.attack(knight, ground);
        ignite.attack(knight, ground);
    }
    @Override
    public void fight(Pyromancer pyromancer, Ground ground){
        fireblast.attack(pyromancer, ground);
        ignite.attack(pyromancer, ground);
    }
    @Override
    public void acceptLandModifier(Ground g) {

    }

}
