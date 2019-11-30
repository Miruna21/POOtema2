package Game;

public abstract class Player {
    private int id;
    private int hp;
    private int xp;
    private int level;
    private int xPos;
    private int yPos;
    private boolean life;
    private int round;
    private boolean movPermission;
    private float damageWithoutRaceModifier;
    private int nrBackstabHit;
    private int nrRoundParalyzed;
    private int overtimeDamage;

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
        this.nrRoundParalyzed = 0;
        this.overtimeDamage = 0;
    }

    public int getNrRoundParalyzed() {
        return nrRoundParalyzed;
    }
    public void subNrRoundParalysed(int passedRound){
        this.nrRoundParalyzed -= passedRound;
    }
    public int getOvertimeDamage() {
        return overtimeDamage;
    }

    public void setOvertimeDamage(int overtimeDamage) {
        this.overtimeDamage = overtimeDamage;
    }

    public void setNrRoundParalyzed(int nrRoundParalyzed) {
        this.nrRoundParalyzed = nrRoundParalyzed;
    }

    public int getNrBackstabHit() {
        return nrBackstabHit;
    }

    public void addNrBackstabHit(int nrBackstabHit) {
        this.nrBackstabHit += nrBackstabHit;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public boolean getMovPermission() {
        return movPermission;
    }

    public float getDamageWithoutRaceModifier() {
        return damageWithoutRaceModifier;
    }

    public void setDamageWithoutRaceModifier(float damageWithoutRaceModifier) {
        this.damageWithoutRaceModifier = damageWithoutRaceModifier;
    }
    public void addDamageWithoutRaceModifier(float damageWithoutRaceModifier) {
        this.damageWithoutRaceModifier += damageWithoutRaceModifier;
    }

    public int getId() {
        return id;
    }
    public int getxPos(){
        return xPos;
    }
    public int getyPos(){
        return yPos;
    }
    public boolean getLife(){
        return life;
    }
    public int getRound(){
        return round;
    }

    public void setRound(final int round){
        this.round = round;
    }
    public void setMovPermission(boolean movPermission){
        this.movPermission = movPermission;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLife(boolean dead){
        this.life = dead;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }


    public void subHp(int hp){
        this.hp -= hp;
        if (this.getHp() < 0){
            this.setLife(false);
        }
    }

    public void gainXp(final int newXp, final int initialHp, final int plusHpPerLevel){
        this.xp = newXp;
        // daca este cazul, cresc nivelul jucatorului
        int newlevel;
        if ((this.xp > (250 + this.level * 50)) && (this.level < 4)){
            newlevel = this.level + 1;
            if ((this.xp > (250 + newlevel * 50)) && (newlevel < 4)){
                newlevel++;
                if ((this.xp > (250 + newlevel * 50)) && (newlevel < 4)){
                    newlevel++;
                    if ((this.xp > (250 + newlevel + 50)) && (newlevel < 4)){
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
    public String toString() {
        // daca jucatorul e in viata
        if (this.life){
            return this.getRace() + " " + this.getLevel() + " "
                    + this.getXp() + " " + this.getHp() + " "
                    + this.getxPos() + " " + this.getyPos();
        }
        // daca jucatorul e mort
        return this.getRace() + " " + "dead";
    }
}
