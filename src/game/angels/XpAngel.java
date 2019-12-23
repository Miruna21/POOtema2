package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public final class XpAngel extends Angel {
    private static final int XP_MODIFIER_FOR_KNIGHT = 45;
    private static final int XP_MODIFIER_FOR_PYROMANCER = 50;
    private static final int XP_MODIFIER_FOR_ROGUE = 40;
    private static final int XP_MODIFIER_FOR_WIZARD = 60;

    public XpAngel(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "XPAngel";
    }

    @Override
    public void visit(final Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()) {
            // cresc xp-ul jucatorului
            knight.gainXp(XP_MODIFIER_FOR_KNIGHT);
            // anunt magicianul de ajutorul ingerului
            knight.getEvent().anEventHappened(knight, this, "help");
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()) {
            // cresc xp-ul jucatorului
            rogue.gainXp(XP_MODIFIER_FOR_ROGUE);
            // anunt magicianul de ajutorul ingerului
            rogue.getEvent().anEventHappened(rogue, this, "help");
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()) {
            // cresc xp-ul jucatorului
            wizard.gainXp(XP_MODIFIER_FOR_WIZARD);
            // anunt magicianul de ajutorul ingerului
            wizard.getEvent().anEventHappened(wizard, this, "help");
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()) {
            // cresc xp-ul jucatorului
            pyromancer.gainXp(XP_MODIFIER_FOR_PYROMANCER);
            // anunt magicianul de ajutorul ingerului
            pyromancer.getEvent().anEventHappened(pyromancer, this, "help");
        }
    }
}
