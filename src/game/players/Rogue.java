package game.players;

import game.abilities.*;
import game.angels.Angel;
import game.ground.Ground;

public final class Rogue extends Player {
    private static final int INITIAL_HP = 600;
    private static final int PLUS_HP_PER_LEVEL = 40;
    private Ability backstab = new Backstab();
    private Ability paralysis = new Paralysis();

    public Rogue(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
        this.setHp(INITIAL_HP);
    }

    public Ability getFirstAbility() {
        return backstab;
    }
    public Ability getSecondAbility() {
        return paralysis;
    }

    public Character getRace() {
        return 'R';
    }

    public String getName() {
        return "Rogue";
    }

    @Override
    public void choosePlayerFightStrategy() {
        int currentHp = this.getHp();
        int maxLevelHp = this.getInitialHp() + this.getLevel() * this.getPlusHpPerLevel();
        float a = 1 / 7f * maxLevelHp;
        float b =  1 / 5f * maxLevelHp;
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

    @Override
    public void accept(final Angel angel) {
        angel.visit(this);
    }
}
