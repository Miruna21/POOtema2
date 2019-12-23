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

    public final void setEvent(final Subject event) {
        this.event = event;
    }

    public final Subject getEvent() {
        return event;
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

    public abstract String getName();

    public abstract void visit(Knight knight);
    public abstract void visit(Rogue rogue);
    public abstract void visit(Wizard wizard);
    public abstract void visit(Pyromancer pyromancer);
}
