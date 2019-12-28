package game.angels;

import constants.AuxiliaryConstants;
import game.players.Knight;
import game.players.Pyromancer;
import game.players.Wizard;
import game.players.Rogue;
import game.players.Player;

public final class LevelUpAngel extends Angel {
    private static final float DAMAGE_MODIFIER_FOR_KNIGHT = 0.1f;
    private static final float DAMAGE_MODIFIER_FOR_PYROMANCER = 0.2f;
    private static final float DAMAGE_MODIFIER_FOR_ROGUE = 0.15f;
    private static final float DAMAGE_MODIFIER_FOR_WIZARD = 0.25f;

    public LevelUpAngel(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "LevelUpAngel";
    }

    @Override
    public boolean visitLivePlayers() {
        return true;
    }

    @Override
    public void visit(final Knight knight) {
        // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
        knight.getFirstAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
        knight.getSecondAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
        // anunt magicianul de ajutorul ingerului
        knight.getEvent().anEventHappened(knight, this, "help");
        // ofer Xp jucatorului pentru a trece la nivelul urmator
        knight.gainXp(getNewXp(knight));
    }

    @Override
    public void visit(final Rogue rogue) {
        // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
        rogue.getFirstAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
        rogue.getSecondAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
        // anunt magicianul de ajutorul ingerului
        rogue.getEvent().anEventHappened(rogue, this, "help");
        // ofer Xp jucatorului pentru a trece la nivelul urmator
        rogue.gainXp(getNewXp(rogue));
    }

    @Override
    public void visit(final Wizard wizard) {
        // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
        wizard.getFirstAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
        wizard.getSecondAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
        // anunt magicianul de ajutorul ingerului
        wizard.getEvent().anEventHappened(wizard, this, "help");
        // ofer Xp jucatorului pentru a trece la nivelul urmator
        wizard.gainXp(getNewXp(wizard));
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
        pyromancer.getFirstAbility().
                    changeAllVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
        pyromancer.getSecondAbility().
                    changeAllVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
        // anunt magicianul de ajutorul ingerului
        pyromancer.getEvent().anEventHappened(pyromancer, this, "help");
        // ofer Xp jucatorului pentru a trece la nivelul urmator
        pyromancer.gainXp(getNewXp(pyromancer));
    }
    private int getNewXp(final Player player) {
        return AuxiliaryConstants.BASE_LEVEL_UP_CONDITION
                + (player.getLevel()) * AuxiliaryConstants.PLUS_LEVEL_UP_CONDITION_PER_LEVEL;
    }
}
