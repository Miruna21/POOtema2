package Game;

public class Rogue extends Player {
    private Ability backstab = new Backstab(this);
    private Ability paralysis = new Paralysis(this);

    public Rogue(final int id, final int hp, final int xp, final int level){
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
        backstab.attack(rogue, ground);
        paralysis.attack(rogue, ground);
    }
    @Override
    public void fight(Wizard wizard, Ground ground){
        backstab.attack(wizard, ground);
        paralysis.attack(wizard, ground);

    }
    @Override
    public void fight(Knight knight, Ground ground){
        backstab.attack(knight, ground);
        paralysis.attack(knight, ground);

    }
    @Override
    public void fight(Pyromancer pyromancer, Ground ground){
        backstab.attack(pyromancer, ground);
        paralysis.attack(pyromancer, ground);

    }
}
