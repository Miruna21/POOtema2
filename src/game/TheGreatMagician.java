package game;

import game.angels.Angel;
import game.players.Player;
import writer.GameOutput;

public class TheGreatMagician implements Observer, Display{
    private static TheGreatMagician instance = null;
    private GameOutput gameOutput;

    private TheGreatMagician(final GameOutput gameOutput){
        this.gameOutput = gameOutput;
    }
    public static TheGreatMagician getInstance(final GameOutput gameOutput) {
        if (instance == null) {
            instance = new TheGreatMagician(gameOutput);
        }
        return instance;
    }

    @Override
    public void update(final Player victim, final Player attacker, final String event) {
        switch(event) {
            case "fightKilled" : printKilledPlayerInTheFight(victim, attacker);
            case "levelUp" : printLevelUp(attacker);
            default :
        }
    }

    @Override
    public void update(final Player player, final Angel angel, final String event) {
        switch(event){
            case "angelAppears" : printAngelApparition(angel);
            case "kill" : printKilledPlayerByAngel(player);
            case "revive" : printRevivedPlayerByAngel(player);
            case "help" : printTheHelpOfAngel(player, angel);
            case "complicate" : printTheComplicationOfAPlayer(player, angel);
            default :
        }
    }

    @Override
    public void printKilledPlayerInTheFight(final Player victim, final Player attacker) {
        String outputString = "Player " + victim.getName() + " " + victim.getId()
                + " was killed by " + attacker.getName() + " " + attacker.getId();
        gameOutput.MagicianWrites(outputString);
    }

    @Override
    public void printKilledPlayerByAngel(final Player victim) {
        String outputString = "Player " + victim.getName() + " " + victim.getId()
                + " was killed by an angel";
        gameOutput.MagicianWrites(outputString);
    }

    @Override
    public void printRevivedPlayerByAngel(final Player player) {
        String outputString = "Player " + player.getName() + " " + player.getId()
                + " was brought to life by an angel";
        gameOutput.MagicianWrites(outputString);
    }

    @Override
    public void printLevelUp(final Player player) {
        String outputString = player.getName() + " " + player.getId()
                                + " reached level " + player.getLevel();
        gameOutput.MagicianWrites(outputString);
    }

    @Override
    public void printAngelApparition(final Angel angel) {
        String outputString = "Angel " + angel.getName() + " was spawned at "
                                    + angel.getxPos() + " " + angel.getyPos();
        gameOutput.MagicianWrites(outputString);
    }

    @Override
    public void printTheHelpOfAngel(final Player player, final Angel angel) {
        String outputString = angel.getName() + " helped " + player.getName()
                                                        + " " + player.getId();
        gameOutput.MagicianWrites(outputString);
    }

    @Override
    public void printTheComplicationOfAPlayer(final Player player, final Angel angel) {
        String outputString = angel.getName() + " hit " + player.getName()
                + " " + player.getId();
        gameOutput.MagicianWrites(outputString);
    }
}
