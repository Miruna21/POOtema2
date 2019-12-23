package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;


public final class LifeGiver extends Angel {
    private static final int HP_MODIFIER_FOR_KNIGHT = 100;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 80;
    private static final int HP_MODIFIER_FOR_ROGUE = 90;
    private static final int HP_MODIFIER_FOR_WIZARD = 120;

    public LifeGiver(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "LifeGiver";
    }

    @Override
    public void visit(final Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()) {
            // cresc hp-ul jucatorului
            knight.addHp(HP_MODIFIER_FOR_KNIGHT);
            // anunt magicianul de ajutorul ingerului
            knight.getEvent().anEventHappened(knight, this, "help");
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()) {
            // cresc hp-ul jucatorului
            rogue.addHp(HP_MODIFIER_FOR_ROGUE);
            // anunt magicianul de ajutorul ingerului
            rogue.getEvent().anEventHappened(rogue, this, "help");
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()) {
            // cresc hp-ul jucatorului
            wizard.addHp(HP_MODIFIER_FOR_WIZARD);
            // anunt magicianul de ajutorul ingerului
            wizard.getEvent().anEventHappened(wizard, this, "help");
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()) {
            // cresc hp-ul jucatorului
            pyromancer.addHp(HP_MODIFIER_FOR_PYROMANCER);
            // anunt magicianul de ajutorul ingerului
            pyromancer.getEvent().anEventHappened(pyromancer, this, "help");
        }
    }
}
