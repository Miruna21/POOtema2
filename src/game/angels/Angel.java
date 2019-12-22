package game.angels;

import game.Observer;
import game.Subject;
import game.players.*;

import java.util.ArrayList;

public abstract class Angel implements Subject{
    private int id;
    private int xPos;
    private int yPos;
    private ArrayList<Observer> observerList;

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

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList){
            observer.
        }
    }

    public void anAngelAppears(Angel angel){

    }
    public void angelHelpsAPlayer(Angel angel, Player player){

    }
    public void angelComplicatesAPlayer(Angel angel, Player player){

    }
    public void angelKillsAPlayer(Angel angel, Player player){

    }
    public void angelRevivesAPlayer(Angel angel, Player player){

    }
}
