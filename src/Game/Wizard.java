package Game;

public class Wizard extends Player{
    private Ability drain = new Drain(this);
    private Ability deflect = new Deflect(this);
    @Override
    public void isHitBy(Player p, Ground ground) {
        p.fight(this, ground);
    }

    @Override
    public void acceptLandModifier(Ground g) {

    }
    @Override
    public void fight(Rogue rogue, Ground ground){
        drain.attack(rogue, ground);
        deflect.attack(rogue, ground);
    }
    @Override
    public void fight(Wizard wizard, Ground ground){
        drain.attack(wizard, ground);
        deflect.attack(wizard, ground);
    }
    @Override
    public void fight(Knight knight, Ground ground){
        drain.attack(knight, ground);
        deflect.attack(knight, ground);
    }
    @Override
    public void fight(Pyromancer pyromancer, Ground ground){
        drain.attack(pyromancer, ground);
        deflect.attack(pyromancer, ground);
    }
}
