package Game;

public abstract class Player {
    private int id;
    private int hp;
    private int xp;
    private int level;

    public int getId() {
        return id;
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

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public void AddToHp(int hp){
        this.hp += hp;
    }

    public void subHp(int hp){
        this.hp -= hp;
    }

    public void AddToXp(int xp){
        this.xp = xp;
    }

    public abstract void isHitBy(Player p, Ground g);

    public abstract void acceptLandModifier(Ground g);

    public abstract void fight(Rogue rogue, Ground ground);
    public abstract void fight(Wizard wizard, Ground ground);
    public abstract void fight(Knight knight, Ground ground);
    public abstract void fight(Pyromancer pyromancer, Ground ground);
}
