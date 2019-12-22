package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class SmallAngel extends Angel {
    private static final float DAMAGE_MODIFIER_FOR_KNIGHT = 0.1f;
    private static final float DAMAGE_MODIFIER_FOR_PYROMANCER = 0.15f;
    private static final float DAMAGE_MODIFIER_FOR_ROGUE = 0.05f;
    private static final float DAMAGE_MODIFIER_FOR_WIZARD = 0.1f;

    private static final int HP_MODIFIER_FOR_KNIGHT = 10;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 15;
    private static final int HP_MODIFIER_FOR_ROGUE = 20;
    private static final int HP_MODIFIER_FOR_WIZARD = 25;

    public SmallAngel(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "SmallAngel";
    }

    @Override
    public void visit(Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()){
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            knight.getFirstAbility().changeKnightVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
            knight.getSecondAbility().changeKnightVictimModifier(DAMAGE_MODIFIER_FOR_KNIGHT);
            // cresc hp-ul jucatorului
            knight.addHp(HP_MODIFIER_FOR_KNIGHT);
        }
    }

    @Override
    public void visit(Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()){
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            rogue.getFirstAbility().changeRogueVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
            rogue.getSecondAbility().changeRogueVictimModifier(DAMAGE_MODIFIER_FOR_ROGUE);
            // cresc hp-ul jucatorului
            rogue.addHp(HP_MODIFIER_FOR_ROGUE);
        }
    }

    @Override
    public void visit(Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()){
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            wizard.getFirstAbility().changeWizardVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
            wizard.getSecondAbility().changeWizardVictimModifier(DAMAGE_MODIFIER_FOR_WIZARD);
            // cresc hp-ul jucatorului
            wizard.addHp(HP_MODIFIER_FOR_WIZARD);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()){
            // cresc modificatorii de damage pentru fiecare abilitate a jucatorului
            pyromancer.getFirstAbility().changePyromancerVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
            pyromancer.getSecondAbility().changePyromancerVictimModifier(DAMAGE_MODIFIER_FOR_PYROMANCER);
            // cresc hp-ul jucatorului
            pyromancer.addHp(HP_MODIFIER_FOR_PYROMANCER);
        }
    }
}
