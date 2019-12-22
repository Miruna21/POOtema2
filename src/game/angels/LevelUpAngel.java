package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class LevelUpAngel extends Angel {
    private static final float DAMAGE_MODIFIER_FOR_KNIGHT = 0.1f;
    private static final float DAMAGE_MODIFIER_FOR_PYROMANCER = 0.2f;
    private static final float DAMAGE_MODIFIER_FOR_ROGUE = 0.15f;
    private static final float DAMAGE_MODIFIER_FOR_WIZARD = 0.25f;

    public LevelUpAngel(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "LevelUpAngel";
    }

    @Override
    public void visit(Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()){
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            knight.getFirstAbility().changeKnightVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
            knight.getSecondAbility().changeKnightVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            // TODO
        }
    }

    @Override
    public void visit(Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()){
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            rogue.getFirstAbility().changeRogueVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
            rogue.getSecondAbility().changeRogueVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            // TODO
        }
    }

    @Override
    public void visit(Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()){
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            wizard.getFirstAbility().changeWizardVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
            wizard.getSecondAbility().changeWizardVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            // TODO
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()){
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            pyromancer.getFirstAbility().changePyromancerVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
            pyromancer.getSecondAbility().changePyromancerVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
            // ofer Xp jucatorului pentru a trece la nivelul urmator
            // TODO
        }
    }
}
