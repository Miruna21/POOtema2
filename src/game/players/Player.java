package game.players;

import constants.AuxiliaryConstants;
import game.Subject;
import game.abilities.FightBehavior;
import game.angels.Angel;
import game.ground.Ground;

public abstract class Player {
    private int id;
    private int hp;
    private int xp;
    private int level;
    private int xPos;
    private int yPos;
    private boolean life;
    private boolean movPermission;
    private float damageWithoutRaceModifier;
    private int nrBackstabHit;
    private int nrRoundsParalyzed;
    private int overtimeDamage;
    private int nrRoundsIgniteHit;
    private FightBehavior fightBehavior;
    private Subject event;

    public Player(final int id, final int xPos, final int yPos) {
        this.id = id;
        this.hp = 0;
        this.xp = 0;
        this.level = 0;
        this.xPos = xPos;
        this.yPos = yPos;
        this.life = true;
        this.movPermission = true;
        this.nrBackstabHit = 0;
        this.nrRoundsParalyzed = 0;
        this.overtimeDamage = 0;
        this.nrRoundsIgniteHit = 0;
        this.fightBehavior = null;
    }

    public final void setEvent(final Subject event) {
        this.event = event;
    }

    public final Subject getEvent() {
        return event;
    }

    public final int getNrRoundsParalyzed() {
        return nrRoundsParalyzed;
    }
    public final void subNrRoundsParalysed(final int passedRound) {
        this.nrRoundsParalyzed -= passedRound;
    }
    public final void subNrRoundsIgniteHit(final int passedRound) {
        this.nrRoundsIgniteHit -= passedRound;
    }

    public final int getNrRoundsIgniteHit() {
        return nrRoundsIgniteHit;
    }

    public final void setNrRoundsIgniteHit(final int nrRoundsIgniteHit) {
        this.nrRoundsIgniteHit = nrRoundsIgniteHit;
    }

    public final int getOvertimeDamage() {
        return overtimeDamage;
    }

    public final void setOvertimeDamage(final int overtimeDamage) {
        this.overtimeDamage = overtimeDamage;
    }

    public final void setNrRoundsParalyzed(final int nrRoundParalyzed) {
        this.nrRoundsParalyzed = nrRoundParalyzed;
    }

   public final int getNrBackstabHit() {
        return nrBackstabHit;
    }
    public final void addNrBackstabHit(final int hit) {
        this.nrBackstabHit += hit;
    }

    public final void setxPos(final int xPos) {
        this.xPos = xPos;
    }

    public final void setyPos(final int yPos) {
        this.yPos = yPos;
    }

    public final boolean getMovPermission() {
        return movPermission;
    }

    public final float getDamageWithoutRaceModifier() {
        return damageWithoutRaceModifier;
    }

    public final void setDamageWithoutRaceModifier(final float damage) {
        this.damageWithoutRaceModifier = damage;
    }
    public final void addDamageWithoutRaceModifier(final float damage) {
        this.damageWithoutRaceModifier += damage;
    }

    public final int getId() {
        return id;
    }
    public final int getxPos() {
        return xPos;
    }
    public final int getyPos() {
        return yPos;
    }
    public final boolean getLife() {
        return life;
    }

    public final void setMovPermission(final boolean movPermission) {
        this.movPermission = movPermission;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }

    private void setLevel(final int level) {
        this.level = level;
    }

    public final void setLife(final boolean dead) {
        this.life = dead;
    }

    public final int getHp() {
        return hp;
    }

    public final int getXp() {
        return xp;
    }

    public final int getLevel() {
        return level;
    }

    public abstract String getName();

    public final void addHp(final int hp2) {
        int sumHp = hp + hp2;
        int maxLeveleHp = this.getInitialHp() + this.getLevel() * this.getPlusHpPerLevel();
        if (sumHp > maxLeveleHp) {
            this.hp = maxLeveleHp;
        } else {
            this.hp += hp2;
        }
    }

    public final void subHp(final int hp2) {
        this.hp -= hp2;
        if (this.getHp() <= 0) {
            this.setLife(false);
        }
    }

    public final void gainXp(final int newXp) {
        this.xp = newXp;
        // daca este cazul, cresc nivelul jucatorului
        int initialHp = this.getInitialHp();
        int plusHpPerLevel = this.getPlusHpPerLevel();
        int newlevel;
        if ((this.xp >= (AuxiliaryConstants.BASE_LEVEL_UP_CONDITION
                + this.level * AuxiliaryConstants.PLUS_LEVEL_UP_CONDITION_PER_LEVEL))
                        && (this.level < AuxiliaryConstants.MAX_LEVEL)) {
            newlevel = this.level + 1;
            this.setLevel(newlevel);
            event.anEventHappened(this, "levelUp");
            if ((this.xp >= (AuxiliaryConstants.BASE_LEVEL_UP_CONDITION
                    + newlevel * AuxiliaryConstants.PLUS_LEVEL_UP_CONDITION_PER_LEVEL))
                            && (newlevel < AuxiliaryConstants.MAX_LEVEL)) {
                newlevel++;
                this.setLevel(newlevel);
                event.anEventHappened(this, "levelUp");
                if ((this.xp >= (AuxiliaryConstants.BASE_LEVEL_UP_CONDITION
                        + newlevel * AuxiliaryConstants.PLUS_LEVEL_UP_CONDITION_PER_LEVEL))
                                && (newlevel < AuxiliaryConstants.MAX_LEVEL)) {
                    newlevel++;
                    this.setLevel(newlevel);
                    event.anEventHappened(this, "levelUp");
                    if ((this.xp >= (AuxiliaryConstants.BASE_LEVEL_UP_CONDITION
                            + newlevel * AuxiliaryConstants.PLUS_LEVEL_UP_CONDITION_PER_LEVEL))
                                    && (newlevel < AuxiliaryConstants.MAX_LEVEL)) {
                        newlevel++;
                        this.setLevel(newlevel);
                        event.anEventHappened(this, "levelUp");
                    }
                }
            }
            int newHp = initialHp + plusHpPerLevel * newlevel;
            this.setHp(newHp);
        }
    }
    public abstract void choosePlayerFightStrategy();
    public final void setFightBehavior(final FightBehavior fightBehavior) {
        this.fightBehavior = fightBehavior;
    }

    public final FightBehavior getFightBehavior() {
        return fightBehavior;
    }

    public abstract void performFightBehavior();

    public abstract int getInitialHp();
    public abstract Character getRace();
    public abstract int getPlusHpPerLevel();
    public abstract void isHitBy(Player p, Ground g);

    public abstract float acceptLandModifier(Ground g);
    public abstract boolean startFirst();

    public abstract void fight(Rogue rogue, Ground ground, Player attacker);
    public abstract void fight(Wizard wizard, Ground ground, Player attacker);
    public abstract void fight(Knight knight, Ground ground, Player attacker);
    public abstract void fight(Pyromancer pyromancer, Ground ground, Player attacker);

    public abstract void accept(Angel angel);

    @Override
    public final String toString() {
        // daca jucatorul e in viata
        if (this.life) {
            return this.getRace() + " " + this.getLevel() + " "
                    + this.getXp() + " " + this.getHp() + " "
                    + this.getxPos() + " " + this.getyPos();
        }
        // daca jucatorul e mort
        return this.getRace() + " " + "dead";
    }
}
