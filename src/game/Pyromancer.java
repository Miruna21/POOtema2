package game;

public final class Pyromancer extends Player {
    private static final int INITIALHP = 500;
    private static final int PLUSHPPERLEVEL = 50;
    private Character race = 'P';
    private Ability fireblast = new Fireblast();
    private Ability ignite = new Ignite();

    public Pyromancer(final int id, final int xPos, final int yPos) {
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
        fireblast.attack(rogue, ground, attacker);
        ignite.attack(rogue, ground, attacker);
    }

    @Override
    public void fight(final Wizard wizard, final Ground ground, final Player attacker) {
        fireblast.attack(wizard, ground, attacker);
        ignite.attack(wizard, ground, attacker);
    }

    @Override
    public void fight(final Knight knight, final Ground ground, final Player attacker) {
        fireblast.attack(knight, ground, attacker);
        ignite.attack(knight, ground, attacker);
    }

    @Override
    public void fight(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        fireblast.attack(pyromancer, ground, attacker);
        ignite.attack(pyromancer, ground, attacker);
    }

}
