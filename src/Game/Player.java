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
    private int damageWithoutRaceModifier;
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

    public int getDamageWithoutRaceModifier() {
        return damageWithoutRaceModifier;
    }

    public void setDamageWithoutRaceModifier(int damageWithoutRaceModifier) {
        this.damageWithoutRaceModifier = damageWithoutRaceModifier;
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

    public void setHp(final int hp){
        this.hp = hp;
        // daca este cazul, cresc nivelul jucatorului
        levelUp();
    }
    public void setRound(final int round){
        this.round = round;
    }
    public void setMovPermission(boolean movPermission){
        this.movPermission = movPermission;
    }
    public void levelUp(){

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

    public void addHp(int hp){
        this.hp += hp;
    }

    public void subHp(int hp){
        this.hp -= hp;
        if (this.getHp() < 0){
            this.setLife(false);
        }
    }

    public void GainXp(int xp){
        this.xp = xp;
    }

    public abstract void isHitBy(Player p, Ground g);

    public abstract float acceptLandModifier(Ground g);

    public abstract void fight(Rogue rogue, Ground ground, Player attacker);
    public abstract void fight(Wizard wizard, Ground ground, Player attacker);
    public abstract void fight(Knight knight, Ground ground, Player attacker);
    public abstract void fight(Pyromancer pyromancer, Ground ground, Player attacker);
}
