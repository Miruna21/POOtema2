package Game;

public class Pyromancer extends Player{
    private final static int initialHp = 500;
    private final static int plusHpPerLevel = 50;
    private Ability fireblast = new Fireblast();
    private Ability ignite = new Ignite();

    public Pyromancer(final int id, final int xPos, final int yPos){
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
        fireblast.attack(rogue, ground, attacker);
        ignite.attack(rogue, ground, attacker);
    }

    @Override
    public void fight(Wizard wizard, Ground ground, Player attacker){
        fireblast.attack(wizard, ground, attacker);
        ignite.attack(wizard, ground, attacker);
    }

    @Override
    public void fight(Knight knight, Ground ground, Player attacker){
        fireblast.attack(knight, ground, attacker);
        ignite.attack(knight, ground, attacker);
    }

    @Override
    public void fight(Pyromancer pyromancer, Ground ground, Player attacker){
        fireblast.attack(pyromancer, ground, attacker);
        ignite.attack(pyromancer, ground, attacker);
    }

}
