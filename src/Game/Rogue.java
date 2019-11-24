package Game;

public class Rogue extends Player {
    private final static int initialHp = 600;
    private final static int plusHpPerLevel = 40;
    private Ability backstab = new Backstab();
    private Ability paralysis = new Paralysis();

    public Rogue(final int id, final int xPos, final int yPos){
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
