package game.angels;

import game.Observer;
import game.Subject;
import game.players.*;

import java.util.ArrayList;

public abstract class Angel implements Subject {
    private int id;
    private int xPos;
    private int yPos;
    private ArrayList<Observer> observerList;

    public Angel(final int id, final int xPos, final int yPos) {
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
        this.observerList = new ArrayList<>();
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

    @Override
    public void registerObserver(final Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(final Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(final Player player, final Angel angel, final String event) {
        for (Observer observer : observerList){
            observer.update(player, angel, event);
        }
    }

    public void anEventHappened(Player player, Angel angel, String event){
        notifyObservers(player, angel, event);
    }
}
