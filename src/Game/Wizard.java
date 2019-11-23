package Game;

public class Wizard extends Player{
    private Ability drain = new Drain();
    private Ability deflect = new Deflect();

    public Wizard(final int id){
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
        drain.attack(rogue, ground, attacker);
        deflect.attack(rogue, ground, attacker);
    }
    @Override
    public void fight(Wizard wizard, Ground ground, Player attacker){
        drain.attack(wizard, ground, attacker);
        deflect.attack(wizard, ground, attacker);
    }
    @Override
    public void fight(Knight knight, Ground ground, Player attacker){
        drain.attack(knight, ground, attacker);
        deflect.attack(knight, ground, attacker);
    }
    @Override
    public void fight(Pyromancer pyromancer, Ground ground, Player attacker){
        drain.attack(pyromancer, ground, attacker);
        deflect.attack(pyromancer, ground, attacker);
    }
}
