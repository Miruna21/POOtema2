package game.angels;

import constants.AuxiliaryConstants;
import game.players.*;

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
    public void visit(final Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()) {
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            knight.getFirstAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
            knight.getSecondAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
            // anunt magicianul de ajutorul ingerului
            knight.getEvent().anEventHappened(knight, this, "help");
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            if (knight.getLevel() < AuxiliaryConstants.MAX_LEVEL) {
                knight.gainXp(getNewXp(knight));
            }
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()) {
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            rogue.getFirstAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
            rogue.getSecondAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
            // anunt magicianul de ajutorul ingerului
            rogue.getEvent().anEventHappened(rogue, this, "help");
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            if (rogue.getLevel() < AuxiliaryConstants.MAX_LEVEL) {
                rogue.gainXp(getNewXp(rogue));
            }
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()) {
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            wizard.getFirstAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
            wizard.getSecondAbility().changeAllVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
            // anunt magicianul de ajutorul ingerului
            wizard.getEvent().anEventHappened(wizard, this, "help");
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            if (wizard.getLevel() < AuxiliaryConstants.MAX_LEVEL) {
                wizard.gainXp(getNewXp(wizard));
            }
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()) {
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            pyromancer.getFirstAbility().
                    changeAllVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
            pyromancer.getSecondAbility().
                    changeAllVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
            // anunt magicianul de ajutorul ingerului
            pyromancer.getEvent().anEventHappened(pyromancer, this, "help");
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            if (pyromancer.getLevel() < AuxiliaryConstants.MAX_LEVEL) {
                pyromancer.gainXp(getNewXp(pyromancer));
            }
        }
    }
    private int getNewXp(final Player player) {
        return AuxiliaryConstants.BASE_LEVEL_UP_CONDITION
                + (player.getLevel()) * AuxiliaryConstants.PLUS_LEVEL_UP_CONDITION_PER_LEVEL;
    }
}
