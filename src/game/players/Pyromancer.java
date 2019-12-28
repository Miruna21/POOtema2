package game.players;

import game.abilities.Fireblast;
import game.abilities.Ignite;
import game.abilities.Ability;
import game.abilities.DefenceFightBehavior;
import game.abilities.AtackFightBehavior;
import game.angels.Angel;
import game.ground.Ground;

public final class Pyromancer extends Player {
    private static final int INITIAL_HP = 500;
    private static final int PLUS_HP_PER_LEVEL = 50;
    private static final float MAX_HP_LIMIT = 1 / 3f;
    private static final float MIN_HP_LIMIT = 1 / 4f;

    private Ability fireblast = new Fireblast();
    private Ability ignite = new Ignite();

    public Pyromancer(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
        this.setHp(INITIAL_HP);
    }

    public Ability getFirstAbility() {
        return fireblast;
    }
    public Ability getSecondAbility() {
        return ignite;
    }

    public Character getRace() {
        return 'P';
    }

    public String getName() {
        return "Pyromancer";
    }

    @Override
    public void choosePlayerFightStrategy() {
        int currentHp = this.getHp();
        int maxLevelHp = this.getInitialHp() + this.getLevel() * this.getPlusHpPerLevel();
        float a = MIN_HP_LIMIT * maxLevelHp;
        float b = MAX_HP_LIMIT * maxLevelHp;
        if (currentHp < a) {
            this.setFightBehavior(new DefenceFightBehavior());
            this.performFightBehavior();
        } else if ((currentHp > a) && (currentHp < b)) {
            this.setFightBehavior(new AtackFightBehavior());
            this.performFightBehavior();
        }

    }

    @Override
    public void performFightBehavior() {
        this.getFightBehavior().changeFightPowers(this);
    }

    @Override
    public boolean startFirst() {
        return true;
    }

    public int getInitialHp() {
        return INITIAL_HP;
    }

    public int getPlusHpPerLevel() {
        return PLUS_HP_PER_LEVEL;
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

    @Override
    public void accept(final Angel angel) {
        angel.visit(this);
    }
}
