package game;

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
    }

    final int getNrRoundsParalyzed() {
        return nrRoundsParalyzed;
    }
    final void subNrRoundsParalysed(final int passedRound) {
        this.nrRoundsParalyzed -= passedRound;
    }
    final void subNrRoundsIgniteHit(final int passedRound) {
        this.nrRoundsIgniteHit -= passedRound;
    }

    final int getNrRoundsIgniteHit() {
        return nrRoundsIgniteHit;
    }

    final void setNrRoundsIgniteHit(final int nrRoundsIgniteHit) {
        this.nrRoundsIgniteHit = nrRoundsIgniteHit;
    }

    final int getOvertimeDamage() {
        return overtimeDamage;
    }

    final void setOvertimeDamage(final int overtimeDamage) {
        this.overtimeDamage = overtimeDamage;
    }

    final void setNrRoundsParalyzed(final int nrRoundParalyzed) {
        this.nrRoundsParalyzed = nrRoundParalyzed;
    }

   final int getNrBackstabHit() {
        return nrBackstabHit;
    }
    final void addNrBackstabHit(final int nrBackstabHit) {
        this.nrBackstabHit += nrBackstabHit;
    }

    final void setxPos(final int xPos) {
        this.xPos = xPos;
    }

    final void setyPos(final int yPos) {
        this.yPos = yPos;
    }

    final boolean getMovPermission() {
        return movPermission;
    }

    final float getDamageWithoutRaceModifier() {
        return damageWithoutRaceModifier;
    }

    final void setDamageWithoutRaceModifier(final float damageWithoutRaceModifier) {
        this.damageWithoutRaceModifier = damageWithoutRaceModifier;
    }
    final void addDamageWithoutRaceModifier(final float damageWithoutRaceModifier) {
        this.damageWithoutRaceModifier += damageWithoutRaceModifier;
    }

    final int getId() {
        return id;
    }
    final int getxPos() {
        return xPos;
    }
    final int getyPos() {
        return yPos;
    }
    final boolean getLife() {
        return life;
    }

    final void setMovPermission(final boolean movPermission) {
        this.movPermission = movPermission;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }

    private void setLevel(final int level) {
        this.level = level;
    }

    final void setLife(final boolean dead) {
        this.life = dead;
    }

    public final int getHp() {
        return hp;
    }

    final int getXp() {
        return xp;
    }

    public final int getLevel() {
        return level;
    }


    public final void subHp(final int hp) {
        this.hp -= hp;
        if (this.getHp() < 0) {
            this.setLife(false);
        }
    }

    final void gainXp(final int newXp, final int initialHp, final int plusHpPerLevel) {
        this.xp = newXp;
        // daca este cazul, cresc nivelul jucatorului
        int newlevel;
        if ((this.xp > (250 + this.level * 50)) && (this.level < 4)) {
            newlevel = this.level + 1;
            if ((this.xp > (250 + newlevel * 50)) && (newlevel < 4)) {
                newlevel++;
                if ((this.xp > (250 + newlevel * 50)) && (newlevel < 4)) {
                    newlevel++;
                    if ((this.xp > (250 + newlevel + 50)) && (newlevel < 4)) {
                        newlevel++;
                    }
                }
            }
            this.setLevel(newlevel);
            int newHp = initialHp + plusHpPerLevel * newlevel;
            this.setHp(newHp);
        }
    }
    public abstract int getInitialHp();
    public abstract Character getRace();
    public abstract int getPlusHpPerLevel();
    public abstract void isHitBy(Player p, Ground g);

    public abstract float acceptLandModifier(Ground g);

    public abstract void fight(Rogue rogue, Ground ground, Player attacker);
    public abstract void fight(Wizard wizard, Ground ground, Player attacker);
    public abstract void fight(Knight knight, Ground ground, Player attacker);
    public abstract void fight(Pyromancer pyromancer, Ground ground, Player attacker);

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
