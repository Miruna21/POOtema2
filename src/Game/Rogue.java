package Game;

public class Rogue extends Player {
    private Ability backstab = new Backstab();
    private Ability paralysis = new Paralysis();

    public Rogue(final int id){
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
        backstab.attack(rogue, ground, attacker);
        paralysis.attack(rogue, ground, attacker);
    }
    @Override
    public void fight(Wizard wizard, Ground ground, Player attacker){
        backstab.attack(wizard, ground, attacker);
        paralysis.attack(wizard, ground, attacker);

    }
    @Override
    public void fight(Knight knight, Ground ground, Player attacker){
        backstab.attack(knight, ground, attacker);
        paralysis.attack(knight, ground, attacker);

    }
    @Override
    public void fight(Pyromancer pyromancer, Ground ground, Player attacker){
        backstab.attack(pyromancer, ground, attacker);
        paralysis.attack(pyromancer, ground, attacker);

    }
}
