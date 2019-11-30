package game;

public final class Knight extends Player {
    private static final int INITIALHP = 900;
    private static final int PLUSHPPERLEVEL = 80;
    private Character race = 'K';
    private Ability slam = new Slam();
    private Ability execute = new Execute();
    public Knight(final int id, final int xPos, final int yPos) {
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
        execute.attack(rogue, ground, attacker);
        slam.attack(rogue, ground, attacker);
    }

    @Override
    public void fight(final Wizard wizard, final Ground ground, final Player attacker) {
        execute.attack(wizard, ground, attacker);
        slam.attack(wizard, ground, attacker);
    }

    @Override
    public void fight(final Knight knight, final Ground ground, final Player attacker) {
        execute.attack(knight, ground, attacker);
        slam.attack(knight, ground, attacker);
    }

    @Override
    public void fight(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        execute.attack(pyromancer, ground, attacker);
        slam.attack(pyromancer, ground, attacker);
    }
}
