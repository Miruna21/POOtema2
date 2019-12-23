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
    public final void registerObserver(final Observer observer) {
        observerList.add(observer);
    }

    @Override
    public final void removeObserver(final Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public final void notifyObservers(final Player player, final Angel angel, final String event) {
        for (Observer observer : observerList) {
            observer.update(player, angel, event);
        }
    }

    @Override
    public final void notifyObservers(final Player victim, final Player attacker,
                                      final String event) {
        for (Observer observer : observerList) {
            observer.update(victim, attacker, event);
        }
    }

    @Override
    public final void notifyObservers(final Angel angel, final String event) {
        for (Observer observer : observerList) {
            observer.update(angel, event);
        }
    }

    @Override
    public final void notifyObservers(final Player player, final String event) {
        for (Observer observer : observerList) {
            observer.update(player, event);
        }
    }

    public final void anEventHappened(final Player player, final Angel angel, final String event) {
        notifyObservers(player, angel, event);
    }
    public final void anEventHappened(final Player victim, final Player attacker,
                                      final String event) {
        notifyObservers(victim, attacker, event);
    }

    @Override
    public final void anEventHappened(final Angel angel, final String event) {
        notifyObservers(angel, event);
    }

    @Override
    public final void anEventHappened(final Player player, final String event) {
        notifyObservers(player, event);
    }
}
