package game;

import game.angels.Angel;
import game.players.Player;
import writer.GameOutput;

public final class TheGreatMagician implements Observer, Display {
    private static TheGreatMagician instance = null;
    private GameOutput gameOutput;

    private TheGreatMagician(final GameOutput gameOutput, final Subject subject) {
        this.gameOutput = gameOutput;
        subject.registerObserver(this);
    }
    public static TheGreatMagician getInstance(final GameOutput gameOutput, final Subject subject) {
        if (instance == null) {
            instance = new TheGreatMagician(gameOutput, subject);
        }
        return instance;
    }

    @Override
    public void update(final Player victim, final Player attacker, final String event) {
        if ("fightKilled".equals(event)) {
            printKilledPlayerInTheFight(victim, attacker);
        }
    }

    @Override
    public void update(final Player player, final Angel angel, final String event) {
        switch(event) {
            case "kill": printKilledPlayerByAngel(player);
                            break;
            case "revive": printRevivedPlayerByAngel(player);
                            break;
            case "help": printTheHelpOfAngel(player, angel);
                            break;
            case "complicate": printTheComplicationOfAPlayer(player, angel);
                            break;
            default:
        }
    }

    @Override
    public void update(final Angel angel, final String event) {
        if (event.equals("angelAppears")) {
            printAngelApparition(angel);
        }
    }

    @Override
    public void update(final Player player, final String event) {
        if (event.equals("levelUp")) {
            printLevelUp(player);
        }
    }

    @Override
    public void printKilledPlayerInTheFight(final Player victim, final Player attacker) {
        String outputString = "Player " + victim.getName() + " " + victim.getId()
                + " was killed by " + attacker.getName() + " " + attacker.getId();
        gameOutput.magicianWrites(outputString);
    }

    @Override
    public void printKilledPlayerByAngel(final Player victim) {
        String outputString = "Player " + victim.getName() + " " + victim.getId()
                + " was killed by an angel";
        gameOutput.magicianWrites(outputString);
    }

    @Override
    public void printRevivedPlayerByAngel(final Player player) {
        String outputString = "Player " + player.getName() + " " + player.getId()
                + " was brought to life by an angel";
        gameOutput.magicianWrites(outputString);
    }

    @Override
    public void printLevelUp(final Player player) {
        String outputString = player.getName() + " " + player.getId()
                                + " reached level " + player.getLevel();
        gameOutput.magicianWrites(outputString);
    }

    @Override
    public void printAngelApparition(final Angel angel) {
        String outputString = "Angel " + angel.getName() + " was spawned at "
                                    + angel.getxPos() + " " + angel.getyPos();
        gameOutput.magicianWrites(outputString);
    }

    @Override
    public void printTheHelpOfAngel(final Player player, final Angel angel) {
        String outputString = angel.getName() + " helped " + player.getName()
                                                        + " " + player.getId();
        gameOutput.magicianWrites(outputString);
    }

    @Override
    public void printTheComplicationOfAPlayer(final Player player, final Angel angel) {
        String outputString = angel.getName() + " hit " + player.getName()
                + " " + player.getId();
        gameOutput.magicianWrites(outputString);
    }
}
