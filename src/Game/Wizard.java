package Game;

public class Wizard extends Player{
    private final static int initialHp = 400;
    private final static int plusHpPerLevel = 30;
    private Ability drain = new Drain();
    private Ability deflect = new Deflect();

    public Wizard(final int id, final int xPos, final int yPos){
        super(id, xPos, yPos);
        this.setHp(initialHp);
    }

    public static int getInitialHp() {
        return initialHp;
    }

    public static int getPlusHpPerLevel() {
        return plusHpPerLevel;
    }

    @Override
    public void isHitBy(Player attacker, Ground ground) {
        attacker.fight(this, ground, attacker);
    }

    @Override
    public float acceptLandModifier(Ground g) {
        return g.transferGroundModifier(this);
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
