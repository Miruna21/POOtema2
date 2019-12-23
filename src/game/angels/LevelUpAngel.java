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
            knight.getFirstAbility().changeKnightVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
            knight.getSecondAbility().changeKnightVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            if (knight.getLevel() < AuxiliaryConstants.MAX_LEVEL) {
                int plusXp = getPlusXp(knight);
                knight.gainXp(plusXp);
            }
            // anunt magicianul de ajutorul ingerului
            knight.getEvent().anEventHappened(knight, this, "help");
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()) {
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            rogue.getFirstAbility().changeRogueVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
            rogue.getSecondAbility().changeRogueVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            if (rogue.getLevel() < AuxiliaryConstants.MAX_LEVEL) {
                int plusXp = getPlusXp(rogue);
                rogue.gainXp(plusXp);
            }
            // anunt magicianul de ajutorul ingerului
            rogue.getEvent().anEventHappened(rogue, this, "help");
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()) {
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            wizard.getFirstAbility().changeWizardVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
            wizard.getSecondAbility().changeWizardVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            if (wizard.getLevel() < AuxiliaryConstants.MAX_LEVEL) {
                int plusXp = getPlusXp(wizard);
                wizard.gainXp(plusXp);
            }
            // anunt magicianul de ajutorul ingerului
            wizard.getEvent().anEventHappened(wizard, this, "help");
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()) {
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            pyromancer.getFirstAbility().
                    changePyromancerVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
            pyromancer.getSecondAbility().
                    changePyromancerVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            if (pyromancer.getLevel() < AuxiliaryConstants.MAX_LEVEL) {
                int plusXp = getPlusXp(pyromancer);
                pyromancer.gainXp(plusXp);
            }
            // anunt magicianul de ajutorul ingerului
            pyromancer.getEvent().anEventHappened(pyromancer, this, "help");
        }
    }
    private int getPlusXp(final Player player) {
        int newXp = AuxiliaryConstants.BASE_LEVEL_UP_CONDITION
                + (player.getLevel() + 1) * AuxiliaryConstants.PLUS_LEVEL_UP_CONDITION_PER_LEVEL;
        return newXp - player.getXp();
    }
}
