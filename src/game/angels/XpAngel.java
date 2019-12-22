package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public class XpAngel extends Angel {
    private static final int XP_MODIFIER_FOR_KNIGHT = 45;
    private static final int XP_MODIFIER_FOR_PYROMANCER = 50;
    private static final int XP_MODIFIER_FOR_ROGUE = 40;
    private static final int XP_MODIFIER_FOR_WIZARD = 60;

    public XpAngel(int id, int xPos, int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "XpAngel";
    }

    @Override
    public void visit(Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()){
            // cresc xp-ul jucatorului
            knight.gainXp(XP_MODIFIER_FOR_KNIGHT);
        }
    }

    @Override
    public void visit(Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()){
            // cresc xp-ul jucatorului
            rogue.gainXp(XP_MODIFIER_FOR_ROGUE);
        }
    }

    @Override
    public void visit(Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()){
            // cresc xp-ul jucatorului
            wizard.gainXp(XP_MODIFIER_FOR_WIZARD);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()){
            // cresc xp-ul jucatorului
            pyromancer.gainXp(XP_MODIFIER_FOR_PYROMANCER);
        }
    }
}
