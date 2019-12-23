package game.angels;

import game.Subject;
import game.players.*;

public abstract class Angel {
    private int id;
    private int xPos;
    private int yPos;
    private Subject event;

    public Angel(final int id, final int xPos, final int yPos) {
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void setEvent(Subject event) {
        this.event = event;
    }

    public Subject getEvent() {
        return event;
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

    public abstract String getName();

    public abstract void visit(final Knight knight);
    public abstract void visit(final Rogue rogue);
    public abstract void visit(final Wizard wizard);
    public abstract void visit(final Pyromancer pyromancer);
}
