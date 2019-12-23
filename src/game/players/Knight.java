package game.players;

import game.abilities.*;
import game.angels.Angel;
import game.ground.Ground;

public final class Knight extends Player {
    private static final int INITIAL_HP = 900;
    private static final int PLUS_HP_PER_LEVEL = 80;
    private Ability slam = new Slam();
    private Ability execute = new Execute();
    public Knight(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
        this.setHp(INITIAL_HP);
    }
    public Ability getFirstAbility(){
        return execute;
    }
    public Ability getSecondAbility(){
        return slam;
    }
    public Character getRace() {
        return 'K';
    }

    public String getName() {
        return "Knight";
    }

    @Override
    public void choosePlayerFightStrategy() {
        int currentHp = this.getHp();
        int maxLevelHp = this.getInitialHp() + this.getLevel() * this.getPlusHpPerLevel();
        float a = 1/3f * maxLevelHp;
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
    public boolean startFirst() {
        return true;
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

    @Override
    public void accept(Angel angel) {
        angel.visit(this);
    }
}
