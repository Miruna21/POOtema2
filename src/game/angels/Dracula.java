package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class Dracula extends Angel {
    private static final float DAMAGE_MODIFIER_FOR_KNIGHT = 0.2f;
    private static final float DAMAGE_MODIFIER_FOR_PYROMANCER = 0.3f;
    private static final float DAMAGE_MODIFIER_FOR_ROGUE = 0.1f;
    private static final float DAMAGE_MODIFIER_FOR_WIZARD = 0.4f;

    private static final int HP_MODIFIER_FOR_KNIGHT = 60;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 40;
    private static final int HP_MODIFIER_FOR_ROGUE = 35;
    private static final int HP_MODIFIER_FOR_WIZARD = 20;

    public Dracula(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "Dracula";
    }

    @Override
    public void visit(Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()){
            // scad modificatorii de damage pentru fiecare abilitate a jucatorului
            knight.getFirstAbility().changeKnightVictimModifier(-DAMAGE_MODIFIER_FOR_KNIGHT);
            knight.getSecondAbility().changeKnightVictimModifier(-DAMAGE_MODIFIER_FOR_KNIGHT);
            // scad hp-ul jucatorului
            knight.subHp(HP_MODIFIER_FOR_KNIGHT);
            // TODO verific daca ingerul a omorat jucatorul
        }
    }

    @Override
    public void visit(Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()){
            // scad modificatorii de damage pentru fiecare abilitate a jucatorului
            rogue.getFirstAbility().changeRogueVictimModifier(-DAMAGE_MODIFIER_FOR_ROGUE);
            rogue.getSecondAbility().changeRogueVictimModifier(-DAMAGE_MODIFIER_FOR_ROGUE);
            // scad hp-ul jucatorului
            rogue.subHp(HP_MODIFIER_FOR_ROGUE);
            // TODO verific daca ingerul a omorat jucatorul
        }
    }

    @Override
    public void visit(Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()){
            // scad modificatorii de damage pentru fiecare abilitate a jucatorului
            wizard.getFirstAbility().changeWizardVictimModifier(-DAMAGE_MODIFIER_FOR_WIZARD);
            wizard.getSecondAbility().changeWizardVictimModifier(-DAMAGE_MODIFIER_FOR_WIZARD);
            // scad hp-ul jucatorului
            wizard.subHp(HP_MODIFIER_FOR_WIZARD);
            // TODO verific daca ingerul a omorat jucatorul
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()){
            // scad modificatorii de damage pentru fiecare abilitate a jucatorului
            pyromancer.getFirstAbility().changePyromancerVictimModifier(-DAMAGE_MODIFIER_FOR_PYROMANCER);
            pyromancer.getSecondAbility().changePyromancerVictimModifier(-DAMAGE_MODIFIER_FOR_PYROMANCER);
            // scad hp-ul jucatorului
            pyromancer.subHp(HP_MODIFIER_FOR_PYROMANCER);
            // TODO verific daca ingerul a omorat jucatorul
        }
    }
}
