package game;

import game.angels.Angel;
import game.players.Player;

import java.util.ArrayList;

public class Event implements Subject {
    private ArrayList<Observer> observerList;

    public Event() {
        this.observerList = new ArrayList<>();
    }

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

    @Override
    public void notifyObservers(final Player victim, final Player attacker, final String event) {
        for (Observer observer : observerList){
            observer.update(victim, attacker, event);
        }
    }

    @Override
    public void notifyObservers(Angel angel, String event) {
        for (Observer observer : observerList){
            observer.update(angel, event);
        }
    }

    @Override
    public void notifyObservers(Player player, String event) {
        for (Observer observer : observerList){
            observer.update(player, event);
        }
    }

    public void anEventHappened(final Player player, final Angel angel, final String event){
        notifyObservers(player, angel, event);
    }
    public void anEventHappened(final Player victim, final Player attacker, final String event){
        notifyObservers(victim, attacker, event);
    }

    @Override
    public void anEventHappened(Angel angel, String event) {
        notifyObservers(angel, event);
    }

    @Override
    public void anEventHappened(Player player, String event) {
        notifyObservers(player, event);
    }
}
