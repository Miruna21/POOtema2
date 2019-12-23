package game.angels;

import game.players.*;

public final class DarkAngel extends Angel {
    private static final int HP_MODIFIER_FOR_KNIGHT = 40;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 30;
    private static final int HP_MODIFIER_FOR_ROGUE = 10;
    private static final int HP_MODIFIER_FOR_WIZARD = 20;

    public DarkAngel(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "DarkAngel";
    }

    @Override
    public void visit(final Knight knight) {
        // daca jucatorul este in viata
        if (knight.getLife()) {
            // scad hp-ul jucatorului
            knight.subHp(HP_MODIFIER_FOR_KNIGHT);
            // anunt magicianul de lovitura ingerului
            knight.getEvent().anEventHappened(knight, this, "hit");
            // verific daca ingerul a omorat jucatorul
            verifyPlayerKilledByAngel(knight, this);
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        // daca jucatorul este in viata
        if (rogue.getLife()) {
            // scad hp-ul jucatorului
            rogue.subHp(HP_MODIFIER_FOR_ROGUE);
            // anunt magicianul de lovitura ingerului
            rogue.getEvent().anEventHappened(rogue, this, "hit");
            // verific daca ingerul a omorat jucatorul
            verifyPlayerKilledByAngel(rogue, this);
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        // daca jucatorul este in viata
        if (wizard.getLife()) {
            // scad hp-ul jucatorului
            wizard.subHp(HP_MODIFIER_FOR_WIZARD);
            // anunt magicianul de lovitura ingerului
            wizard.getEvent().anEventHappened(wizard, this, "hit");
            // verific daca ingerul a omorat jucatorul
            verifyPlayerKilledByAngel(wizard, this);
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        // daca jucatorul este in viata
        if (pyromancer.getLife()) {
            // scad hp-ul jucatorului
            pyromancer.subHp(HP_MODIFIER_FOR_PYROMANCER);
            // anunt magicianul de lovitura ingerului
            pyromancer.getEvent().anEventHappened(pyromancer, this, "hit");
            // verific daca ingerul a omorat jucatorul
            verifyPlayerKilledByAngel(pyromancer, this);
        }
    }

    private void verifyPlayerKilledByAngel(final Player player, final Angel angel) {
        // daca jucatorul a fost omorat de inger, anunt magicianul
        if (!player.getLife()) {
            player.getEvent().anEventHappened(player, angel, "kill");
        }
    }
}
