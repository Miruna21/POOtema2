package game;

public final class Rogue extends Player {
    private static final int INITIALHP = 600;
    private static final int PLUSHPPERLEVEL = 40;
    private Character race = 'R';
    private Ability backstab = new Backstab();
    private Ability paralysis = new Paralysis();

    public Rogue(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
        this.setHp(INITIALHP);
    }

    public Character getRace() {
        return race;
    }

    public int getInitialHp() {
        return INITIALHP;
    }

    public int getPlusHpPerLevel() {
        return PLUSHPPERLEVEL;
    }

    @Override
    public void isHitBy(final Player attacker, final Ground ground) {
        attacker.fight(this, ground, attacker);
    }

    @Override
    public float acceptLandModifier(final Ground g) {
        return g.transferGroundModifier(this);
    }

    @Override
    public void fight(final Rogue rogue, final Ground ground, final Player attacker) {
        backstab.attack(rogue, ground, attacker);
        paralysis.attack(rogue, ground, attacker);
    }

    @Override
    public void fight(final Wizard wizard, final Ground ground, final Player attacker) {
        backstab.attack(wizard, ground, attacker);
        paralysis.attack(wizard, ground, attacker);

    }

    @Override
    public void fight(final Knight knight, final Ground ground, final Player attacker) {
        backstab.attack(knight, ground, attacker);
        paralysis.attack(knight, ground, attacker);

    }

    @Override
    public void fight(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        backstab.attack(pyromancer, ground, attacker);
        paralysis.attack(pyromancer, ground, attacker);
    }
}
