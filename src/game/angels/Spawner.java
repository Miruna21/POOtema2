package game.angels;

import game.players.Knight;
import game.players.Pyromancer;
import game.players.Rogue;
import game.players.Wizard;

public final class Spawner extends Angel {
    private static final int HP_MODIFIER_FOR_KNIGHT = 200;
    private static final int HP_MODIFIER_FOR_PYROMANCER = 150;
    private static final int HP_MODIFIER_FOR_ROGUE = 180;
    private static final int HP_MODIFIER_FOR_WIZARD = 120;

    public Spawner(final int id, final int xPos, final int yPos) {
        super(id, xPos, yPos);
    }

    public String getName() {
        return "Spawner";
    }

    @Override
    public boolean visitLivePlayers() {
        return false;
    }

    @Override
    public void visit(final Knight knight) {
        // daca jucatorul este mort
        if (!knight.getLife()) {
            // readuc jucatorul la viata
            knight.setLife(true);
            // setez noul hp
            knight.setHp(HP_MODIFIER_FOR_KNIGHT);
            // anunt magacianul de ajutorul ingerului
            knight.getEvent().anEventHappened(knight, this, "help");
            // anunt magicianul de aducerea la viata a unui jucator de catre un inger
            knight.getEvent().anEventHappened(knight, this, "revive");
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        // daca jucatorul este mort
        if (!rogue.getLife()) {
            // readuc jucatorul la viata
            rogue.setLife(true);
            // setez noul hp
            rogue.setHp(HP_MODIFIER_FOR_ROGUE);
            // anunt magacianul de ajutorul ingerului
            rogue.getEvent().anEventHappened(rogue, this, "help");
            // anunt magicianul de aducerea la viata a unui jucator de catre un inger
            rogue.getEvent().anEventHappened(rogue, this, "revive");
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        // daca jucatorul este mort
        if (!wizard.getLife()) {
            // readuc jucatorul la viata
            wizard.setLife(true);
            // setez noul hp
            wizard.setHp(HP_MODIFIER_FOR_WIZARD);
            // anunt magacianul de ajutorul ingerului
            wizard.getEvent().anEventHappened(wizard, this, "help");
            // anunt magicianul de aducerea la viata a unui jucator de catre un inger
            wizard.getEvent().anEventHappened(wizard, this, "revive");
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        // daca jucatorul este mort
        if (!pyromancer.getLife()) {
            // readuc jucatorul la viata
            pyromancer.setLife(true);
            // setez noul hp
            pyromancer.setHp(HP_MODIFIER_FOR_PYROMANCER);
            // anunt magacianul de ajutorul ingerului
            pyromancer.getEvent().anEventHappened(pyromancer, this, "help");
            // anunt magicianul de aducerea la viata a unui jucator de catre un inger
            pyromancer.getEvent().anEventHappened(pyromancer, this, "revive");
        }
    }
}
