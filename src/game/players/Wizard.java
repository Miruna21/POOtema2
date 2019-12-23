package game.players;

import game.abilities.*;
import game.angels.Angel;
import game.ground.Ground;

public final class Wizard extends Player {
    private static final int INITIAL_HP = 400;
    private static final int PLUS_HP_PER_LEVEL = 30;
    private Ability drain = new Drain();
    private Ability deflect = new Deflect();

    public Wizard(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
        this.setHp(INITIAL_HP);
    }

    public Ability getFirstAbility(){
        return drain;
    }
    public Ability getSecondAbility(){
        return deflect;
    }

    public Character getRace() {
        return 'W';
    }

    public String getName() {
        return "Wizard";
    }

    @Override
    public void choosePlayerFightStrategy() {
        int currentHp = this.getHp();
        int maxLevelHp = this.getInitialHp() + this.getLevel() * this.getPlusHpPerLevel();
        float a = 1/4f * maxLevelHp;
        float b =  1/2f * maxLevelHp;
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
        return false;
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
        drain.attack(rogue, ground, attacker);
        deflect.attack(rogue, ground, attacker);
    }

    @Override
    public void fight(final Wizard wizard, final Ground ground, final Player attacker) {
        drain.attack(wizard, ground, attacker);
        deflect.attack(wizard, ground, attacker);
    }

    @Override
    public void fight(final Knight knight, final Ground ground, final Player attacker) {
        drain.attack(knight, ground, attacker);
        deflect.attack(knight, ground, attacker);
    }

    @Override
    public void fight(final Pyromancer pyromancer, final Ground ground, final Player attacker) {
        drain.attack(pyromancer, ground, attacker);
        deflect.attack(pyromancer, ground, attacker);
    }

    @Override
    public void accept(Angel angel) {
        angel.visit(this);
    }
}
