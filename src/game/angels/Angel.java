package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public abstract class Angel {
    private int id;
    private int xPos;
    private int yPos;

    public Angel(int id, int xPos, int yPos) {
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getId() {
        return id;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public abstract void visit(Knight knight);
    public abstract void visit(Rogue rogue);
    public abstract void visit(Wizard wizard);
    public abstract void visit(Pyromancer pyromancer);

}
