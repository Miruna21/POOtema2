package Game;

public abstract class Player {
    private int id;
    private int hp;
    private int xp;
    private int level;
    private boolean life;

    public Player(final int id) {
        this.id = id;
        this.hp = 0;
        this.xp = 0;
        this.level = 0;
        this.life = true;
    }

    public int getId() {
        return id;
    }
    public boolean getLife(){
        return life;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setXp(int xp) {
        this.xp = xp;
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
    }

    public void GainXp(int xp){
        this.xp = xp;
    }

    public abstract void isHitBy(Player p, Ground g);

    public abstract void acceptLandModifier(Ground g);

    public abstract void fight(Rogue rogue, Ground ground, Player attacker);
    public abstract void fight(Wizard wizard, Ground ground, Player attacker);
    public abstract void fight(Knight knight, Ground ground, Player attacker);
    public abstract void fight(Pyromancer pyromancer, Ground ground, Player attacker);
}
